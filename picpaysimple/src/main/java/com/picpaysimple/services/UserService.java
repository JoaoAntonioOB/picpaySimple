package com.picpaysimple.services;

import com.picpaysimple.dtos.UserDTO;
import com.picpaysimple.models.user.User;
import com.picpaysimple.models.user.UserType;
import com.picpaysimple.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuário do tipo Logista não esta autorizado a realizar transação");
        }

        if (sender.getBalance().compareTo(amount) < 0 ){
            throw new Exception("Saldo insuficiente");
        }

    }

    public User findUserById(Long id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public User createUser(UserDTO data){
        User newUser = new User(data);
        return newUser;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }


    public void saveUser(User user){
        this.userRepository.save(user);
    }
}
