package com.project.apis.service;

import com.project.apis.models.user.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IUsuarioService {
    ResponseEntity<Usuario> save(Usuario user);
    ResponseEntity<Usuario> update(Usuario user, Long id);
    ResponseEntity<?> delete(Long id);
    ResponseEntity<Usuario> user (Long id);
}
