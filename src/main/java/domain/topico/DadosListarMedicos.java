package domain.topico;

import java.time.LocalDateTime;

public record DadosListarMedicos(

        Long id,

        String titulo,

        String mensagem,

        LocalDateTime data,

        String curso,

        String autor)
{
}
