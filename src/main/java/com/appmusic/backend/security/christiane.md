Votre code présente quelques erreurs et nécessite des corrections pour être fonctionnel. Voici la version corrigée :

```java
package com.appmusic.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Authentification {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests((authorize) -> authorize
                .antMatchers("/admin/**").hasRole("ADMIN")  // Restriction d'accès aux ressources "/admin/**" pour les utilisateurs avec le rôle "ADMIN".
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")  // Restriction d'accès aux ressources "/user/**" pour les utilisateurs avec les rôles "USER" ou "ADMIN".
                .anyRequest().authenticated()  // Toute autre requête nécessite une authentification.
            )
            .httpBasic()  // Active l'authentification HTTP Basic.
            .and()
            .formLogin();  // Active l'authentification via un formulaire par défaut.
            // Vous pouvez décommenter les lignes suivantes pour personnaliser la page de connexion et la redirection après connexion.
            // .formLogin()
            //     .loginPage("/login")
            //     .defaultSuccessUrl("/home")
            //     .permitAll();

        return http.build();        
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("adminpassword")
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user, admin);  // Gestionnaire en mémoire des utilisateurs "user" et "admin".
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Utilisation de l'encodeur BCrypt pour les mots de passe.
    }
}
```

### **Explications des Corrections** :

1. **Utilisation de `UserDetailsService` et de `UserDetails`** :
   - La méthode `userService()` a été remplacée par `userDetailsService()`, qui retourne un `UserDetailsService`. Elle définit deux utilisateurs en mémoire : un utilisateur avec le rôle "USER" et un administrateur avec le rôle "ADMIN".
   - `UserDetails` a été utilisé pour représenter les informations utilisateur de manière plus claire.

2. **Gestion des Rôles et Autorisations** :
   - La méthode `authorizeRequests()` est utilisée pour configurer les autorisations basées sur les rôles. Les chemins `/admin/**` sont réservés aux utilisateurs avec le rôle "ADMIN", et les chemins `/user/**` aux utilisateurs avec les rôles "USER" ou "ADMIN".

3. **Encodage des Mots de Passe** :
   - Le `PasswordEncoder` est défini avec `BCryptPasswordEncoder`, qui est une méthode d'encodage recommandée pour les mots de passe en raison de sa sécurité accrue.

4. **Authentification HTTP Basic et Formulaire** :
   - Le code inclut l'authentification HTTP Basic avec `.httpBasic()` et l'authentification basée sur un formulaire avec `.formLogin()`. 
   - Vous pouvez personnaliser la page de connexion et la redirection après connexion en décommentant et modifiant les lignes appropriées sous `.formLogin()`.

5. **Retour des Méthodes** :
   - Le `UserDetailsService` retourne maintenant un `InMemoryUserDetailsManager`, qui gère les utilisateurs en mémoire.
   - `PasswordEncoder` est correctement retourné pour être utilisé dans l'encodage des mots de passe.

Avec ces corrections, votre configuration de sécurité Spring Boot devrait fonctionner correctement, en gérant les rôles d'utilisateur, les authentifications via formulaire ou HTTP Basic, et l'encodage des mots de passe.


