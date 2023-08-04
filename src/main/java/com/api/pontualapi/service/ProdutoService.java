package com.api.pontualapi.service;

import com.api.pontualapi.converter.ProdutoConverter;
import com.api.pontualapi.dto.FilterDTO;
import com.api.pontualapi.dto.ProdutoDTO;
import com.api.pontualapi.model.Produto;
import com.api.pontualapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoConverter produtoConverter;

    public Page<ProdutoDTO> findAllPage(Pageable pageable, FilterDTO filtro) {
        return produtoRepository.buscaTodosProdutos(filtro.getFilter(), pageable);
    }

    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        if (produtoExist(produtoDTO.getCodigo())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto já cadastrado na base com esse código.");
        }
        return produtoConverter.converterDTO(produtoRepository.save(produtoConverter.converterToEntity(produtoDTO)));
    }

    public ProdutoDTO update(ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.findById(produtoDTO.getId()).orElseThrow(null);
        if (Objects.isNull(produto)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto inexistente.");
        }
        produto.setNome(produtoDTO.getNome());
        produto.setCodigo(produtoDTO.getCodigo());
        produto.setModelo(produtoDTO.getModelo());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setValor(produtoDTO.getValor());

        return produtoConverter.converterDTO(produtoRepository.save(produto));
    }

    private Boolean produtoExist(String codigo) {
        return produtoRepository.existsProdutoByCodigo(codigo);
    }

    public void delete(Integer id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(null);
        if (!Objects.isNull(produto)) {
            produtoRepository.delete(produto);
        }
    }

    public void deleteAll(List<Integer> ids) {
        produtoRepository.deleteAllById(ids);
    }
}
