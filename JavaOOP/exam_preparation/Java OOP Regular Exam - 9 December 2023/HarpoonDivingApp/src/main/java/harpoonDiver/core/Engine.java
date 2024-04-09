package harpoonDiver.core;

public interface Engine extends Runnable{

    String addDiver(String[] data);

    String addDivingSite(String[] data);

    String removeDiver(String[] data);

    String startDiving(String[] data);

    String getStatistics();
}
