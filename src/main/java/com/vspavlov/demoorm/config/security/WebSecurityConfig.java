package com.vspavlov.demoorm.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


/**
 * Created by Василий on 02.05.2015.
 */
@Configuration
@EnableWebSecurity
@Profile(value = "plain")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

       //******************** HTTPS ************************
//         http.csrf().disable()
//                 .authorizeRequests().antMatchers("/")
//                 .permitAll().antMatchers("/index")
//                 .authenticated().and().requiresChannel().antMatchers("/body").requiresSecure().and().formLogin().loginPage("/login")
//                .and()
//                .httpBasic()
//                .realmName("Matrix");

        http
//                .csrf().disable()
                .authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/index").authenticated()
                .and()
                .formLogin().loginPage("/logindev")
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
                .and().rememberMe().tokenValiditySeconds(3600).key("matrixKey")
                .and()
                .httpBasic()
                .realmName("Matrix");
       // super.configure(http);
    }

    //////***********   default configuration ******************\\\\\\\\\\\\\\\\\\\\\

//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .authorizeRequests()
//                    .anyRequest().authenticated()
//                    .and()
//                    .formLogin()
//                    .and()
//                    .httpBasic();
//        }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      //  super.configure(auth);



         auth.userDetailsService(customUserDetailsService);  // custom
    }
}
