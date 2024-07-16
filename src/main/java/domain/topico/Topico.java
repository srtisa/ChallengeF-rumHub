package domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity (name = "topicos")
@Table (name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    String titulo;

    String mensagem;

    LocalDateTime data;

    Boolean estadoDoTopico = true;

    String curso;

    String autor;

    public Topico (DadosCadastroTopico dados) {
        this.titulo = dados.mensagem();
        this.mensagem = dados.mensagem();
        this.curso = dados.curso();

    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Boolean getEstadoDoTopico() {
        return estadoDoTopico;
    }

    public String getCurso() {
        return curso;
    }

    public String getAutor() {
        return autor;
    }

    public void atualizarInformacoes(DadosAtualizaTopico dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
    }

    public void excluirTopico() {
        this.estadoDoTopico = false;
    }
}
