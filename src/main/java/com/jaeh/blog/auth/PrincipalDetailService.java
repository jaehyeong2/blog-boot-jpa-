package com.jaeh.blog.auth;

import com.jaeh.blog.model.User;
import com.jaeh.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username)
            .orElseThrow(()->{
                return new UsernameNotFoundException("해당사용자를 찾을수 없습니다:"+username);
            });
        return new PrincipalDetail(principal);
    }
}
