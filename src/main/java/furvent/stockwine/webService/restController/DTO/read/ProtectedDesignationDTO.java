package furvent.stockwine.webService.restController.DTO.read;

import javax.validation.constraints.NotNull;

import furvent.stockwine.webService.entity.ProtectedDesignation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProtectedDesignationDTO {
	
	@NotNull
	private String publicId, name;

	public ProtectedDesignationDTO(@NotNull ProtectedDesignation protectedDesignationModel) {
		this.publicId = protectedDesignationModel.getPublicId();
		this.name = protectedDesignationModel.getName();
	}
	
	
}
