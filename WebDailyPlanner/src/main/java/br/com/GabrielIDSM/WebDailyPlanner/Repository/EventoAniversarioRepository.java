package br.com.GabrielIDSM.WebDailyPlanner.Repository;

import br.com.GabrielIDSM.WebDailyPlanner.Model.EventoAniversarioModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EventoAniversarioRepository extends PagingAndSortingRepository<EventoAniversarioModel, Integer>{
    
}
