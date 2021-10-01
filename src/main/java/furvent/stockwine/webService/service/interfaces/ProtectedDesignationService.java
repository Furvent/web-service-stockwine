package furvent.stockwine.webService.service.interfaces;

import javax.validation.constraints.NotNull;

import furvent.stockwine.webService.entity.ProtectedDesignation;

public interface ProtectedDesignationService {
	public ProtectedDesignation create(@NotNull String publicId, @NotNull String name);
}
