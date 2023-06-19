package com.masai.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;



@Configuration
public class AppConfig {
	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception{
		
		http.cors(cors -> {
			cors.configurationSource(new CorsConfigurationSource()  {

				@Override
				public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
					CorsConfiguration cfg = new CorsConfiguration();

					cfg.setAllowedOriginPatterns(Collections.singletonList("*"));
					cfg.setAllowedMethods(Collections.singletonList("*"));
					cfg.setAllowCredentials(true);
					cfg.setAllowedHeaders(Collections.singletonList("*"));
					cfg.setExposedHeaders(Arrays.asList("Authorization"));
					return cfg;
				}
			});
		})
		.authorizeHttpRequests(auth->{
			auth.requestMatchers(HttpMethod.POST, "/customers").permitAll()
			.requestMatchers(HttpMethod.POST,"/categories,/items/**,/Restaurant,/bill/**").hasRole("ADMIN")
			.requestMatchers(HttpMethod.POST,"/addOrder/**").hasAnyRole("USER","ADMIN")
			.requestMatchers(HttpMethod.PATCH,"/increaseQty/**,/reduceQty/**,/removeItem/**,/clearCart/**,/addItem/**"
					).hasAnyRole("ADMIN","USER")
			.requestMatchers(HttpMethod.PUT,"/customers/**,/categories/**,/items,/Restaurant/**,/bills/**").hasRole("ADMIN")
			.requestMatchers(HttpMethod.DELETE,"/customer/**,/categories/**,/items/**,/cancelOrder/**,/Restaurant/**,/bill/**").hasRole("ADMIN")
			.requestMatchers(HttpMethod.GET,"/customers/**,/customers,/categories/**,/categories,/item/**,/items/**,/itemslist/**,/order/**,/ordersByRestaurant,"
					+ "/ordersByCustomer,/Restaurant/**,/Restaurant/**,/bill/**,/startDate,/customerId").hasAnyRole("ADMIN","USER")
			//.requestMatchers(HttpMethod.PATCH,"/order/**").hasRole("ADMIN")
			//.requestMatchers(HttpMethod.GET,"/customers","/customer/**").hasAnyRole("ADMIN","USER")
			.requestMatchers("/swagger-ui*/**","/v3/api-docs/**").permitAll()
			.anyRequest().authenticated();
		})
		.csrf(csrf-> csrf.disable())
		//.addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
		//.addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Bean
	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
