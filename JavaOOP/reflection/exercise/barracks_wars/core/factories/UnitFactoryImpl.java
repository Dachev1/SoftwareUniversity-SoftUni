package reflection.exercise.barracks_wars.core.factories;

import reflection.exercise.barracks_wars.interfaces.Unit;
import reflection.exercise.barracks_wars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"reflection.exercise.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		// unitType: Archer, Pikeman, Swordsman
		try {
			Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType); // take the correct class
			Constructor<Unit> constructor = unitClass.getDeclaredConstructor(); // default constructor
			constructor.setAccessible(true);
			return constructor.newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
				 IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
