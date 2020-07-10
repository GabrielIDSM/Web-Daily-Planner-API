package br.com.GabrielIDSM.WebDailyPlanner.Repository;

import br.com.GabrielIDSM.WebDailyPlanner.Model.EventoGenericoModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EventoGenericoRepository extends PagingAndSortingRepository<EventoGenericoModel, Integer>{
    
}
