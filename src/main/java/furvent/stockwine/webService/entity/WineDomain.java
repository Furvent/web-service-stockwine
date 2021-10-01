package furvent.stockwine.webService.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import furvent.stockwine.webService.entity.sharedComposition.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "wine_domain")
public final class WineDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@NotNull
	private String publicId;

	@NotNull
	private String name;

	@Embedded
	private Address address;

	public WineDomain(@NotNull String publicId, @NotNull String name) {
		this.publicId = publicId;
		this.name = name;
	}

	public WineDomain(@NotNull String publicId, @NotNull String name, @NotNull Address address) {
		this(publicId, name);
		this.address = address;
	}

}
