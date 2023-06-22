package com.ecommerce.ejadaproject.walletservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ecommerce.ejadaproject.walletservice.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {
        @Autowired
	    private CustomUserDetailsService userDetailsService;
	 


	    @Bean
	    public static PasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }
	
	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.
	         authorizeRequests()
            //.requestMatchers("/users").authenticated()
            .anyRequest().permitAll()
            .and()
            .formLogin()
                .usernameParameter("email")
                .defaultSuccessUrl("/wallet-service/users/")
                .permitAll()
            .and()
            .logout().logoutSuccessUrl("/").permitAll().and()
            .csrf().disable();
	        return http.build();
	    }

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth
	                .userDetailsService(userDetailsService)
	                .passwordEncoder(passwordEncoder());
	    }
	    

}