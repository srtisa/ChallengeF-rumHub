package domain.topico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaTopico (

        @NotNull
        Long id,

        String titulo,

        String mensagem
        ) {

}
