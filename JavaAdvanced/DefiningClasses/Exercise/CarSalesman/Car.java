package DefiningClasses.Exercise.CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;


    public Car(String model, Engine engine) {
        this(model, engine, -1, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, -1, color);
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }


    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        String displacement;
        String weight;

        if (engine.getDisplacement() == -1) {
            displacement = "n/a";
        } else {
            displacement = String.valueOf(engine.getDisplacement());
        }

        if (getWeight() == - 1) {
            weight = "n/a";
        } else {
            weight = String.valueOf(getWeight());
        }

        return String.format("%s:%n" +
                        "%s:%n" +
                        "Power: %d%n" +
                        "Displacement: %s%n" +
                        "Efficiency: %s%n" +
                        "Weight: %s%n" +
                        "Color: %s",
                getModel(),
                engine.getModel(),
                engine.getPower(),
                displacement,
                engine.getEfficiency(),
                weight,
                getColor());
    }
}
