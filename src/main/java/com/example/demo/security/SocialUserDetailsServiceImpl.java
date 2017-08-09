package com.example.demo.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

import com.example.demo.entity.dao.DemoUserRepository;
import com.example.demo.entity.model.Authorities;
import com.example.demo.entity.model.DemoUser;

public class SocialUserDetailsServiceImpl implements SocialUserDetailsService {

	private final DemoUserRepository demoUserRepository;

	public SocialUserDetailsServiceImpl(DemoUserRepository demoUserRepository) {
		this.demoUserRepository = demoUserRepository;
	}

	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException, DataAccessException {
		DemoUser demoUser = demoUserRepository.findOne(userId);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Authorities auth: demoUser.getAuthorities()){
			authorities.add(new SimpleGrantedAuthority(auth.getKey().getAuthority().toString()));
		}
		
		return new SocialUser(demoUser.getUserId(), demoUser.getPassword(), authorities);
	}

}
