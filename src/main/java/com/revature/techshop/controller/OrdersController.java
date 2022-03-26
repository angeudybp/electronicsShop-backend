package com.revature.techshop.controller;

import com.revature.techshop.entities.Orders;

import com.revature.techshop.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class OrdersController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/orders")
    public List<Orders> getAllOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping("orders/+{id}")
    public List<Orders> getAllByUser(@PathVariable("id") int id){
        return orderService.getAllByUsers(id);
    }
    @GetMapping("/orders/{id}")
    public Orders getOrdersById(@PathVariable("id") int id){
        return orderService.getOrderById(id);
    }
    @PostMapping("/orders/{id}")
    public Orders addOrder(@RequestBody Orders orders, @PathVariable("id") int id){
        return orderService.addOrder(id,orders);
    }
    @PutMapping("/orders/{id}")
    public String updateOrders(@PathVariable("id") int id, @RequestBody Orders order){
        orderService.updateOrder(id,order);
        return "record updated";
    }
    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable("id") int id){
        orderService.deleteOrder(id);
        return "record deleted successfully";
    }
}
