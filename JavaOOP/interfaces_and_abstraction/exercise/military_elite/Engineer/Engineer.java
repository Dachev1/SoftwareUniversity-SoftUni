package interfaces_and_abstraction.exercise.military_elite.Engineer;

import interfaces_and_abstraction.exercise.military_elite.Repair.Repair;
import interfaces_and_abstraction.exercise.military_elite.SpecialisedSoldier.SpecialisedSoldier;

import java.util.List;

public interface Engineer extends SpecialisedSoldier {

     void addRepair(Repair repair);
     List<Repair> getRepairs();

}
