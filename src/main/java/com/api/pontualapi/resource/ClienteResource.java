package com.api.pontualapi.resource;

import com.api.pontualapi.dto.ClienteDTO;
import com.api.pontualapi.dto.ClienteListDTO;
import com.api.pontualapi.dto.FilterDTO;
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

    @PostMapping("/listarTodos")
    public ResponseEntity<Page<ClienteDTO>> listarTodos(@RequestBody FilterDTO filtro, Pageable pageable) {
        Page<ClienteDTO> todosClientes = clienteService.findAllPage(pageable, filtro);
        return new ResponseEntity<>(todosClientes, HttpStatus.OK);
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<ClienteListDTO>> listarTodos() {
        List<ClienteListDTO> todosClientes = clienteService.listClientesOrdemServico();
        return new ResponseEntity<>(todosClientes, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ClienteDTO> save(@Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO cliente = clienteService.save(clienteDTO);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<ClienteDTO> update(@Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO cliente = clienteService.update(clienteDTO);
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
