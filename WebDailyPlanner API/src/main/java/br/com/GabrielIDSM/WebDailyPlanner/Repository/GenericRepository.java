package br.com.GabrielIDSM.WebDailyPlanner.Repository;

import br.com.GabrielIDSM.WebDailyPlanner.Model.GenericModel;
import br.com.GabrielIDSM.WebDailyPlanner.Model.UserModel;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GenericRepository extends PagingAndSortingRepository<GenericModel, Integer>{
    List<GenericModel> findByUser(UserModel user);
}
