package furvent.stockwine.webService.service.implementations;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.istack.Nullable;

import furvent.stockwine.webService.entity.WineDomain;
import furvent.stockwine.webService.entity.sharedComposition.Address;
import furvent.stockwine.webService.repository.WineDomainRepository;
import furvent.stockwine.webService.service.interfaces.WineDomainService;

@Service
public class WineDomainServiceImpl implements WineDomainService {

	@Autowired
	WineDomainRepository wineDomainRepository;

	public WineDomain create(@NotNull String publicId, @NotNull String name, @Nullable Address address) {
		WineDomain newWineDomain = new WineDomain(publicId, name);
		if (address != null)
			newWineDomain.setAddress(address);
		return wineDomainRepository.save(newWineDomain);
	}

}
