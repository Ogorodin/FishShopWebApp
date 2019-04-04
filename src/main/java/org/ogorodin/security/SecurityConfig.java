package org.ogorodin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("customer").password(passwordEncoder().encode("customer")).roles("CUSTOMER").and()
			.withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN").and()
			.withUser("employee").password(passwordEncoder().encode("emp123")).roles("EMPLOYEE");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			//.antMatchers("").authenticated()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/api/**").hasRole("ADMIN")
			.antMatchers("/employee/**").hasAnyRole("EMPLOYEE", "ADMIN")
		.and().httpBasic();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
