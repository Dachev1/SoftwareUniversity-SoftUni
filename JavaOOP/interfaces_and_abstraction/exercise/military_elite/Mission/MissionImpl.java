package interfaces_and_abstraction.exercise.military_elite.Mission;

public class MissionImpl implements Mission{
    private String CodeName;
    private Status status;

    public MissionImpl(String CodeName, String status) {
        this.CodeName = CodeName;
        setStatus(status);
    }

    @Override
    public String getCodeName() {
        return CodeName;
    }

    @Override
    public Status getState() {
        return status;
    }


    private void setStatus(String status) {
        if (!status.equals("inProgress") && !status.equals("finished")) {
            throw new IllegalArgumentException("Invalid mission state!");
        }
        this.status = Status.valueOf(status);
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.CodeName, this.status.toString());
    }
}