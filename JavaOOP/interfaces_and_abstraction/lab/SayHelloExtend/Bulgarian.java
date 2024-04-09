package interfaces_and_abstraction.lab.SayHelloExtend;

public class Bulgarian extends BasePerson{
    protected Bulgarian(String name) {
        super(name);
    }
    @Override
    public String sayHello() {
        return "Здравей";
    }
}
