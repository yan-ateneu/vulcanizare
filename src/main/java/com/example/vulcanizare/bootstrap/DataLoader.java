package com.example.vulcanizare.bootstrap;

import com.example.vulcanizare.domain.security.Authority;
import com.example.vulcanizare.domain.security.User;
import com.example.vulcanizare.repositories.VehiculRepository;
import com.example.vulcanizare.repositories.security.AuthorityRepository;
import com.example.vulcanizare.repositories.security.UserRepository;
//import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@AllArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {
    private AuthorityRepository authorityRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public DataLoader(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = getPasswordEncoder();
    }


    private void loadUserData() {
        if (userRepository.count() == 0){
            Authority adminRole = authorityRepository.save(new Authority("ROLE_ADMIN"));
            Authority guestRole = authorityRepository.save(new Authority("ROLE_GUEST"));

//            User admin = User.builder()
//                    .username("admin")
//                    .password(passwordEncoder.encode("12345"))
//                    .authority(adminRole)
//                    .build();
            User admin=new User("admin",passwordEncoder.encode("12345"),adminRole);
            User guest = new User("guest", passwordEncoder.encode("12345"), guestRole);
            /*User guest = User.builder()
                    .username("guest")
                    .password(passwordEncoder.encode("12345"))
                    .authority(guestRole)
                    .build(); */

            userRepository.save(admin);
            userRepository.save(guest);
        }
    }


    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }
}
