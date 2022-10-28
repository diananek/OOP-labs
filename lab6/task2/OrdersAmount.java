package lab6.task2;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import lab6.task2.models.Customer;
import lab6.task2.models.Order;
import lab6.task2.models.Product;

public class OrdersAmount {
    public static void main(String[] args) {
        ArrayList<Order> ordersList = createOrders();
        double ordersSum = getSum(ordersList);
        System.out.println(ordersSum);
    }
    private static ArrayList<Order> createOrders() {
        ArrayList<Order> ordersList = new ArrayList<Order>();

        Product milk  = new Product();
        milk.setId(1L);
        milk.setName("Milk");
        milk.setPrice(55.0);

        Product bread  = new Product();
        milk.setId(2L);
        milk.setName("Bread");
        milk.setPrice(31.4);

        Product apple  = new Product();
        milk.setId(3L);
        milk.setName("Apple");
        milk.setPrice(102.25);

        Customer firstCustomer = new Customer();
        firstCustomer.setId(1L);
        firstCustomer.setName("Marta Kauffman");
        firstCustomer.setTier(1);

        Set<Product> firstProductSet = new HashSet<Product>();
        firstProductSet.add(milk);
        firstProductSet.add(bread);

        Order firstOrder = new Order();
        firstOrder.setId(1L);
        firstOrder.setOrderDate(LocalDate.of(2020, 2, 2));
        firstOrder.setDeliveryDate(LocalDate.of(2020, 2, 2));
        firstOrder.setStatus("Completed");
        firstOrder.setCustomer(firstCustomer);
        firstOrder.setProducts(firstProductSet);


        Customer secondCustomer = new Customer();
        firstCustomer.setId(2L);
        firstCustomer.setName("Lisa Kudrow");
        firstCustomer.setTier(1);

        Set<Product> secondProductSet = new HashSet<Product>();
        secondProductSet.add(apple);
        secondProductSet.add(bread);


        Order secondOrder = new Order();
        secondOrder.setId(2L);
        secondOrder.setOrderDate(LocalDate.of(2020, 2, 15));
        secondOrder.setDeliveryDate(LocalDate.of(2020, 2, 15));
        secondOrder.setStatus("Completed");
        secondOrder.setCustomer(secondCustomer);
        secondOrder.setProducts(secondProductSet);

        ordersList.add(firstOrder);
        ordersList.add(secondOrder);
        return ordersList;
    }

    private static double getSum(ArrayList<Order> ordersList) {
        double ordersSum = ordersList.stream()
            .filter(order -> order.getOrderDate().getYear() == 2020  && order.getOrderDate().getMonth().equals(Month.FEBRUARY))
            .flatMap(order -> order.getProducts().stream())
            .mapToDouble(Product::getPrice)
            .sum();
        return ordersSum;
    }
}
