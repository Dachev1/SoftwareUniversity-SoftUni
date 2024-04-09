package harpoonDiver.repositories;

import harpoonDiver.models.diver.Diver;

import java.sql.Driver;
import java.util.*;

public class DiverRepository implements Repository<Diver> {
    private final Map<String, Diver> divers;

    public DiverRepository() {
        this.divers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Diver> getCollection() {
        return Collections.unmodifiableCollection(this.divers.values());
    }

    @Override
    public void add(Diver diver) {
        divers.put(diver.getName(), diver);
    }

    @Override
    public boolean remove(Diver diver) {
        return divers.remove(diver.getName()) != null;
    }

    @Override
    public Diver byName(String name) {
        return divers.get(name);
    }
}
