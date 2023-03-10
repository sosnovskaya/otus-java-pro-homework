package ru.otus.homework;


import java.util.AbstractMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class CustomerService {

    private final NavigableMap<Customer, String> customers = new TreeMap<>((o1, o2) -> (int) (o1.getScores() - o2.getScores()));

    public Map.Entry<Customer, String> getSmallest() {
        return copy(customers.firstEntry());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return copy(customers.higherEntry(customer));
    }

    public void add(Customer customer, String data) {
        customers.put(customer, data);
    }

    private Map.Entry<Customer, String> copy(Map.Entry<Customer, String> entry) {
        return entry == null ? null : new AbstractMap.SimpleEntry<>(new Customer(entry.getKey()), entry.getValue());
    }
}
