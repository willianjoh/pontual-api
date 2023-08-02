package com.api.pontualapi.resource;

import com.api.pontualapi.dto.ClienteDTO;
import com.api.pontualapi.model.Cliente;
import com.api.pontualapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin("http://localhost:4200")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping()
    public ResponseEntity<Page<ClienteDTO>> listarTodos(Pageable pageable) {
        Page<ClienteDTO> todosClientes = clienteService.findAllPage(pageable);
        return new ResponseEntity<>(todosClientes, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ClienteDTO>> listar() {
        List<ClienteDTO> todosClientes = clienteService.findAll();
        return new ResponseEntity<>(todosClientes, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Cliente> save(@Valid @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.save(clienteDTO);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Cliente> update(@Valid @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.update(clienteDTO);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/deleteAllById")
    public ResponseEntity<?> deleteAll(@Valid @RequestBody List<Integer> id) {
        clienteService.deleteAll(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
