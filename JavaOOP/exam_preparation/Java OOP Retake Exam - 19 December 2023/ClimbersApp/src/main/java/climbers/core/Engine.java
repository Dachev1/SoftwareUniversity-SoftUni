package climbers.core;

public interface Engine extends Runnable{
    String addClimber(String[] data);

    String addMountain(String[] data);

    String removeClimber(String[] data);

    String startClimbing(String[] data);

    String getStatistics();
}
