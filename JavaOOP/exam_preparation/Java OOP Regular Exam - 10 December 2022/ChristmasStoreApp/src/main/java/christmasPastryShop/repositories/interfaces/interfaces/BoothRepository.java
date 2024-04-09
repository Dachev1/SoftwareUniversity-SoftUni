package christmasPastryShop.repositories.interfaces.interfaces;

public interface BoothRepository<T> extends Repository<T> {
    T getByNumber(int number);
}
