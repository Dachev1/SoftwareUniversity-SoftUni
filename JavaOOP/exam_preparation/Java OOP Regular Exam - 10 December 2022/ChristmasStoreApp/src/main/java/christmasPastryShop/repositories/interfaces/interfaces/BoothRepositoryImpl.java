package christmasPastryShop.repositories.interfaces.interfaces;

import christmasPastryShop.entities.booths.interfaces.Booth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BoothRepositoryImpl implements BoothRepository<Booth> {
    private Collection<Booth> booths;

    public BoothRepositoryImpl() {
        this.booths = new ArrayList<>();
    }

    @Override
    public Booth getByNumber(int boothNumber) {
        return this.booths.stream().filter(booth -> booth.getBoothNumber() == boothNumber)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Booth> getAll() {
        return Collections.unmodifiableCollection(this.booths);
    }

    @Override
    public void add(Booth booth) {
        this.booths.add(booth);
    }
}
