package com.revature.techshop.services;

import com.revature.techshop.entities.User;
import com.revature.techshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository repository;
    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }

    @Override
    public void updateUser(int id, User user) {
        User userDb = repository.findById(id).get();
        userDb.setAddress(user.getAddress());
        userDb.setUsername(user.getUsername());
        userDb.setEmail(user.getEmail());
        userDb.setPassword(user.getPassword());
        userDb.setName(user.getName());
        repository.save(userDb);
    }

    @Override
    public void deleteUser(int id) {
        repository.deleteById(id);
    }

    @Override
    public User login(String username, String password) {
        for (User user: getAllUsers()
             ) {
            if (user.getUsername().equals(username)&&user.getPassword().equals(password)){
                return user;
            }
            
        }
        return null;
    }
}
