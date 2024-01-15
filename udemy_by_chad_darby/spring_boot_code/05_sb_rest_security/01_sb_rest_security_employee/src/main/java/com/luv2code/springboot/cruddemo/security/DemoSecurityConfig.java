package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class DemoSecurityConfig {
    //use script from `udemy_by_chad_darby/spring-boot-3-pdfs/00-spring-boot-rest-security-employee-starter-code/00-spring-boot-rest-security-employee-starter-code/sql-scripts`
    @Bean
    // add support for JDBC with custom tables schemas which are not supported by spring security ie no more hard coding users details
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id,pw,active from members where user_id=?"); // spring security will use the members table to get user
        //define query to retrieve a roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id,role from roles where user_id=?"); // spring security will use the roles table to get user's roles


        return jdbcUserDetailsManager;
    }

    /*
    @Bean // add support for JDBC with default tables schemas supported by spring security ie no more hard coding users details
    public UserDetailsManager  userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
    */
    @Bean // use to add permission to access api based on roles
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );
        //use basic auth
        http.httpBasic(Customizer.withDefaults());

        //Disable CSRF...not required for stateless API ie POST,PUT,DELETE or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
    /*
    @Bean // add support for in memory ie hard coding users details
    public InMemoryUserDetailsManager userDetailsManager() { //It will not consider user from properties.applications file

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails marry = User.builder()
                .username("marry")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, marry, susan);
    }
    */
}
