package reflection.exercise.barracks_wars;

import reflection.exercise.barracks_wars.interfaces.Repository;
import reflection.exercise.barracks_wars.interfaces.Runnable;
import reflection.exercise.barracks_wars.interfaces.UnitFactory;
import reflection.exercise.barracks_wars.core.Engine;
import reflection.exercise.barracks_wars.core.factories.UnitFactoryImpl;
import reflection.exercise.barracks_wars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
