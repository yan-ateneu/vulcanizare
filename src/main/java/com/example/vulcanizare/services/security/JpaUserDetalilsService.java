package com.example.vulcanizare.services.security;

import com.example.vulcanizare.domain.security.Authority;
import com.example.vulcanizare.domain.security.User;
import com.example.vulcanizare.repositories.security.AuthorityRepository;
import com.example.vulcanizare.repositories.security.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
//@Slf4j
public class JpaUserDetalilsService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public JpaUserDetalilsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;

        Optional<User> userOpt= userRepository.findByUsername(username);
        if (userOpt.isPresent())
            user = userOpt.get();
        else
            throw new UsernameNotFoundException("Username: " + username);

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),user.getEnabled(), user.getAccountNotExpired(),
                user.getCredentialsNotExpired(),user.getAccountNotLocked(),getAuthorities(user.getAuthorities()));

    }

    private Collection<? extends GrantedAuthority> getAuthorities(Set<Authority> authorities) {
        if (authorities == null){
            return new HashSet<>();
        } else if (authorities.size() == 0){
            return new HashSet<>();
        }
        else{
            return authorities.stream()
                    .map(Authority::getRole)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toSet());
        }
    }
}
