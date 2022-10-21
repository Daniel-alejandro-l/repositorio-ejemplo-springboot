package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private UserRepository repository;

    public  UserService(UserRepository repository){
        this.repository=repository;
    }


    public User createUser(User newUser){
        return this.repository.save(newUser);
    }

    public User findUserByEmail(String email){
        return  this.repository.findByEmail(email);

    }
    public User getOrCreateUser(Map<String,Object> userDate){
            String email= (String) userDate.get("email");
            User user=findUserByEmail(email);
            if (user==null) {
                String name = (String) userDate.get("nickname");
                String image = (String) userDate.get("picture");
                String auth0Id = (String) userDate.get("sub");
                User newUser = new User(email = email, image = image, auth0Id = auth0Id);
                return  createUser(newUser);

            }
            //System.out.println(user.getEmail());
            return user;
    }

}