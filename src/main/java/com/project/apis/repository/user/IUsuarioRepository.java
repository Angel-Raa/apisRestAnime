package com.project.apis.repository.user;

import com.project.apis.models.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
