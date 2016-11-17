package com.rest.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

import com.rest.boot.security.UserServiceSecurity;

@SpringBootApplication
@EnableWebSecurity
@EnableEurekaClient
public class SpringBootAppApplication extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserServiceSecurity userServiceSecurity;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userServiceSecurity);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().defaultSuccessUrl("/", true).permitAll()
				.and().httpBasic().and().csrf().disable().logout().logoutSuccessUrl("/");
	}
}

@Component
class DiscoveryClientExample implements CommandLineRunner {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Override
	public void run(String... strings) throws Exception {
		// TODO:
		System.out.println(discoveryClient.description());
	}
}
