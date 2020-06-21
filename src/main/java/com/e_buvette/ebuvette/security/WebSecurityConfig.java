package com.e_buvette.ebuvette.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Autowired
	public CustomLoginAccessHandler successHandler;
	
	@Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
         
        .authorizeRequests()
            //.anyRequest().authenticated()
            .antMatchers("/*").permitAll()
            .antMatchers("/client/*").access("hasAnyRole('ROLE_CLIENT' , 'ROLE_ADMIN')")
            .antMatchers("/vendeur/*").access("hasAnyRole('ROLE_VENDEUR' , 'ROLE_ADMIN')")
            .and()
           // .exceptionHandling().accessDeniedPage("/403")
          // .and()
            .formLogin()
            .loginPage("/seconnecter.xhtml")
            .successHandler(successHandler)
            .permitAll()
            //.loginProcessingUrl("/seconnecter")
            .failureUrl("/seconnecter.xhtml?error=true")
            .and()
            .logout()
           /* .logoutUrl("/logout")
            .logoutSuccessUrl("/logoutSuccessful")*/
            .permitAll();
        http.csrf().disable();
    }
    
    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers(HttpMethod.POST, "/**");
    }
}
