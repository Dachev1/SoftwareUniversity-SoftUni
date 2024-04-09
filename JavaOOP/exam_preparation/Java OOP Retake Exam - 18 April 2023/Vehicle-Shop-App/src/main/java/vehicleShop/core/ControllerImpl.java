package vehicleShop.core;

import vehicleShop.common.ConstantMessages;
import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static vehicleShop.common.ConstantMessages.*;
import static vehicleShop.common.ExceptionMessages.*;
    public class ControllerImpl implements Controller {
        private WorkerRepository workerRepository = new WorkerRepository();
        private VehicleRepository vehicleRepository = new VehicleRepository();
        private Shop shop = new ShopImpl();

        @Override
        public String addWorker(String type, String workerName) {
            Worker worker;
            if (type.equals("SecondShift")) {
                worker = new SecondShift(workerName);
            } else if (type.equals("FirstShift")) {
                worker = new FirstShift(workerName);
            } else {
                throw new IllegalArgumentException(ExceptionMessages.WORKER_TYPE_DOESNT_EXIST);
            }
            workerRepository.add(worker);
            return String.format(ConstantMessages.ADDED_WORKER, type, workerName);
        }

        @Override
        public String addToolToWorker(String workerName, int power) {
            if (workerRepository.findByName(workerName) == null) {
                throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
            }
            Tool tool = new ToolImpl(power);
            workerRepository.findByName(workerName).addTool(tool);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
        }

        @Override
        public String addVehicle(String vehicleName, int strengthRequired) {
            Vehicle vehicle = new VehicleImpl(vehicleName, strengthRequired);
            vehicleRepository.add(vehicle);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
        }

        @Override
        public String makingVehicle(String vehicleName) {
            List<Worker> collect = workerRepository.getWorkers().stream().filter(helper -> helper.getStrength() > 70)
                    .collect(Collectors.toList());
            if (collect.isEmpty()) {
                throw new IllegalArgumentException(ExceptionMessages.NO_WORKER_READY);
            }
            int brokenInstruments = 0;
            Vehicle vehicle = vehicleRepository.findByName(vehicleName);
            for (Worker worker : collect) {
                shop.make(vehicle, worker);
                brokenInstruments += (int) worker.getTools().stream().filter(Tool::isUnfit).count();
                if (vehicle.reached()){
                    break;
                }
            }
            if (vehicle.reached()) {
                return String.format(ConstantMessages.VEHICLE_DONE, vehicleName, "done") +
                        String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
            }
            return String.format(ConstantMessages.VEHICLE_DONE, vehicleName, "not done") +
                    String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
        }

        @Override
        public String statistics() {
            int size = (int) vehicleRepository.getWorkers().stream().filter(Vehicle::reached).count();
            List<String> collect = workerRepository.getWorkers().stream()
                    .map(helper -> String.format("Name: %s, Strength: %d%n" +
                                    "Tools: %d fit left%n", helper.getName(), helper.getStrength(),
                            (int) helper.getTools().stream().filter(instrument -> !instrument.isUnfit()).count())).collect(Collectors.toList());
            return String.format("%d vehicles are ready!%n", size) + String.format("Info for workers:%n") + String.join("", collect).trim();
        }
    }

