
package com.revision.demo.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
public class ConfigurationForSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("random").password("goat").roles("USER").and().withUser("souji")
				.password("pass").roles("ADMIN");

		/*
		 * auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
		 * .withUser(User.withUsername("koushik").password("pass").roles("USER"));
		 */

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/api/siteDetails").hasRole("ADMIN").antMatchers("/api/getPerson")
				.hasRole("USER").antMatchers("/api/welcome").permitAll().antMatchers("/api/allpersonrecords")
				.permitAll().antMatchers("/api/person/**").hasAnyRole("USER", "ADMIN").antMatchers("/api/addPerson").permitAll().and().formLogin();

	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {

		return NoOpPasswordEncoder.getInstance();

	}

}
