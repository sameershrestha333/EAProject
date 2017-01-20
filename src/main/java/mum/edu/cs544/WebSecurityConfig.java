package mum.edu.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import mum.edu.cs544.security.CustomUserDetailsService;

//import security.CustomUserDetailsService;

@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

 @Autowired 
 private UserDetailsService userDetailsService;
 
 @Autowired
 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {    
	 auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
 } 
 

 
 @Override
 protected void configure(HttpSecurity http) throws Exception {
   http.authorizeRequests()
   .antMatchers("/images/**").permitAll()
   .antMatchers("brand/showFormForAdd").access("hasRole('ROLE_USER')")
  .antMatchers("/hello").access("hasRole('ROLE_USER')")
 // .antMatchers("/list-brand").access("hasRole('ROLE_ADMIN')")
 // .antMatchers("/list-category").access("hasRole('ROLE_ADMIN')")
 // .antMatchers("/list-product").access("hasRole('ROLE_ADMIN')")

 //.antMatchers("/brand/showFormForAdd").access("hasRole('ROLE_USER')")
 //.antMatchers("/brand/showFormForAdd").permitAll()

  //.antMatchers("/showFormForAdd").access("hasRole('ROLE_ADMIN')")
//  .anyRequest().permitAll()
  .and()
    .formLogin().defaultSuccessUrl("/brand/list").loginPage("/login")
 
    .usernameParameter("username").passwordParameter("password")
  .and()
    .logout().logoutSuccessUrl("/login?logout") 
   .and()
   .exceptionHandling().accessDeniedPage("/403")
  .and()
    .csrf();
 }
 
 
 @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
     return new BCryptPasswordEncoder();
    }
}