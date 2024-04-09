package restaurant.core;

import restaurant.models.client.Client;
import restaurant.models.client.ClientImpl;
import restaurant.models.orders.TakenOrders;
import restaurant.models.orders.TakenOrdersImpl;
import restaurant.models.waiter.FullTimeWaiter;
import restaurant.models.waiter.HalfTimeWaiter;
import restaurant.models.waiter.Waiter;
import restaurant.models.working.Working;
import restaurant.models.working.WorkingImpl;
import restaurant.repositories.ClientRepository;
import restaurant.repositories.Repository;
import restaurant.repositories.WaiterRepository;

import static restaurant.common.ConstantMessages.*;
import static restaurant.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Waiter> waiterRepository;
    private Repository<Client> clientRepository;
    private Working working;
    private int servedClientsCount;

    public ControllerImpl() {
        this.waiterRepository = new WaiterRepository();
        this.clientRepository = new ClientRepository();
        this.working = new WorkingImpl();
        this.servedClientsCount = 0;
    }

    @Override
    public String addWaiter(String type, String waiterName) {
        Waiter waiter;
        switch (type) {
            case "FullTimeWaiter":
                waiter = new FullTimeWaiter(waiterName);
                break;
            case "HalfTimeWaiter":
                waiter = new HalfTimeWaiter(waiterName);
                break;
            default:
                throw new IllegalArgumentException(WAITER_INVALID_TYPE);
        }
        this.waiterRepository.add(waiter);
        return String.format(WAITER_ADDED, type, waiterName);
    }

    @Override
    public String addClient(String clientName, String... orders) {
        Client client = new ClientImpl(clientName);
        for (String order : orders) {
            client.getClientOrders().add(order);
        }
        this.clientRepository.add(client);
        return String.format(CLIENT_ADDED, clientName);
    }

    @Override
    public String removeWaiter(String waiterName) {
        Waiter waiter = this.waiterRepository.byName(waiterName);
        if (waiter == null) {
            throw new IllegalArgumentException(String.format(WAITER_DOES_NOT_EXIST, waiter));
        }
        this.waiterRepository.remove(waiter);
        return String.format(WAITER_REMOVE, waiterName);
    }

    @Override
    public String removeClient(String clientName) {
        Client client = this.clientRepository.byName(clientName);
        if (client == null) {
            throw new IllegalArgumentException(String.format(CLIENT_DOES_NOT_EXIST, clientName));
        }
        this.clientRepository.remove(client);
        return String.format(CLIENT_REMOVE, clientName);
    }

    @Override
    public String startWorking(String clientName) {
        if (this.waiterRepository.getCollection().isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_WAITERS);
        }
       Client client = this.clientRepository.byName(clientName);
        this.working.takingOrders(client, this.waiterRepository.getCollection());
        this.servedClientsCount++;
        return String.format(ORDERS_SERVING, clientName);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format(FINAL_CLIENTS_COUNT, this.servedClientsCount));
        output.append(System.lineSeparator());
        output.append(FINAL_WAITERS_STATISTICS);
        output.append(System.lineSeparator());
        for (Waiter waiter : this.waiterRepository.getCollection()) {
            output.append(String.format(FINAL_WAITER_NAME, waiter.getName()));
            output.append(System.lineSeparator());
            output.append(String.format(FINAL_WAITER_EFFICIENCY, waiter.getEfficiency()));
            output.append(System.lineSeparator());
            if (waiter.takenOrders().getOrdersList().isEmpty()) {
                output.append(String.format(FINAL_WAITER_ORDERS, "None"));
            } else {
                output.append(String.format(FINAL_WAITER_ORDERS,
                        String.join(FINAL_WAITER_ORDERS_DELIMITER, waiter.takenOrders().getOrdersList())));
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
