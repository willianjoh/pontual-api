package com.api.pontualapi.service;

import com.api.pontualapi.dto.UsuarioDTO;
import com.api.pontualapi.model.Usuario;
import com.api.pontualapi.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private String USER_NOT_FOUND = "Usuário não encontrado.";
    private String USER_EXIST = "Usuário já cadastrado no sistema.";

    public Usuario save(UsuarioDTO usuarioDTO) {
        try {
            boolean exists = usuarioRepository.existsByLogin(usuarioDTO.getLogin());
            if(exists){
                throw new RuntimeException(USER_EXIST);
            }
            Usuario usuario = new Usuario();
            BeanUtils.copyProperties(usuarioDTO, usuario);
            return usuarioRepository.save(usuario);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND));
        return User
                .builder()
                .username(usuario.getNome())
                .password(usuario.getSenha())
                .roles("USER")
                .build();
    }

    public Usuario update(Integer id, UsuarioDTO usuarioDTO) {
        try {
            Usuario usuarioSave = usuarioRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND));
            BeanUtils.copyProperties(usuarioDTO, usuarioSave);
            return usuarioRepository.save(usuarioSave);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
