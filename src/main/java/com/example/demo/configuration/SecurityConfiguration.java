//package com.example.demo.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//
//@Configuration
//public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity config) throws Exception {
//        config
//                .authorizeRequests()
//                .requestMatchers().hasRole("USER")
//                .antMatchers("/title.html").permitAll()
//                .antMatchers("/schedule.html").hasRole("USER")
//                .antMatchers("/manager.html").hasRole("USER")
//                .antMatchers("/checkpoint.html").hasRole("USER")
//                .antMatchers("/coach.html").hasRole("USER")
//                .antMatchers("/groups.html").hasRole("USER")
//                .antMatchers("/instructor.html").hasRole("USER")
//                .antMatchers("/competition.html").hasRole("USER")
//                .antMatchers("/route.html").hasRole("USER")
//                .antMatchers("/section.html").hasRole("USER")
//                .antMatchers("/tour.html").hasRole("USER")
//                .antMatchers("/tourist.html").hasRole("USER")
//                .and()
//                .formLogin().defaultSuccessUrl("/title.html").permitAll();
////                .and()
////                .logout().logoutUrl("/logout").permitAll();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser(User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build());
//    }
//}
