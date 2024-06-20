package com.example.ProvaAww.repository;

import com.example.ProvaAww.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

/**
 * A interface UserRepository é um repositório MongoDB para a entidade User.
 * Ela herda métodos CRUD do MongoRepository e define um método adicional para encontrar um usuário pelo nome de usuário.
 */
public interface UserRepository extends MongoRepository<User, String> {

    /**
     * Encontra um usuário pelo nome de usuário.
     *
     * @param username o nome de usuário.
     * @return um Optional contendo o usuário encontrado, ou vazio se não encontrado.
     */
    Optional<User> findByUsername(String username);
}

