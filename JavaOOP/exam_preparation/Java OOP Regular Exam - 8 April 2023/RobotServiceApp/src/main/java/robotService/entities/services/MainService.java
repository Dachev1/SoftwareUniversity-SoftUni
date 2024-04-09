package robotService.entities.services;

public class MainService extends BaseService {
    private static final int INITIAL_CAPACITY = 30;

    public MainService(String name) {
        super(name, INITIAL_CAPACITY);
    }
}
