package by.zmeyka.SecurityAPI.config;

import by.zmeyka.SecurityAPI.service.PeopleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.naming.NoPermissionException;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    private PeopleDetailsService peopleDetailsService;
    @Autowired
    public SecurityConfig(PeopleDetailsService peopleDetailsService) {
        this.peopleDetailsService = peopleDetailsService;
    }

   @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception{

      security.csrf().disable().authorizeHttpRequests().
              requestMatchers("/auth/login","/error").permitAll().
              requestMatchers("/auth/registration").permitAll().
              anyRequest().authenticated()
                      .and().
              formLogin().loginPage("/auth/login")
              .loginProcessingUrl("/process_login")
              .defaultSuccessUrl("/people",true)
              .failureUrl("/auth/login?error")
              .and()
              .logout().logoutUrl("/logout").logoutSuccessUrl("/auth/login");

       return security.build();

    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(peopleDetailsService).passwordEncoder(getPasswordEncoder());

    }
    @Bean
    public static PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
