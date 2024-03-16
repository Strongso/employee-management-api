package com.example.cidenet.Cidenet.services;

import com.example.cidenet.Cidenet.controllers.UserController;
import com.example.cidenet.Cidenet.entities.User;
import com.example.cidenet.Cidenet.exceptions.MyException;
import com.example.cidenet.Cidenet.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //Transactional indica que el sgte metodo es transaccional, si ocurre un error mientras se está ejecutando, automaticamente
    //se hace un rollback y no se modifica la base de datos.

    @Transactional
    public void createUser(String username, String password) {
        User user = new User();
        user.setusername(username);
        user.setPassword(password);

        userRepo.save(user);
    }

    public List<User> getUsers() {
        try {
            return userRepo.findAll();
        } catch (Exception e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, "WTF is this", e);
            return Collections.emptyList();
        }
    }

    @Transactional
    public void modifyUsernameById(String username, Long id) throws MyException {
        validateNull(username);
        Optional<User> userToModify = userRepo.findById(id);

        if (userToModify.isPresent()) {
            User user = userToModify.get();
            user.setusername(username);

            userRepo.save(user);
        }
    }

    @Transactional
    public void deleteUserById(Long id) throws MyException {
        validateNull(id);
        Optional<User> userToModify = userRepo.findById(id);

        if (userToModify.isPresent()) {
            User user = userToModify.get();

            userRepo.delete(user);
        }
    }

    @Transactional
    public void deleteAllUsers() {
        userRepo.deleteAll();
    }

    private void validateNull(Long id) throws MyException {
        if (id == null) {
            throw new MyException("The id is null");
        }
    }

    public void validateNull(String username) throws MyException {
        if (username.isEmpty()) {
            throw new MyException("The username is null or empty");
        }
    }
}


// Hasta ahora modificar ususarios funciona, seguiríamos con las demás acciones del CRUD de usuario y luego pasaríamos a los de Employee.
