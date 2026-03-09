package com.example.forumhub.repository;

import com.example.forumhub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

    Usuario findByLogin(String login);

}