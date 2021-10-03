package furvent.stockwine.webService.service.implementations;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furvent.stockwine.webService.entity.AppUser;
import furvent.stockwine.webService.repository.AppUserRepository;
import furvent.stockwine.webService.service.interfaces.AppUserService;

@Service
public class AppUserServiceImpl implements AppUserService {
	
	@Autowired
	AppUserRepository appUserRepository;

	public AppUser create(@NotNull String username, @NotNull String password) {
		return appUserRepository.save(new AppUser(username, password));
	}

	public boolean login(@NotNull String username, @NotNull String password) {
		return appUserRepository.findByUsernameAndPassword(username, password).isPresent();
	}

}
