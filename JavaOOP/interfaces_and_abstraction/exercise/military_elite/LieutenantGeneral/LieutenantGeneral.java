package interfaces_and_abstraction.exercise.military_elite.LieutenantGeneral;

import interfaces_and_abstraction.exercise.military_elite.Private.Private;
import interfaces_and_abstraction.exercise.military_elite.Soldier.Soldier;

import java.util.List;

public interface LieutenantGeneral extends Private {
    void addPrivate(Soldier priv);
    List<Soldier> getPrivates();
}
