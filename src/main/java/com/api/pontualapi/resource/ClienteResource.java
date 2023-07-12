package com.api.pontualapi.resource;

import com.api.pontualapi.dto.ClienteDTO;
import com.api.pontualapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin("http://localhost:4200")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping()
    @ResponseBody
    public List<ClienteDTO> listarTodos() {
        return clienteService.findAll();
    }
}
