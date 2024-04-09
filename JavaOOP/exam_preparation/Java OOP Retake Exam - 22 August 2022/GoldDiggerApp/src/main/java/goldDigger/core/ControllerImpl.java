package goldDigger.core;

import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;
    private Operation operation;
    private int inspectedSpotCount;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
        this.operation = new OperationImpl();
        this.inspectedSpotCount = 0;
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;
        switch (kind) {
            case "Anthropologist":
                discoverer = new Anthropologist(discovererName);
                break;
            case "Archaeologist":
                discoverer = new Archaeologist(discovererName);
                break;
            case "Geologist":
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }
        this.discovererRepository.add(discoverer);
        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        Arrays.stream(exhibits)
                .forEach(exhibit -> spot.getExhibits().add(exhibit));
        this.spotRepository.add(spot);
        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = discovererRepository.byName(discovererName);
        if (this.discovererRepository.remove(discoverer)) {
            return String.format(DISCOVERER_EXCLUDE, discovererName);
        }
        throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
    }

    @Override
    public String inspectSpot(String spotName) {
        Spot spotToInspect = this.spotRepository.byName(spotName);
        Collection<Discoverer> discoverers = this.discovererRepository
                .getCollection()
                .stream()
                .filter(discoverer -> discoverer.getEnergy() > 45)
                .collect(Collectors.toList());
        if (discoverers.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        this.operation.startOperation(spotToInspect, discoverers);
        this.inspectedSpotCount++;
        List<Discoverer> excludedDiscoverers = discoverers.stream()
                .filter(discoverer -> !discoverer.canDig()).collect(Collectors.toList());
        return String.format(INSPECT_SPOT, spotName, excludedDiscoverers.size());
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format(FINAL_SPOT_INSPECT, this.inspectedSpotCount));
        output.append(System.lineSeparator());
        output.append(FINAL_DISCOVERER_INFO);
        output.append(System.lineSeparator());
        for (Discoverer discoverer : this.discovererRepository.getCollection()) {
            output.append(String.format(FINAL_DISCOVERER_NAME, discoverer.getName()));
            output.append(System.lineSeparator());
            output.append(String.format(FINAL_DISCOVERER_ENERGY, discoverer.getEnergy()));
            output.append(System.lineSeparator());
            if (discoverer.getMuseum().getExhibits().isEmpty()) {
                output.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, "None"));
            } else {
                output.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS,
                        String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER,
                                discoverer.getMuseum().getExhibits())));
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
