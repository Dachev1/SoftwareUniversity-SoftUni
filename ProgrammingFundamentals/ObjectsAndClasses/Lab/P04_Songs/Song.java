package ProgrammingFundamentals.ObjectsAndClasses.P04_Songs;

public class Song {
    private String listType;
    private String name;
    private String time;

    public Song(String listType, String name, String time) {
        this.listType = listType;
        this.name = name;
        this.time = time;
    }

    public String getListType() {
        return listType;
    }

    public String getName() {
        return name;
    }
}
