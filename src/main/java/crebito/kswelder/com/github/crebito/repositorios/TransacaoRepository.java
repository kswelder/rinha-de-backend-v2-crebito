package crebito.kswelder.com.github.crebito.repositorios;

import crebito.kswelder.com.github.crebito.modelos.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
