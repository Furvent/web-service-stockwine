package furvent.stockwine.webService.service.interfaces;

import javax.validation.constraints.NotNull;

import furvent.stockwine.webService.entity.AppUser;

public interface AppUserService {
	
	public AppUser create(@NotNull String username, @NotNull String password);
	
	public boolean login(@NotNull String username, @NotNull String password);
}
