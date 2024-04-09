package vehicleShop.repositories;

import vehicleShop.models.worker.Worker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WorkerRepository implements Repository<Worker> {
    private Collection<Worker> workers;

    public WorkerRepository() {
        this.workers = new ArrayList<>();
    }

    @Override
    public Collection<Worker> getWorkers() {
        return Collections.unmodifiableCollection(this.workers);
    }

    @Override
    public void add(Worker worker) {
        this.workers.add(worker);
    }

    @Override
    public boolean remove(Worker worker) {
        return this.workers.remove(worker);
    }

    @Override
    public Worker findByName(String name) {
        return this.workers.stream()
                .filter(worker -> name.equals(worker.getName()))
                .findFirst()
                .orElse(null);
    }
}
