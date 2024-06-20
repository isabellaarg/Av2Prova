package com.example.ProvaAww.model;

/**
 * A classe LoginRequest representa uma solicitação de login contendo o nome de usuário e a senha.
 */
public class LoginRequest {
    private String username;
    private String password;

    /**
     * Construtor sem argumentos.
     * Necessário para a desserialização de JSON.
     */
    public LoginRequest() {
    }

    /**
     * Construtor parametrizado.
     *
     * @param username o nome de usuário.
     * @param password a senha.
     */
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
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
     * Obtém a senha.
     *
     * @return a senha.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define a senha.
     *
     * @param password a senha a ser definida.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
