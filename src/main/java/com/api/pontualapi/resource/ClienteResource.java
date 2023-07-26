package com.api.pontualapi.resource;

import com.api.pontualapi.dto.ClienteDTO;
import com.api.pontualapi.model.Cliente;
import com.api.pontualapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @ResponseBody
    public List<Cliente> listarTodos() {
        return clienteService.findAll();
    }

    @PostMapping()
    public ResponseEntity<Cliente> save(@Valid @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.save(clienteDTO);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }
}
