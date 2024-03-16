package com.example.cidenet.Cidenet.repo;



import com.example.cidenet.Cidenet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//los repos son interfaces (seguramente hay una por cada objeto o modelo (usuario, admin, etc.-) se inyectan con @AutoWired dentro de los servicios y controladores.)

public interface UserRepo extends JpaRepository<User, Long> {
}
