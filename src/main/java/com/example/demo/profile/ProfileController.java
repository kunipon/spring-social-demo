package com.example.demo.profile;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.social.connect.Connection;
import org.springframework.social.security.SocialAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "profile")
public class ProfileController {
	@GetMapping(value = "view")
	public String viewProfile(Model model, Principal principal) {
//		model.addAttribute("currentConn", principal.);
		if(principal instanceof SocialAuthenticationToken) {
			SocialAuthenticationToken saToken = (SocialAuthenticationToken)principal;
			List<Connection<?>> connections = Collections.singletonList(saToken.getConnection());
			model.addAttribute("connections", connections);
			model.addAttribute("providerId", saToken.getProviderId());
		} else if(principal instanceof UsernamePasswordAuthenticationToken) {
			
		}
		return "profile";
	}
}
