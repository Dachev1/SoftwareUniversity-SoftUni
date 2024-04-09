package restaurant.models.working;

import restaurant.models.client.Client;
import restaurant.models.waiter.Waiter;

import java.util.Collection;

public class WorkingImpl implements Working{
    @Override
    public void takingOrders(Client client, Collection<Waiter> waiters) {
        Collection<String> clientOrders = client.getClientOrders();

        for (Waiter waiter : waiters) {
            while (waiter.canWork() && clientOrders.iterator().hasNext()) {
                waiter.work();

                String currentOrder = clientOrders.iterator().next();
                waiter.takenOrders().getOrdersList().add(currentOrder);
                clientOrders.remove(currentOrder);
            }
        }
    }
}
