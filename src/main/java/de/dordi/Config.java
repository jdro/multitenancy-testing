package de.dordi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtIssuerAuthenticationManagerResolver;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(authorize -> authorize.anyRequest()
				.authenticated())
				.oauth2ResourceServer(oauth2 -> oauth2.authenticationManagerResolver(getAuthManager()))
				.oauth2Login();

		return http.build();
	}

	private JwtIssuerAuthenticationManagerResolver getAuthManager() {
		JwtIssuerAuthenticationManagerResolver authenticationManagerResolver = JwtIssuerAuthenticationManagerResolver.fromTrustedIssuers(
				"https://login.microsoftonline.com/<DUMMY-A>/v2.0",
				"https://login.microsoftonline.com/<DUMMY-B>/v2.0");
		return authenticationManagerResolver;
	}

}
