package com.api.pontualapi.resource;

import com.api.pontualapi.dto.ServicoDTO;
import com.api.pontualapi.dto.FilterDTO;
import com.api.pontualapi.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/servico")
@CrossOrigin("http://localhost:4200")
public class ServicoResource {
    
    @Autowired 
    private ServicoService servicoService;

    @PostMapping("/listarTodos")
    public ResponseEntity<Page<ServicoDTO>> listarTodos(@RequestBody FilterDTO filtro, Pageable pageable) {
        Page<ServicoDTO> todosServicos = servicoService.findAllPage(pageable, filtro);
        return new ResponseEntity<>(todosServicos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ServicoDTO> save(@Valid @RequestBody ServicoDTO ServicoDTO) {
        ServicoDTO servico = servicoService.save(ServicoDTO);
        return new ResponseEntity<>(servico, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<ServicoDTO> update(@Valid @RequestBody ServicoDTO ServicoDTO) {
        ServicoDTO servicoDTO = servicoService.update(ServicoDTO);
        return new ResponseEntity<>(servicoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        servicoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/deleteAllById")
    public ResponseEntity<?> deleteAll(@Valid @RequestBody List<Integer> id) {
        servicoService.deleteAll(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
