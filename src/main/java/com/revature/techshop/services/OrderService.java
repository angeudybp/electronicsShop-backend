package com.revature.techshop.services;

import com.revature.techshop.entities.Orders;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface OrderService {
    public List<Orders> getAllOrders();
    public List<Orders> getAllByUsers(int id);
    public Orders getOrderById(int id);
    public Orders addOrder(int id, Orders order);
    public void updateOrder(int id, Orders order);
    public void deleteOrder(int id);
}
