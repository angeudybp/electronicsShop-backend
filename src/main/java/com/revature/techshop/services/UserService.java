package com.revature.techshop.services;

import com.revature.techshop.entities.Orders;
import com.revature.techshop.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public User addUser(User user);
    public void updateUser(int id, User user);
    public void deleteUser(int id);
    public User login(String username, String password);
}
