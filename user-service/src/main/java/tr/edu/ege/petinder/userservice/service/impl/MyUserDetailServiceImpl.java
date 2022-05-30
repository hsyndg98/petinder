package tr.edu.ege.petinder.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tr.edu.ege.petinder.userservice.model.User;
import tr.edu.ege.petinder.userservice.repository.UserRepository;
import tr.edu.ege.petinder.userservice.security.MyUserDetails;

@Service
@RequiredArgsConstructor
public class MyUserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findByUsername(username);


        return MyUserDetails.create(user);
    }
}
