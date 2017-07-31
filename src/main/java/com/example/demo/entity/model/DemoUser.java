package com.example.demo.entity.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DemoUser {
	/** ユーザー識別用ID */
	@Id
	@GeneratedValue(generator = "guid")
	@GenericGenerator(name="guid", strategy = "org.hibernate.id.GUIDGenerator")
	@Column(unique = true, updatable = false)
	private String userId;

	@Column(unique = true, nullable = false)
	private String loginId;
	@Column(nullable = false)
	private String password;
//	@Size(min = 1, max = 100)
	private String firstName;
//	@Size(min = 1, max = 100)
	private String lastName;
	private boolean enabled;
	private boolean accountNonLocked;
	
	@OneToMany(mappedBy = "demoUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Authorities> authorities;
}
