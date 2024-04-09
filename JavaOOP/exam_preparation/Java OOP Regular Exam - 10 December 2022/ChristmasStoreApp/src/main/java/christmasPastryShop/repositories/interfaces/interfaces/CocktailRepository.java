package christmasPastryShop.repositories.interfaces.interfaces;

public interface CocktailRepository<T> extends Repository<T> {
    T getByName(String name);
}
