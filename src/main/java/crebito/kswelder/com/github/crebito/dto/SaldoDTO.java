package crebito.kswelder.com.github.crebito.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SaldoDTO {
    private Integer total;
    private LocalDateTime data_extrato;
    private Integer limite;
}
