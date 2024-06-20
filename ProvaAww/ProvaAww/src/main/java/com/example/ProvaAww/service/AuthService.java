package com.example.ProvaAww.service;

import com.example.ProvaAww.model.User;
import com.example.ProvaAww.repository.UserRepository;
import com.example.ProvaAww.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * A classe AuthService fornece serviços de autenticação e autorização para a aplicação JWT Rest API.
 * Inclui métodos para registrar usuários, verificar senhas e manipular tokens JWT.
 */
@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Registra um novo usuário no sistema.
     *
     * @param user O objeto User contendo as informações do usuário a ser registrado.
     * @return O usuário registrado.
     */
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Atribui um papel padrão se não for fornecido
        if (user.getRole() == null) {
            user.setRole("CLIENTE");
        }
        return userRepository.save(user);
    }

    /**
     * Busca um usuário pelo nome de usuário.
     *
     * @param username O nome de usuário a ser buscado.
     * @return Um Optional contendo o usuário encontrado, ou vazio se não encontrado.
     */
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Verifica se uma senha bruta corresponde a uma senha codificada.
     *
     * @param rawPassword A senha bruta.
     * @param encodedPassword A senha codificada.
     * @return true se as senhas correspondem, false caso contrário.
     */
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * Gera um token JWT para um determinado nome de usuário.
     *
     * @param username O nome de usuário para o qual o token será gerado.
     * @return O token JWT gerado.
     */
    public String generateToken(String username) {
        return JwtUtil.generateToken(username);
    }

    /**
     * Extrai o nome de usuário de um token JWT.
     *
     * @param token O token JWT.
     * @return O nome de usuário extraído do token.
     */
    public String extractUsername(String token) {
        return JwtUtil.extractUsername(token);
    }
}
