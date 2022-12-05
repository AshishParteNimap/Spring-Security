package com.role_base.Config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.annotation.JsonTypeInfo.None;
import com.role_base.UserDetails.MyUserDetailsSerivce;
import com.role_base.model.User;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true, jsr250Enabled = true)

public class Security extends WebSecurityConfigurerAdapter{

	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailsSerivce();
	}
	


	 
	 @Bean
	    public DaoAuthenticationProvider authProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(pass());
	        
	        
	        
	        return authProvider;
	    }

	
	@Bean
	public PasswordEncoder pass() {
		return new BCryptPasswordEncoder();
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		
		
		//.authorizeRequests()
		//.antMatchers("/**").hasRole("ADMIN")
		//.antMatchers("/**").hasRole("ADMIN");
		.authorizeRequests()
		.antMatchers("/User/add")
		.authenticated()
		.antMatchers("/crs/allP")
		.authenticated()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	
//		.and()
//		.formLogin()
//		.and()
//		.csrf().disable()
//		.logout().permitAll();
		
		
		
		
	}
	}
	
	
	
	
	
	
	

