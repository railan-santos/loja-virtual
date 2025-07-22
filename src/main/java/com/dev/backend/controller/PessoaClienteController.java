package com.dev.backend.controller;

import com.dev.backend.dto.PessoaClienteRequestDTO;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.service.PessoaClienteService;
import com.dev.backend.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoa-cliente/")
public class PessoaClienteController {

    @Autowired
    private PessoaClienteService pessoaClienteService;

    @PostMapping()
    public Pessoa registrar(@RequestBody PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        return pessoaClienteService.inserir(pessoaClienteRequestDTO);
    }

}
