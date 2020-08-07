package br.com.GabrielIDSM.WebDailyPlanner.Repository;

import br.com.GabrielIDSM.WebDailyPlanner.Model.BirthdayModel;
import br.com.GabrielIDSM.WebDailyPlanner.Model.UserModel;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BirthdayRepository extends PagingAndSortingRepository<BirthdayModel, Integer>{
    List<BirthdayModel> findByUser(UserModel user);
}
