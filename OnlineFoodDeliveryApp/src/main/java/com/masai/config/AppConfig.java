package com.masai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class AppConfig {
	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception{
		
	
	
		http.authorizeHttpRequests(auth->{
			auth.requestMatchers(HttpMethod.POST, "/customers").permitAll()
			.requestMatchers(HttpMethod.POST,"/categories,/items/**").hasRole("ADMIN")
			.requestMatchers(HttpMethod.POST,"/addOrder/**").hasAnyRole("USER","ADMIN")
			.requestMatchers(HttpMethod.PATCH,"/increaseQty/**,/reduceQty/**,/removeItem/**,/clearCart/**,/addItem/**"
					).hasAnyRole("ADMIN","USER")
			.requestMatchers(HttpMethod.PUT,"/customers/**,/categories/**,/items,/updateOrder").hasRole("ADMIN")
			.requestMatchers(HttpMethod.DELETE,"/customer/**,/categories/**,/items/**,/cancelOrder").hasRole("ADMIN")
			.requestMatchers(HttpMethod.GET,"/customers/**,/customers,/categories/**,/categories,/item/**,/items/**,/itemslist/**,/order/**,/ordersByRestaurant,"
					+ "/ordersByCustomer").hasAnyRole("ADMIN","USER")
			//.requestMatchers(HttpMethod.PATCH,"/order/**").hasRole("ADMIN")
			//.requestMatchers(HttpMethod.GET,"/customers","/customer/**").hasAnyRole("ADMIN","USER")
			.requestMatchers("/swagger-ui*/**","/v3/api-docs/**").permitAll()
			.anyRequest().authenticated();
		})
		.csrf(csrf-> csrf.disable())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Bean
	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
