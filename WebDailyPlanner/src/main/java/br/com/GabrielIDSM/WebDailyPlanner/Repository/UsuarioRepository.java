package br.com.GabrielIDSM.WebDailyPlanner.Repository;

import br.com.GabrielIDSM.WebDailyPlanner.Model.UsuarioModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepository extends PagingAndSortingRepository<UsuarioModel, Integer>{
    
}
