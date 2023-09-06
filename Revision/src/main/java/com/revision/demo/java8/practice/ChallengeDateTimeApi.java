package com.revision.demo.java8.practice;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ChallengeDateTimeApi {
    public static void main(String[] args) {
        Order order = new Order("cola", LocalDateTime.now());
        // should return the order
        System.out.println("Not empty: " + OrderUtil.getOrdersAfterDate(Arrays.asList(order), LocalDateTime.of(1920, 1, 1,1,1)));
        // should filter the order
        System.out.println("Empty: " + OrderUtil.getOrdersAfterDate(Arrays.asList(order), LocalDateTime.now()));

    }
}

class OrderUtil {
    public static ArrayList<Order> getOrdersAfterDate(List<Order> newOrders, LocalDateTime date) {
        ArrayList<Order> result = new ArrayList<>();

        for (Order order : newOrders) {
            if (order.getDate().isAfter(date)) {
            	result.add(order);
            }
            
        }

        return result;
    }
}

class Order {
    private String name;
    private LocalDateTime date;

    public Order(String name, LocalDateTime date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("Order '%s'\nDate: '%s'", name, date);
    }
}

