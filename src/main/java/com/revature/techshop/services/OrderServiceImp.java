package com.revature.techshop.services;

import com.revature.techshop.entities.Orders;
import com.revature.techshop.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    private OrdersRepository repository;

    @Override
    public List<Orders> getAllOrders() {
        return repository.findAll();
    }

    @Override
    public Orders getOrderById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Orders addOrder(Orders order) {
        return repository.save(order);
    }

    @Override
    public void updateOrder(int id, Orders order) {
        Orders orderDb = repository.findById(id).get();
        orderDb.setUser(order.getUser());
        orderDb.setAmount(order.getAmount());
        repository.save(orderDb);
    }

    @Override
    public void deleteOrder(int id) {
        repository.deleteById(id);
    }
}
