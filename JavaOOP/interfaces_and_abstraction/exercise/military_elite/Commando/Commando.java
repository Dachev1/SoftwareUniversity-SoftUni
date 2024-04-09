package interfaces_and_abstraction.exercise.military_elite.Commando;

import interfaces_and_abstraction.exercise.military_elite.Mission.Mission;

import java.util.Collection;

public interface Commando {
    void addMission(Mission mission);
    Collection<Mission> getMissions();

}
