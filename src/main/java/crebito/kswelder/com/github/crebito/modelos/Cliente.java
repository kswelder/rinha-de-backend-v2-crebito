package crebito.kswelder.com.github.crebito.modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer limite;
    private Integer saldo;

    @OneToMany(mappedBy = "cliente_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Transacao> transacoes;
}
