package mum.cs544.project.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.project.domain.User;
import mum.cs544.project.service.UserService;
@Transactional
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	UserService userService;
	static User domainUser;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try{
		domainUser=userService.findByUsername(username);
		System.out.println(domainUser.getUserName());
		System.out.println(domainUser.getPassword());
		boolean enabled=true;
		boolean accountNonExpired=true;
		boolean credentialsNonExpired=true;
		boolean accountNonLocked=true;
		org.springframework.security.core.userdetails.User usr=new org.springframework.security.core.userdetails.User(domainUser.getUserName(), domainUser.getPassword().toLowerCase(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(domainUser.getRole().getRole()));
		System.out.println();
		System.out.println(usr);
		return usr;
	}
		catch (Exception e) {
			throw new RuntimeException(e);
}
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities(Integer role){
		List<GrantedAuthority> authList=getGrantedAuthorities(getRoles(role));
		return authList;
	}
public List<String> getRoles(Integer role){
	List<String> roles=new ArrayList<String>();
	if(role.intValue()==1){
		roles.add("ROLE_ADMIN");
			}
	else if(role.intValue()==2){
		roles.add("ROLE_USER");
	}
	return roles;
}
public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles){
	List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
	for(String role:roles){
		authorities.add(new SimpleGrantedAuthority(role));
	}
	return authorities;
}
public User getSessionUser(){
	System.out.println(domainUser.getFirstName()+"insideloaduser");
	return domainUser;
}
}
