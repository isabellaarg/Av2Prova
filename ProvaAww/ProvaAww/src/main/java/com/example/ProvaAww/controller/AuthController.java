package com.example.ProvaAww.controller;

import com.example.ProvaAww.model.LoginRequest;
import com.example.ProvaAww.model.User;
import com.example.ProvaAww.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * O AuthController gerencia as operações de autenticação e autorização.
 * Ele fornece endpoints para registro, login e acesso a informações de usuários autenticados.
 */
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    /**
     * Endpoint para registrar um novo usuário.
     *
     * @param user O objeto User contendo as informações do usuário a ser registrado.
     * @return O usuário registrado.
     */
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.registerUser(user);
    }

    /**
     * Endpoint para login de usuário.
     *
     * @param request O objeto LoginRequest contendo o nome de usuário e senha.
     * @return Um token JWT se o login for bem-sucedido.
     */
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        Optional<User> userOpt = authService.findByUsername(request.getUsername());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (authService.checkPassword(request.getPassword(), user.getPassword())) {
                return authService.generateToken(request.getUsername());
            }
        }
        throw new RuntimeException("Invalid username or password");
    }

    /**
     * Endpoint para extrair o nome de usuário a partir de um token JWT.
     *
     * @param token O token JWT.
     * @return O nome de usuário extraído do token.
     */
    @GetMapping("/username/{token}")
    public String extractUsername(@PathVariable String token) {
        String username = authService.extractUsername(token);
        return username;
    }

    /**
     * Endpoint para obter o nome do usuário autenticado.
     *
     * @param authentication O objeto Authentication contendo as informações de autenticação.
     * @return O nome do usuário autenticado.
     */
    @GetMapping("/user")
    public String getUser(Authentication authentication) {
        return "User: " + authentication.getName();
    }

    /**
     * Endpoint acessível apenas para administradores.
     *
     * @param authentication O objeto Authentication contendo as informações de autenticação.
     * @return O nome do administrador autenticado.
     */
    @Secured("ROLE_ADMIN")
    @GetMapping("/admin/users")
    public String onlyAdmin(Authentication authentication) {
        return "Admin: " + authentication.getName();
    }

    @Secured("ROLE_MANAGER")
    @GetMapping("/manager/products")
    public String onlyManager(Authentication authentication) {
        return "Gerente: " + authentication.getName();
    }

    @Secured("ROLE_SELLER")
    @GetMapping("/seller/orders")
    public String onlyVendedor(Authentication authentication) {
        return "Vendedor: " + authentication.getName();
    }

    @Secured("ROLE_CUSTOMER")
    @GetMapping("/customer/products")
    public String onlyCustomer(Authentication authentication) {
        return "Customer: " + authentication.getName();
    }
}


