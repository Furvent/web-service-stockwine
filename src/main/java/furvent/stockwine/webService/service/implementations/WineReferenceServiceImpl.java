package furvent.stockwine.webService.service.implementations;

import java.util.List;
import java.util.Optional;

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
public final class WineReferenceServiceImpl implements WineReferenceService {
	
	@Autowired
	WineReferenceRepository wineReferenceRepository;

	public WineReference create(@NotNull String publicId, @NotNull String name, @NotNull float capacity,
			@NotNull WineCategory category, @NotNull WineDomain wineDomain, @Nullable ProtectedDesignation protectedDesignation) {
		WineReference newWineReference = new WineReference(publicId, name, capacity, category, wineDomain);
		if (protectedDesignation != null)
			newWineReference.setProtectedDesignation(protectedDesignation);
		return wineReferenceRepository.save(newWineReference);
	}
	
	public List<WineReference> getAllWineReferencesByName(String partialNameToSearch) {
		return wineReferenceRepository.findAllByNameContaining(partialNameToSearch);
	}

	public List<WineReference> getAllWineReference() {
		return wineReferenceRepository.findAll();
	}

	public Optional<WineReference> getWineReferenceByPublicId(String publicId) {
		return wineReferenceRepository.findByPublicId(publicId);
	}
	
}
