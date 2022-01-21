package com.example.test.service;

import com.example.test.VO.UserVO;
import com.example.test.entity.User;
import com.example.test.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll()
    {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(e -> users.add(e));
        return users;
    }

    public Optional<User> findById(long id){
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    public void deleteById(long id){
        userRepository.deleteById(id);
    }

    public User save(User user){
        userRepository.save(user);
        return user;
    }

    public void updateById(long id, User user)
    {
        Optional<User> e = userRepository.findById(id);

        if(e.isPresent()){
            e.get().setId(user.getId());
            e.get().setName(user.getName());
            e.get().setEmail(user.getEmail());

            userRepository.save(user);
        }
    }
}
