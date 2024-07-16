package domain.topico;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TopicoRepositorio extends JpaRepository <Topico, Long> {


    List<DadosListarMedicos> finfAllByEstadoDoTopicoTrue();
}



