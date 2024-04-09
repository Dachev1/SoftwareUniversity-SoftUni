package bank.entities.bank;

import bank.entities.client.Client;
import bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static bank.common.ExceptionMessages.*;

public abstract class BaseBank implements Bank {
    private String name;
    private int capacity;
    private Collection<Loan> loans;
    private Collection<Client> clients;

    public BaseBank(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.loans = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(BANK_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Client> getClients() {
        return this.clients;
    }

    @Override
    public Collection<Loan> getLoans() {
        return this.loans;
    }

    @Override
    public void addClient(Client client) {
        if (this.clients.size() < this.capacity) {
            this.clients.add(client);
        } else {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY_FOR_CLIENT);
        }
    }

    @Override
    public void removeClient(Client client) {
        this.clients.remove(client);
    }

    @Override
    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    @Override
    public int sumOfInterestRates() {
        int interestRatesSum = 0;
        for (Loan loan : this.loans) {
            interestRatesSum += loan.getInterestRate();
        }
        return interestRatesSum;
    }

    @Override
    public String getStatistics() {
        return String.format(
                "Name: %s, Type: %s\n" +
                        "Clients: %s\n" +
                        "Loans: %d, Sum of interest rates: %d\n",
                this.name, this.getClass().getSimpleName(),
                this.clients.stream().map(Client::getName).collect(Collectors.joining(", ")),
                this.loans.size(), sumOfInterestRates());
    }
}
