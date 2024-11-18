package de.dordi;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("index")
	public ResponseEntity<String> getindex(@AuthenticationPrincipal OAuth2User user) {
		return ResponseEntity.ok("1");
	}
}