package com.api.pontualapi.converter;

import com.api.pontualapi.dto.ClienteDTO;
import com.api.pontualapi.dto.ProdutoDTO;
import com.api.pontualapi.model.Cliente;
import com.api.pontualapi.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class ProdutoConverter {

    public Produto converterToEntity(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setCodigo(produtoDTO.getCodigo());
        produto.setModelo(produtoDTO.getModelo());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setValor(produtoDTO.getValor());
        return produto;
    }

    public ProdutoDTO converterDTO(Produto produto){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setCodigo(produto.getCodigo());
        produtoDTO.setModelo(produto.getModelo());
        produtoDTO.setDescricao(produto.getDescricao());
        produtoDTO.setValor(produto.getValor());
        return produtoDTO;
    }
}
