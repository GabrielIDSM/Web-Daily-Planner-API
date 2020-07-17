package br.com.GabrielIDSM.WebDailyPlanner.Repository;

import br.com.GabrielIDSM.WebDailyPlanner.Model.AuthenticationModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthenticationRepository extends PagingAndSortingRepository<AuthenticationModel, Integer>{
    AuthenticationModel findByUsername(String username);
}
