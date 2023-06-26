package com.api.pontualapi.service;

import com.api.pontualapi.model.Usuario;
import com.api.pontualapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private String USER_NOT_FOUND = "Usuário não encontrado.";
    private String USER_EXIST = "Usuário já cadastrado no sistema.";

    public Usuario save(Usuario usuario) {
        boolean exists = usuarioRepository.existsByEmail(usuario.getEmail());
        if(exists){
            throw new RuntimeException(USER_EXIST);
        }
        return usuarioRepository.save(usuario);
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND));
        return User
                .builder()
                .username(usuario.getNome())
                .password(usuario.getSenha())
                .roles("USER")
                .build();
    }

    public Usuario update(Integer id, Usuario usuario) {
        Usuario usuarioSave = usuarioRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND));
        usuarioSave.setCpfCnpj(usuario.getCpfCnpj());
        usuarioSave.setNome(usuario.getNome());
        usuarioSave.setSobrenome(usuario.getSobrenome());
        return usuarioRepository.save(usuarioSave);
    }
}
