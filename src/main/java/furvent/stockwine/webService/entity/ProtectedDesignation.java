package furvent.stockwine.webService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "protected_designation")
public final class ProtectedDesignation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	@NotNull
	private String publicId;

	@Column(length = 300)
	@NotNull
	private String name;

	public ProtectedDesignation(@NotNull String name, @NotNull String publicId) {
		this.name = name;
		this.publicId = publicId;
	}

}
