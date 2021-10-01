package furvent.stockwine.webService.service.implementations;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.istack.Nullable;

import furvent.stockwine.webService.entity.ProtectedDesignation;
import furvent.stockwine.webService.entity.WineDomain;
import furvent.stockwine.webService.entity.WineReference;
import furvent.stockwine.webService.entity.enums.WineCategory;
import furvent.stockwine.webService.repository.WineReferenceRepository;
import furvent.stockwine.webService.service.interfaces.WineReferenceService;

@Service
public class WineReferenceServiceImpl implements WineReferenceService {
	
	@Autowired
	WineReferenceRepository wineReferenceRepository;

	public WineReference create(@NotNull String publicId, @NotNull String name, @NotNull float capacity,
			@NotNull WineCategory category, @NotNull WineDomain wineDomain, @Nullable ProtectedDesignation protectedDesignation) {
		WineReference newWineReference = new WineReference(publicId, name, capacity, category, wineDomain);
		if (protectedDesignation != null)
			newWineReference.setProtectedDesignation(protectedDesignation);
		return wineReferenceRepository.save(newWineReference);
	}
	
}
