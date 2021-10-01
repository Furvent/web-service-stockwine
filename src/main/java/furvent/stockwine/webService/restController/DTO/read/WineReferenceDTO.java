package furvent.stockwine.webService.restController.DTO.read;

import javax.validation.constraints.NotNull;

import com.sun.istack.Nullable;

import furvent.stockwine.webService.entity.WineReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class WineReferenceDTO {
	@NotNull
	private String publicId, name, category;
	@NotNull
	private float capacity;
	@NotNull
	private WineDomainDTO wineDomain;
	@Nullable
	private ProtectedDesignationDTO protectedDesignation;

	public WineReferenceDTO(@NotNull WineReference wineReferenceModel) {
		this.publicId = wineReferenceModel.getPublicId();
		this.name = wineReferenceModel.getName();
		this.category = wineReferenceModel.getCategory().label;
		this.capacity = wineReferenceModel.getCapacity();
		
		this.wineDomain = new WineDomainDTO(wineReferenceModel.getWineDomain());
		
		if (wineReferenceModel.getProtectedDesignation() != null)
			this.protectedDesignation = new ProtectedDesignationDTO(wineReferenceModel.getProtectedDesignation());
	}

}
