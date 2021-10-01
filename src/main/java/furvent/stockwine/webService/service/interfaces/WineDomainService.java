package furvent.stockwine.webService.service.interfaces;

import javax.validation.constraints.NotNull;

import com.sun.istack.Nullable;

import furvent.stockwine.webService.entity.WineDomain;
import furvent.stockwine.webService.entity.sharedComposition.Address;

public interface WineDomainService {
	public WineDomain create(@NotNull String publicId, @NotNull String name, @Nullable Address address);
}
