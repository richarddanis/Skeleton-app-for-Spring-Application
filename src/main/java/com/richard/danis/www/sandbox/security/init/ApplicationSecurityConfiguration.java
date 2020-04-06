package com.richard.danis.www.sandbox.security.init;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/", "/h2-console/*", "/swagger-ui.html").permitAll()
            .anyRequest().not().authenticated()
            .and()
            .headers().frameOptions().disable()  //H2
            .and()
            .httpBasic();
    }
}
