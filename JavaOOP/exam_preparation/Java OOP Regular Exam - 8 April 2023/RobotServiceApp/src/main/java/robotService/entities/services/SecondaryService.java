package robotService.entities.services;

public class SecondaryService extends BaseService{
    private static final int INITIAL_CAPACITY = 15;

    public SecondaryService(String name) {
        super(name, INITIAL_CAPACITY);
    }
}
