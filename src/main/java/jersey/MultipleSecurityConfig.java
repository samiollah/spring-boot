package jersey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class MultipleSecurityConfig {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication().withUser("sami").password("123456").roles("admin");
    }

    @Configuration
    @Order(1)
    public static class ApiSecurityConfigure extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/api/**").authorizeRequests().anyRequest().hasRole("admin").and().httpBasic();
        }
    }

    @Configuration
    public static class SecurityConfigure extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.authorizeRequests().anyRequest().authenticated();
        }
    }

}
