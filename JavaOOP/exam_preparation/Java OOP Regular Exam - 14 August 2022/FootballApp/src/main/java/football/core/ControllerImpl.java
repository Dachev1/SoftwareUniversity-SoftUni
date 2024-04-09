package football.core;


import football.entities.field.Field;
import football.entities.field.types.ArtificialTurf;
import football.entities.field.types.NaturalGrass;
import football.entities.player.ArtificialTurf.Women;
import football.entities.player.NaturalGrass.Men;
import football.entities.player.Player;
import football.entities.supplement.Supplement;
import football.entities.supplement.types.Liquid;
import football.entities.supplement.types.Powdered;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SupplementRepository supplement;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        switch (fieldType) {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                break;
            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                break;
            default:
                throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        this.fields.add(field);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement;
        switch (type) {
            case "Powdered":
                supplement = new Powdered();
                break;
            case "Liquid":
                supplement = new Liquid();
                break;
            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        this.supplement.add(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement supplement = this.supplement.findByType(supplementType);
        if (supplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        } else {
            Field fieldToAdd = getFieldByName(fieldName);
            fieldToAdd.addSupplement(supplement);
            this.supplement.remove(supplement);
            return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
        }
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;
        switch (playerType) {
            case "Men":
                player = new Men(playerName, nationality, strength);
                break;
            case "Women":
                player = new Women(playerName, nationality, strength);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        return isSuitable(fieldName, playerType, player);
    }
    @Override
    public String dragPlayer(String fieldName) {
        Field field = getFieldByName(fieldName);
        field.getPlayers().forEach(Player::stimulation);
        return String.format(PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = getFieldByName(fieldName);
        int totalStrengthOfPlayers = 0;
        for (Player player : field.getPlayers()) {
            totalStrengthOfPlayers += player.getStrength();
        }
        return String.format(STRENGTH_FIELD, fieldName, totalStrengthOfPlayers);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        for (Field field : this.fields) {
            output.append(field.getInfo());
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    private Field getFieldByName(String fieldName) {
        return this.fields.stream().filter(field -> fieldName.equals(field.getName())).findFirst().orElse(null);
    }
    private String isSuitable(String fieldName, String playerType, Player player) {
        if (fieldName.equals("ArtificialTurf") && playerType.equals("Men")) {
            return FIELD_NOT_SUITABLE;
        } else if (fieldName.equals("NaturalGrass") && playerType.equals("Women")) {
            return FIELD_NOT_SUITABLE;
        } else {
            Field field = getFieldByName(fieldName);
            field.addPlayer(player);
            return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
        }
    }
}
