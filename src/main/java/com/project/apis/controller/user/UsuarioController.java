package com.project.apis.controller.user;

import com.project.apis.models.user.Usuario;
import com.project.apis.service.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Usuario> save(@Valid @RequestBody Usuario user) {
        return usuarioService.save(user);
    }

    @PutMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Usuario> update(@Valid @RequestBody Usuario user, @PathVariable Long id){
        return usuarioService.update(user, id);
    }



}
