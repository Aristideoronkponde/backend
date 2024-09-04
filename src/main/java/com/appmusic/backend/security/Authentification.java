package com.appmusic.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Indique que cette classe contient des configurations Spring
@EnableWebSecurity // Active la sécurité Spring Security pour l'application
public class Authentification {

    // Cette méthode configure la chaîne de filtres de sécurité pour gérer les requêtes HTTP
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configuration des règles d'autorisation
        http
            .authorizeHttpRequests((authorize) -> authorize
                // Seuls les utilisateurs avec le rôle "ADMIN" peuvent accéder aux URLs commençant par "/admin/"
                .antMatchers("/admin/**").hasRole("ADMIN")
                // Seuls les utilisateurs avec les rôles "USER" ou "ADMIN" peuvent accéder aux URLs commençant par "/user/"
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                // Toute autre requête doit être authentifiée (l'utilisateur doit être connecté)
                .anyRequest().authenticated()
            )
            // Configuration du formulaire de connexion
            .formLogin()
                // Spécifie l'URL de la page de connexion personnalisée
                .loginPage("/login")
                // Spécifie l'URL de redirection après une connexion réussie
                .defaultSuccessUrl("/home")
                // Autorise l'accès à la page de connexion à tous les utilisateurs (même non authentifiés)
                .permitAll();

        // Retourne la chaîne de filtres de sécurité configurée
        return http.build();
    }

    // Cette méthode configure un gestionnaire d'utilisateurs en mémoire avec un utilisateur par défaut
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        // Création d'un utilisateur avec le nom "user", le mot de passe encodé et le rôle "USER"
        UserDetails user = User.withUsername("user")
            .password(passwordEncoder().encode("password"))
            .roles("USER")
            .build();

        // Retourne un gestionnaire d'utilisateurs qui stocke les utilisateurs en mémoire
        return new InMemoryUserDetailsManager(user);
    }

    // Cette méthode définit le mécanisme d'encodage des mots de passe
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Utilisation de BCrypt pour encoder les mots de passe
        return new BCryptPasswordEncoder();
    }
}
