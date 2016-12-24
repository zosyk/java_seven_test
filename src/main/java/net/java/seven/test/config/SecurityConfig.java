package net.java.seven.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource dataSource;
//
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_roles where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/").access("hasRole('USER')")
                .antMatchers("/getAllCards").access("hasRole('USER')")
                .antMatchers("/getHistory").access("hasRole('USER')")
                .antMatchers("/createCard").access("hasRole('USER')")
                .antMatchers("/cards").access("hasRole('USER')")
                .antMatchers("/transferMoneyBetween").access("hasRole('USER')")
                .antMatchers("/transferMoneyToSomeone").access("hasRole('USER')")
                .antMatchers("/createTransactionBetween").access("hasRole('USER')")
                .antMatchers("/createTransactionToSomeOne").access("hasRole('USER')")
                .antMatchers("/confirmTransactionBetween").access("hasRole('USER')")
                .antMatchers("/confirmTransactionToSomeone").access("hasRole('USER')")
                .antMatchers("/success").access("hasRole('USER')");

        http.authorizeRequests().antMatchers("/registration").permitAll();

        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/login?error=invalid_data")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .permitAll();

        http.logout()
                .permitAll()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true);

    }

}