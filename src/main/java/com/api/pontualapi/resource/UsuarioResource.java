package com.api.pontualapi.resource;

import com.api.pontualapi.dto.UsuarioDTO;
import com.api.pontualapi.model.Usuario;
import com.api.pontualapi.repository.UsuarioRepository;
import com.api.pontualapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("http://localhost:4200")
public class UsuarioResource {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    @ResponseBody
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Usuario> save(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario userSave = usuarioService.save(usuarioDTO);
        return new ResponseEntity<>(userSave, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody @Valid UsuarioDTO usuarioDTO) {
        Usuario userUpdate = usuarioService.update(id, usuarioDTO);
        return new ResponseEntity<>(userUpdate, HttpStatus.OK);
    }

}
