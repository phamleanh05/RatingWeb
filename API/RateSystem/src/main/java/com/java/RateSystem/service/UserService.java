package com.java.RateSystem.service;

import com.java.RateSystem.jwt.CustomUserDetails;
import com.java.RateSystem.models.Servicerate;
import com.java.RateSystem.models.User;
import com.java.RateSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findById(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    public void deleteById(@PathVariable Integer id) {userRepository.deleteById(id);}

    public boolean existsById(@PathVariable Integer id) {
        return userRepository.existsById(id);
    }

    public User save(@RequestBody User newUser) { return userRepository.save(newUser);}

    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }
    @Transactional
    public UserDetails loadUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );
        return new CustomUserDetails(user);
    }
}
