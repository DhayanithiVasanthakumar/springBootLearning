package com.project.main.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


	//for JwtFilter
	@Autowired
	private JwtFilter JwtFilter;
	
	/*
	 * step 1 : security filter 
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
//		//step 1 : disable csrf
//		http.csrf(csrf -> csrf.disable());
//		//step 2 : alla resource oda request um authenticate pananum
//		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
////		//step 3 : login form -> step 5 la STATELESS ah irukartathu naala correct ah login panalume relogin pana solite irukum 
//		//so(step 3) login form create panatathu remove panidalam, namaku browser ah default ah login form provide panum
////		http.formLogin(Customizer.withDefaults());
//		
//		//step 4 : browser la html page rnder aagi varaum aana postman la apadi varathu so post man la atha access pana ithu use pananum
//		http.httpBasic(Customizer.withDefaults());
//		
//		
//		//step 5: every time create a different session id (STATELESS)
//		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		
//		return http.build();
//		
		
		
		//mela irukaramari step by step ah write panitu ipadi change panidu
		
		
	
		
	return	http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(request -> request
				
				//for authorization
				.requestMatchers("register","login").permitAll()
				.requestMatchers("/public/**").permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/user/**").hasAnyRole("ADMIN","USER")
				
				
				.anyRequest().authenticated())
		.httpBasic(Customizer.withDefaults())
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		
		//implement JWT
		.addFilterBefore(JwtFilter, UsernamePasswordAuthenticationFilter.class)
		
		.build();
	}
	
	
	/*
	 * step 2:verify users from database
	 */
	@Autowired
	UserDetailsService userDetailsService;
	
	
	/*
	 * verify users from db
	 */
	@Bean
	public AuthenticationProvider authenticationProvider(){
		
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	
	
	/*
	 * step 3 : add JWT
	 */
	
	//add AuthenticationManager ithu interface so obj create pana mudiyathu , so AuthenticationConfiguration ithuku obj create pani use panikalam
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	
	
}
