package domain.topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        Long id,

        String titulo,

        String mensagem,

        LocalDateTime data,

        Boolean estadoDoTopico,

        String curso,

        String autor)  {


    public DadosDetalhamentoTopico(Topico topico) {
        this (topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getEstadoDoTopico(), topico.getAutor(), topico.getCurso());
    }



}
