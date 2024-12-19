package com.webtechlabs.gestionstock.service.impl;

import com.webtechlabs.gestionstock.model.User;
import com.webtechlabs.gestionstock.repository.UserRepository;
import com.webtechlabs.gestionstock.utils.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userRepository
            .findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));

    return UserDetailsImpl.build(user);
  }
}
