package crebito.kswelder.com.github.crebito.servico;

import crebito.kswelder.com.github.crebito.dto.*;
import crebito.kswelder.com.github.crebito.modelos.Cliente;
import crebito.kswelder.com.github.crebito.modelos.Transacao;
import crebito.kswelder.com.github.crebito.repositorios.ClienteRepository;
import crebito.kswelder.com.github.crebito.repositorios.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TransacaoRepository transacaoRepository;
    @Autowired
    private ModelMapper mapper;

    private boolean debito(int valor, Cliente cliente) {
        int limite = -cliente.getLimite();
        int saldo = -(cliente.getSaldo() - valor);
        if (limite >= saldo) {
            cliente.setSaldo(cliente.getSaldo() - valor);
            clienteRepository.save(cliente);
            return true;
        }
        return false;
    }
    private boolean credito(int valor, Cliente cliente) {
        if (cliente.getLimite() - valor >= 0) {
            cliente.setLimite(cliente.getLimite() - valor);
            clienteRepository.save(cliente);
            return true;
        }
        return false;
    }

    public RespostaDTO salvarTransacao(Long id, TransacaoDTO transacao) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente nao encontrado"));

        boolean checkTransacao = false;
        Transacao registro = new Transacao();

        if (transacao.getTipo() == 'c') {
            checkTransacao = debito(transacao.getValor(), cliente);
        } else if (transacao.getTipo() == 'd') {
            checkTransacao = credito(transacao.getValor(), cliente);
        }
        else {
            throw new RuntimeException("Error");
        }

        if (checkTransacao) {
            registro.setValor(transacao.getValor());
            registro.setTipo(transacao.getTipo());
            registro.setDescricao(transacao.getDescricao());
            registro.setCliente(cliente);
            registro.setCriado(LocalDateTime.now());
        }
        transacaoRepository.save(registro);
        cliente = clienteRepository.findById(cliente.getId()).get();

        RespostaDTO resposta = new RespostaDTO();

        resposta.setLimite(cliente.getLimite());
        resposta.setSaldo(cliente.getSaldo());

        return resposta;
    }
    public ExtratoDTO extrato(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente nao encontrado"));

        List<Transacao> transacoes = cliente.getTransacoes();

        ExtratoDTO extrato = new ExtratoDTO();
        extrato.setUltimas_transacoes(mapper.map(transacoes, TransacoesDTO.class));
        extrato.setSaldo(mapper.map(cliente, SaldoDTO.class));
        return extrato;
    }
}
