package DefiningClasses.Exercise.CatLady;

public class Cymric extends Cat{
    private double furLength;

    public Cymric(String type, String name, double furLength) {
        super(type, name);
        this.furLength = furLength;
    }

    public String toString() {
        return String.format("%s %s %.2f", super.getType(), super.getName(),furLength);
    }
}
