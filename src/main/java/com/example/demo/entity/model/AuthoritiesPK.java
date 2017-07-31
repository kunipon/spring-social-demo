package com.example.demo.entity.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.example.demo.entity.enumration.RoleType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class AuthoritiesPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userId;
	@Enumerated(EnumType.STRING)
	private RoleType authority;
}
