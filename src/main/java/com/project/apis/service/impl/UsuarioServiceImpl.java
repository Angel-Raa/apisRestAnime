package com.project.apis.service.impl;

import com.project.apis.models.user.Usuario;
import com.project.apis.repository.user.IUsuarioRepository;
import com.project.apis.service.IUsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    private IUsuarioRepository repository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public ResponseEntity<Usuario> save(Usuario user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return new ResponseEntity<>(repository.save(user), HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public ResponseEntity<Usuario> update(Usuario user, Long id) {
        Usuario updateToUser = repository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Not found user" + id.toString()));
        BeanUtils.copyProperties(user, updateToUser,"id");
        Usuario update = repository.save(updateToUser);
        return ResponseEntity.ok(update);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Usuario> user(Long id) {
        return null;
    }
}
