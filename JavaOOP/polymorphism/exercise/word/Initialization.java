package polymorphism.exercise.word;

public class Initialization {
    public static CommandInterface buildCommandInterface(StringBuilder text) {
        CommandImpl commandInterface = new CommandImpl(text);
        commandInterface.init();
        return commandInterface;
    }
}
