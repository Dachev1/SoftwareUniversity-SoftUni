package handball.core;

import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;
import handball.entities.gameplay.BaseGameplay;
import handball.entities.gameplay.Gameplay;
import handball.entities.gameplay.Indoor;
import handball.entities.gameplay.Outdoor;
import handball.entities.team.Indoor.Germany;
import handball.entities.team.Outdoor.Bulgaria;
import handball.entities.team.Team;
import handball.repositories.EquipmentRepository;
import handball.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static handball.common.ConstantMessages.*;
import static handball.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository equipment;
    private Collection<Gameplay> gameplays;

    public ControllerImpl() {
        this.equipment = new EquipmentRepository();
        this.gameplays = new ArrayList<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        Gameplay gameplay;
        switch (gameplayType) {
            case "Outdoor":
                gameplay = new Outdoor(gameplayName);
                break;
            case "Indoor":
                gameplay = new Indoor(gameplayName);
                break;
            default:
                throw new NullPointerException(INVALID_GAMEPLAY_TYPE);
        }
        this.gameplays.add(gameplay);
        return String.format(SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment currentEquipment;
        switch (equipmentType) {
            case "Kneepad":
                currentEquipment = new Kneepad();
                break;
            case "ElbowPad":
                currentEquipment = new ElbowPad();
                break;
            default:
                throw new IllegalArgumentException(INVALID_EQUIPMENT_TYPE);
        }
        this.equipment.add(currentEquipment);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment equipmentToAddInTheGame = this.equipment.findByType(equipmentType);
        if (equipmentToAddInTheGame == null) {
            throw new IllegalArgumentException(String.format(NO_EQUIPMENT_FOUND, equipmentType));
        } else {
            this.equipment.remove(equipmentToAddInTheGame);
            Gameplay game = getGameplay(gameplayName);
            game.addEquipment(equipmentToAddInTheGame);
            return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
        }
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Team team;
        switch (teamType) {
            case "Bulgaria":
                team = new Bulgaria(teamName, country, advantage);
                break;
            case "Germany":
                team = new Germany(teamName, country, advantage);
                break;
            default:
                throw new IllegalArgumentException(INVALID_TEAM_TYPE);
        }
        Gameplay game = getGameplay(gameplayName);
        if ("Indoor".equals(gameplayName) && "Bulgaria".equals(teamType)) {
            return GAMEPLAY_NOT_SUITABLE;
        } else if ("Outdoor".equals(gameplayName) && "Germany".equals(teamType)) {
            return GAMEPLAY_NOT_SUITABLE;
        } else {
            game.addTeam(team);
            return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
        }
}
    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay gameplay = getGameplay(gameplayName);
        gameplay.teamsInGameplay();

        return String.format(TEAMS_PLAYED, gameplay.getTeam().size());
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        return String.format(ADVANTAGE_GAMEPLAY, gameplayName, getGameplay(gameplayName)
        .getTeam().stream().mapToInt(Team::getAdvantage).sum());
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        this.gameplays.forEach(stringBuilder::append);
        return stringBuilder.toString().trim();
    }

    private Gameplay getGameplay(String gameplayName) {
        Gameplay game = this.gameplays.stream()
                .filter(gameplay -> gameplayName.equals(gameplay.getName()))
                .findFirst()
                .orElse(null);
        return game;
    }
}
