package crebito.kswelder.com.github.crebito.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer valor;
    @Column(nullable = false)
    private Character tipo;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private LocalDateTime criado;

    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;
}
