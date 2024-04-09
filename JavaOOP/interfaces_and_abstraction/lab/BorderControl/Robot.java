package interfaces_and_abstraction.lab.BorderControl;

public class Robot implements Identifiable {
    private String model;
    private String id;


    public Robot(String model, String id) {
        this.id = id;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
