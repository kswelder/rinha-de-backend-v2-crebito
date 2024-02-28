package crebito.kswelder.com.github.crebito.execoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensagemDeExcecao {
    private HttpStatus status;
    private String mensagem;
    private LocalDateTime data;
}
