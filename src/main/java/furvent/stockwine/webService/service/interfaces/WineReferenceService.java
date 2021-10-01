package furvent.stockwine.webService.service.interfaces;

import javax.validation.constraints.NotNull;

import com.sun.istack.Nullable;

import furvent.stockwine.webService.entity.ProtectedDesignation;
import furvent.stockwine.webService.entity.WineDomain;
import furvent.stockwine.webService.entity.WineReference;
import furvent.stockwine.webService.entity.enums.WineCategory;

public interface WineReferenceService {
	public WineReference create(@NotNull String publicId, @NotNull String name, @NotNull float capacity,
			@NotNull WineCategory category, @NotNull WineDomain wineDomain, @Nullable ProtectedDesignation protectedDesignation);
}
