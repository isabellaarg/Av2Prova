package com.example.ProvaAww.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * A classe JwtUtil fornece métodos para gerar e extrair informações de tokens JWT.
 */
public class JwtUtil {
    private static final SecretKey SECRET_KEY = generateSecretKey();
    private static final String SECRET_STRING = getSecretString();
    private static final long EXPIRATION_TIME = 864_000_000; // 10 dias em milissegundos

    /**
     * Gera uma chave secreta para assinatura de tokens JWT.
     *
     * @return a chave secreta gerada.
     */
    private static SecretKey generateSecretKey() {
        return Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS512);
    }

    /**
     * Obtém a string codificada da chave secreta em Base64.
     *
     * @return a string codificada da chave secreta.
     */
    private static String getSecretString() {
        return Encoders.BASE64.encode(SECRET_KEY.getEncoded());
    }

    /**
     * Gera um token JWT para um determinado nome de usuário.
     *
     * @param username o nome de usuário para o qual o token será gerado.
     * @return o token JWT gerado.
     */
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();
    }

    /**
     * Extrai o nome de usuário de um token JWT.
     *
     * @param token o token JWT do qual o nome de usuário será extraído.
     * @return o nome de usuário extraído do token.
     */
    public static String extractUsername(String token) {
        SecretKey secret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_STRING));
        return Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token).getBody().getSubject();
    }
}
