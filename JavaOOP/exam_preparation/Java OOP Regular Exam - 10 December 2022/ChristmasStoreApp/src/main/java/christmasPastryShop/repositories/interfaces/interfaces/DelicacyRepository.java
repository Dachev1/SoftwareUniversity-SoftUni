package christmasPastryShop.repositories.interfaces.interfaces;

public interface DelicacyRepository<T> extends Repository<T> {
    T getByName(String name);
}
