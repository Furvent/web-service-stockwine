package furvent.stockwine.webService.service.implementations;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furvent.stockwine.webService.entity.ProtectedDesignation;
import furvent.stockwine.webService.repository.ProtectedDesignationRepository;
import furvent.stockwine.webService.service.interfaces.ProtectedDesignationService;

@Service
public class ProtectedDesignationServiceImpl implements ProtectedDesignationService {
	
	@Autowired
	ProtectedDesignationRepository protectedDesignationRepository;

	public ProtectedDesignation create(@NotNull String publicId, @NotNull String name) {
		return protectedDesignationRepository.save(new ProtectedDesignation(publicId, name));
	}
	
}
