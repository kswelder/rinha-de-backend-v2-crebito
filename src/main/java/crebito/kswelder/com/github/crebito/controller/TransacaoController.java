package crebito.kswelder.com.github.crebito.controller;

import crebito.kswelder.com.github.crebito.dto.ExtratoDTO;
import crebito.kswelder.com.github.crebito.dto.RespostaDTO;
import crebito.kswelder.com.github.crebito.dto.TransacaoDTO;
import crebito.kswelder.com.github.crebito.servico.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransacaoController {
    @Autowired
    private ClienteService service;

    @GetMapping("/clientes/{id}/extrato")
    public ResponseEntity<ExtratoDTO> extratoReponse(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.extrato(id));
    }
    @PostMapping("/clientes/{id}/transacoes")
    public ResponseEntity<RespostaDTO> salvarTransacao(@PathVariable("id") Long id, @RequestBody TransacaoDTO transacao) {
        return ResponseEntity.status(HttpStatus.OK).body(service.salvarTransacao(id, transacao));
    }
}
