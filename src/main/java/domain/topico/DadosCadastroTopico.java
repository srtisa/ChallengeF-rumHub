package domain.topico;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;

public record DadosCadastroTopico(

        @UniqueElements
        @NotBlank
        String titulo,

        @UniqueElements
        @NotBlank
        String mensagem,

        @NotBlank
        String curso
) {

}
