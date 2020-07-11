package br.com.GabrielIDSM.WebDailyPlanner.Repository;

import br.com.GabrielIDSM.WebDailyPlanner.Model.EventoAniversarioModel;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EventoAniversarioRepository extends PagingAndSortingRepository<EventoAniversarioModel, Integer>{
    List<EventoAniversarioModel> findByUsuario(Integer usuario);
}
