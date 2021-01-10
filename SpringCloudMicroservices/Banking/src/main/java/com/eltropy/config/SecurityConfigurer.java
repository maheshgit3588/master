package com.eltropy.config;

import com.eltropy.controller.interceptor.RequestValidationInterceptor;
import com.eltropy.service.EltropyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private EltropyUserDetailsService eltropyUserDetailsService;

    @Autowired
    private RequestValidationInterceptor requestValidationInterceptor;

    @Override
    protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.userDetailsService(eltropyUserDetailsService);
        /*authBuilder.inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .roles(("ADMIN"))
                .and()
                .withUser("EMP1")
                .password("EMP1")
                .roles("EMPLOYEE");*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      /*  http.csrf().disable().authorizeRequests()
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/eltropy/bank/solution/user/customer").hasAnyAuthority("ROLE_ADMIN", "ROLE_EMPLOYEE")
                .antMatchers("/eltropy/bank/solution/user/employee").hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403")
        ;*/

        http.csrf().disable().authorizeRequests()
                .antMatchers("/eltropy/bank/solution/user/employee").hasAnyRole("ADMIN","ROLE_ADMIN")
                .antMatchers("/authenticate").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

     /*   http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/authenticate").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/

        http.addFilterAfter(requestValidationInterceptor, UsernamePasswordAuthenticationFilter.class);


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
