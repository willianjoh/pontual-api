package com.api.pontualapi.service;

import com.api.pontualapi.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;

}
