package com.project.apis.security;

import com.project.apis.models.user.Usuario;
import com.project.apis.repository.user.IUsuarioRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Data
@Service
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    private IUsuarioRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Not found user " + username);
        }
        return (UserDetails) user;
    }
}
