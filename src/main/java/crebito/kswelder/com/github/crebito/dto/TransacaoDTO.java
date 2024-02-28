package crebito.kswelder.com.github.crebito.dto;

import lombok.Data;

@Data
public class TransacaoDTO {
    private Integer valor;
    private Character tipo;
    private String descricao;
}
