package br.com.GabrielIDSM.WebDailyPlanner.Repository;

import br.com.GabrielIDSM.WebDailyPlanner.Model.EventoGenericoModel;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EventoGenericoRepository extends PagingAndSortingRepository<EventoGenericoModel, Integer>{
    List<EventoGenericoModel> findByUsuario(Integer usuario);
}
