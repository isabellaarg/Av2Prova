package com.example.ProvaAww.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * A classe User representa um usuário no sistema.
 * Ela é mapeada para a coleção "users" no MongoDB.
 */
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private String role;

    /**
     * Obtém o ID do usuário.
     *
     * @return o ID do usuário.
     */
    public String getId() {
        return id;
    }

    /**
     * Define o ID do usuário.
     *
     * @param id o ID do usuário a ser definido.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtém o nome de usuário.
     *
     * @return o nome de usuário.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Define o nome de usuário.
     *
     * @param username o nome de usuário a ser definido.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtém a senha do usuário.
     *
     * @return a senha do usuário.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define a senha do usuário.
     *
     * @param password a senha do usuário a ser definida.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtém a função do usuário.
     *
     * @return a função do usuário.
     */
    public String getRole() {
        return role;
    }

    /**
     * Define a função do usuário.
     *
     * @param role a função do usuário a ser definida.
     */
    public void setRole(String role) {
        this.role = role;
    }


    /**
     * Obtém o email do usuário.
     *
     * @return o email do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do usuário.
     *
     * @param email o email a ser definido.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
