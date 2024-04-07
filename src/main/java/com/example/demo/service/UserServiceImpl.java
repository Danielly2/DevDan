package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User addUser(UserRequest request) throws Exception {
        try{
            User user = new User();
            user.setLastName(request.getLastName());
            user.setFirstName(request.getFirstName());
            user.setActive(true);
            return userRepository.save(user);
        }catch (Exception ex){
           // ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }

    }

    @Override
    public void removeUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            User user1 = user.get();
            userRepository.delete(user1);
        }
        System.out.println("User Not Found");
    }

    @Override
    public List<User> getUsers() {

        return userRepository.findAll();
    }
}
