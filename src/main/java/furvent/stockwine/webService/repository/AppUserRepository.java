package furvent.stockwine.webService.repository;

import java.util.Optional;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import furvent.stockwine.webService.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	public Optional<AppUser> findByUsernameAndPassword(@NotNull String username, @NotNull String password);
}
