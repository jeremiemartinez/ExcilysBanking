
package com.excilys.excilysbanking.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.excilys.excilysbanking.dao.UserDAO;
import com.excilys.excilysbanking.entities.Authority;
import com.excilys.excilysbanking.entities.User;
import com.excilys.excilysbanking.services.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User getUserByUsername(String username) {
		return userDAO.findUserByUsername(username);
	}
	
	@Override
	public List<User> getAllUsers() {
		return userDAO.findAllUsers();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return getUserByUsername(username);
	}
	
	@Override
	public boolean isConnected(Authentication auth) {
		return auth.getPrincipal().equals("anonymousUser");
	}
	
	@Override
	public boolean isAdmin(Authentication auth) {
		for (GrantedAuthority a : auth.getAuthorities()) {
			if (a.getAuthority().equals(Authority.AuthorityType.ROLE_ADMIN.name())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public User getConnectedUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
