package com.example.msauth.services;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.msauth.exceptions.UsuarioCadastradoException;
import com.example.msauth.models.Usuario;
import com.example.msauth.repositories.UsuarioRepository;


@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    public Usuario save(Usuario usuario) {
        boolean existe = this.usuarioRepository.existsByEmail(usuario.getEmail());
        if (existe) {
            logger.error("Este email já se encontra em uso.");
            throw new UsuarioCadastradoException(usuario.getEmail());
        }

        return this.usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return this.usuarioRepository.findAll();
    }

    public Usuario findByUsuarioById(Integer idUsuario) {
        return this.usuarioRepository
                .findById(idUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado id invalido: " + idUsuario));
    }

    public Usuario findByUsername(String username) {
        return this.usuarioRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Email/Username invalido."));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.findByUsername(username);

        return User
                .builder()
                .username(usuario.getUsername())
                .password(usuario.getPasswrd())
                .roles("USER")
                .build();
    }
}
