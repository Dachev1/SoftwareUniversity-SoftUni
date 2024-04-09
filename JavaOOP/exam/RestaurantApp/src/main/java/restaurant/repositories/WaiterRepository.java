package restaurant.repositories;

import restaurant.models.waiter.Waiter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WaiterRepository implements Repository<Waiter> {
    private Collection<Waiter> waiters;

    public WaiterRepository() {
        this.waiters = new ArrayList<>();
    }

    @Override
    public Collection<Waiter> getCollection() {
        return Collections.unmodifiableCollection(this.waiters);
    }

    @Override
    public void add(Waiter waiter) {
        this.waiters.add(waiter);
    }

    @Override
    public boolean remove(Waiter waiter) {
        return this.waiters.remove(waiter);
    }

    @Override
    public Waiter byName(String name) {
        return this.waiters.stream()
                .filter(waiter -> name.equals(waiter.getName()))
                .findFirst()
                .orElse(null);
    }
}
