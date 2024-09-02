package com.appmusic.backend.security;

import java.beans.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.appmusic.backend.models.User;

@Configuration
@EnableWebSecurity
public class Authentification {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
http
.authorizeHttpRequests((authorize)->authorize
.antMatchers("/admin/**").hasRole("ADMIN")//accorder des roles et droits aux users.
.antMatchers("/user/**").hasRole("USER","ADMIN")
.anyRequest().authenticated()
)
.httpBasic(Customizer.withDefaults())
.formLogin(Customizer.withDefaults());
// .formLogin()
//     .loginPage("/login")
//     .defaultSuccessUrl("/home")
//     .permitAll();

return http.build();        
}

@Bean
public UserService userService() {
UserService userService =User.withDefaultsPasswordEncoder()
.username("user")
.password("password")
.roles("USER");
.build();

return new InMemoryUserDetailsManager(userService);
}
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}


}