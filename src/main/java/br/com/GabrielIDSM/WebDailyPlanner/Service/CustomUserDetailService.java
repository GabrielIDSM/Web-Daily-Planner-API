package br.com.GabrielIDSM.WebDailyPlanner.Service;

import br.com.GabrielIDSM.WebDailyPlanner.Model.AuthenticationModel;
import br.com.GabrielIDSM.WebDailyPlanner.Repository.AuthenticationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService{
    private final AuthenticationRepository repository;
    
    @Autowired
    public CustomUserDetailService(AuthenticationRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthenticationModel auth = Optional.ofNullable(repository.findByUsername(username))
                .orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
        return new org.springframework.security.core.userdetails
                .User(auth.getUsername(), auth.getPassword(), auth.isAcess() ? authorityListAdmin : authorityListUser);
    }
    
}
