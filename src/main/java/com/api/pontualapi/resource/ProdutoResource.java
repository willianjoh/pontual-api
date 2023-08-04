package com.api.pontualapi.resource;

import com.api.pontualapi.dto.ClienteDTO;
import com.api.pontualapi.dto.FilterDTO;
import com.api.pontualapi.dto.ProdutoDTO;
import com.api.pontualapi.model.Cliente;
import com.api.pontualapi.model.Produto;
import com.api.pontualapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin("http://localhost:4200")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/listarTodos")
    public ResponseEntity<Page<ProdutoDTO>> listarTodos(@RequestBody FilterDTO filtro, Pageable pageable) {
        Page<ProdutoDTO> todosClientes = produtoService.findAllPage(pageable, filtro);
        return new ResponseEntity<>(todosClientes, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProdutoDTO> save(@Valid @RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO produto = produtoService.save(produtoDTO);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<ProdutoDTO> update(@Valid @RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO produto = produtoService.update(produtoDTO);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        produtoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/deleteAllById")
    public ResponseEntity<?> deleteAll(@Valid @RequestBody List<Integer> id) {
        produtoService.deleteAll(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
