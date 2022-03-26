package com.revature.techshop.services;

import com.revature.techshop.entities.Orders;
import com.revature.techshop.entities.User;
import com.revature.techshop.repository.OrdersRepository;
import com.revature.techshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    private OrdersRepository repository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Orders> getAllOrders() {
        return repository.findAll();
    }

    @Override
    public List<Orders> getAllByUsers(int id) {
        List<Orders> list = new ArrayList<>();
        for (Orders order: getAllOrders()
             ) {
            if (order.getUser().getUserId()==id){
                list.add(order);
            }
        }
        return list;
    }

    @Override
    public Orders getOrderById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Orders addOrder(int id, Orders order) {
        User user = userRepository.findById(id).get();
        order.setUser(user);
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
