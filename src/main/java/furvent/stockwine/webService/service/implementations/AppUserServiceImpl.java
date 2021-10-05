package furvent.stockwine.webService.service.implementations;

import java.util.Collections;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import furvent.stockwine.webService.entity.AppUser;
import furvent.stockwine.webService.repository.AppUserRepository;
import furvent.stockwine.webService.service.interfaces.AppUserService;

@Service
public class AppUserServiceImpl implements AppUserService, UserDetailsService {
	
	@Autowired
	AppUserRepository appUserRepository;

	public AppUser create(@NotNull String username, @NotNull String password) {
		return appUserRepository.save(new AppUser(username, password));
	}

	public boolean login(@NotNull String username, @NotNull String password) {
		return appUserRepository.findByUsernameAndPassword(username, password).isPresent();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> appUserEntityOpt = appUserRepository.findByUsername(username);
		
		if (appUserEntityOpt.isEmpty()) {
			throw new UsernameNotFoundException(username);
		}
		
		return new User(appUserEntityOpt.get().getUsername(), appUserEntityOpt.get().getPassword(), Collections.emptyList());
	}

}
