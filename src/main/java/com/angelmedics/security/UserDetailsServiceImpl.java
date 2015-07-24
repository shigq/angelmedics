package com.angelmedics.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.angelmedics.domain.User;
import com.angelmedics.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository<User, Long> managerRepository;

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		User manager = managerRepository.findByUsernameAndEnabled(userName,true);
		System.out.print(managerRepository.count());
		if  (manager==null)
		{
			throw new UsernameNotFoundException("用户不存在或者当前用户已经不可用。");
		}
		// 读取权限
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		auths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		manager.setAuthorities(auths);
		return (UserDetails) manager;

	}

}
