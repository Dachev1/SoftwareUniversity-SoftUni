package DefiningClasses.Exercise.RawData;

public class Car {

    private String model;
    private Engine engine;
    private  Cargo cargo;
    private Tire[] tires;

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Engine getEngine() {
        return engine;
    }

    public boolean hasTierWithLessPressureThanOne() {
        for (Tire tire : tires) {
            if (tire.getTirePressure() < 1) {
                return true;
            }
        }

        return false;
    }
}
