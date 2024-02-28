package crebito.kswelder.com.github.crebito.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransacoesDTO {
    private Integer valor;
    private Character tipo;
    private String descricao;
    private LocalDateTime realizada_em;
}
