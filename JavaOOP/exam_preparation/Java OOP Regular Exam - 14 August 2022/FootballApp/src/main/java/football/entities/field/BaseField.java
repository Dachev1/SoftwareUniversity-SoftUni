package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int sumEnergy() {
        int sumEnergy = 0;
        for (Supplement supplement : this.supplements) {
            sumEnergy += supplement.getEnergy();
        }
        return sumEnergy;
    }

    @Override
    public void addPlayer(Player player) {
        if (this.players.size() < this.capacity) {
            this.players.add(player);
        } else {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void drag() {
        this.players.forEach(Player::stimulation);
    }

    @Override
    public String getInfo() {
        StringBuilder output = new StringBuilder()
                .append(String.format("%s (%s):", this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append("Player: ");

        if (this.players.isEmpty()) {
            output.append("none");
        } else {

            output.append(this.players.stream().map(Player::getName).collect(Collectors.joining(" ")));
        }

        output
                .append(System.lineSeparator())
                .append("Supplement: ")
                .append(this.supplements.size())
                .append(System.lineSeparator())
                .append("Energy: ")
                .append(this.sumEnergy());

        return output.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
