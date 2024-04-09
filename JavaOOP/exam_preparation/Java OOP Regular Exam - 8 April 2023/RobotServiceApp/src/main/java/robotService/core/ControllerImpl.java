package robotService.core;

import robotService.entities.robot.Robot;
import robotService.entities.robot.mainService.MaleRobot;
import robotService.entities.robot.secondaryService.FemaleRobot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        Service service;
        switch (type) {
            case "MainService":
                service = new MainService(name);
                break;
            case "SecondaryService":
                service = new SecondaryService(name);
                break;
            default:
                throw new NullPointerException(INVALID_SERVICE_TYPE);
        }
        this.services.add(service);
        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement;
        switch (type) {
            case "PlasticArmor":
                supplement = new PlasticArmor();
                break;
            case "MetalArmor":
                supplement = new MetalArmor();
                break;
            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        this.supplements.addSupplement(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement supplementForService = this.supplements.findFirst(supplementType);

        if (supplementForService == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        Service service = getServiceByName(serviceName);
        service.addSupplement(supplementForService);
        this.supplements.removeSupplement(supplementForService);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot;
        switch (robotType) {
            case "MaleRobot":
                robot = new MaleRobot(robotName, robotKind, price);
                break;
            case "FemaleRobot":
                robot = new FemaleRobot(robotName, robotKind, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }
        Service service = getServiceByName(serviceName);
        String output;
        if (!isSuitableService(robotType, service)) {
            output = UNSUITABLE_SERVICE;
        } else {
            service.addRobot(robot);
            output = String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
        }
        return output;
    }

    @Override
    public String feedingRobot(String serviceName) {
        List<Robot> robotsToFeed = new ArrayList<>(getServiceByName(serviceName).getRobots());
        robotsToFeed.forEach(Robot::eating);
        return String.format(FEEDING_ROBOT, robotsToFeed.size());
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service service = getServiceByName(serviceName);

        double robotPrices = service.getRobots().stream()
                .mapToDouble(Robot::getPrice).sum();
        double supplementPrices = service.getSupplements().stream()
                .mapToDouble(Supplement::getPrice).sum();

        return String.format(VALUE_SERVICE, serviceName, robotPrices + supplementPrices);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        for (Service service : this.services) {
            output.append(service.getStatistics());
        }
        return output.toString().trim();
    }

    private boolean isSuitableService(String robotType, Service service) {
        String serviceType = service.getClass().getSimpleName();

        if (robotType.equals("FemaleRobot") && serviceType.equals("SecondaryService")) {
            return true;
        } else if (robotType.equals("MaleRobot") && serviceType.equals("MainService")) {
            return true;
        }

        return false;
    }

    private Service getServiceByName(String serviceName) {
        return this.services.stream().filter(s -> serviceName.equals(s.getName())).findFirst().orElse(null);
    }
}
