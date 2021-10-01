package furvent.stockwine.webService;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import furvent.stockwine.webService.entity.ProtectedDesignation;
import furvent.stockwine.webService.entity.WineDomain;
import furvent.stockwine.webService.entity.enums.WineCategory;
import furvent.stockwine.webService.entity.sharedComposition.Address;
import furvent.stockwine.webService.service.interfaces.ProtectedDesignationService;
import furvent.stockwine.webService.service.interfaces.WineDomainService;
import furvent.stockwine.webService.service.interfaces.WineReferenceService;

@Profile("initData")
@Component
public class MockedDataAtInit {

	@Autowired
	WineReferenceService wineReferenceService;

	@Autowired
	WineDomainService wineDomainService;

	@Autowired
	ProtectedDesignationService protectedDesignationService;

	private int refCounter = 1;

	@PostConstruct
	public void initDBPopulating() {
		// Address will be used everywhere needed.
		Address standardAddress = new Address(1, "Street name", "City name", "Region name", "Country name",
				"Others infos");

		// Domain's creation.
		WineDomain wineDomain1 = wineDomainService.create(UUID.randomUUID().toString(), "Domain's name: 1",
				standardAddress);
		WineDomain wineDomain2 = wineDomainService.create(UUID.randomUUID().toString(), "Domain's name: 2",
				standardAddress);
		WineDomain wineDomain3 = wineDomainService.create(UUID.randomUUID().toString(), "Domain's name: 3, no address",
				null);

		// Protected designation's creation.
		ProtectedDesignation protectedDesignation1 = protectedDesignationService.create(UUID.randomUUID().toString(),
				"Protected designation number 1");
		ProtectedDesignation protectedDesignation2 = protectedDesignationService.create(UUID.randomUUID().toString(),
				"Protected designation number 2");
		ProtectedDesignation protectedDesignation3 = protectedDesignationService.create(UUID.randomUUID().toString(),
				"Protected designation number 3");

		// Wine reference's creation.
		// Domain 1
		this.createWineReferencesWithDataByDomain(new float[] { 0.75f, 0.75f, 0.75f },
				new WineCategory[] { WineCategory.RED, WineCategory.RED, WineCategory.WHITE },
				new ProtectedDesignation[] { protectedDesignation1, protectedDesignation1, null }, wineDomain1);
		// Domain 2
		this.createWineReferencesWithDataByDomain(new float[] { 0.75f, 0.75f, 1f },
				new WineCategory[] { WineCategory.RED, WineCategory.RED, WineCategory.SPARKLING },
				new ProtectedDesignation[] { null, protectedDesignation1, protectedDesignation2 },
				wineDomain2);
		this.createWineReferencesWithDataByDomain(new float[] { 0.75f, 1f, 0.75f },
				new WineCategory[] { WineCategory.RED, WineCategory.SPARKLING, WineCategory.WHITE },
				new ProtectedDesignation[] { protectedDesignation1, protectedDesignation2, protectedDesignation3 },
				wineDomain3);

	}

	private void createWineReferencesWithDataByDomain(float[] capacities, WineCategory[] categories,
			ProtectedDesignation[] designations, WineDomain domain) {
		for (int i = 0; i < capacities.length; i++) {
			wineReferenceService.create(UUID.randomUUID().toString(), generateRefName(), capacities[i], categories[i],
					domain, designations[i]);
		}

	}

	private String generateRefName() {
		return "Ref " + this.refCounter++;
	}
}