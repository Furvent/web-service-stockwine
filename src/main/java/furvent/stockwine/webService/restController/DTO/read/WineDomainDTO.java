package furvent.stockwine.webService.restController.DTO.read;

import javax.validation.constraints.NotNull;

import furvent.stockwine.webService.entity.WineDomain;
import furvent.stockwine.webService.entity.sharedComposition.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class WineDomainDTO {

	@NotNull
	private String publicId, name;

	private Address address;

	public WineDomainDTO(@NotNull WineDomain wineDomainModel) {
		this.publicId = wineDomainModel.getPublicId();
		this.name = wineDomainModel.getName();
		this.address = wineDomainModel.getAddress();
	}

}
