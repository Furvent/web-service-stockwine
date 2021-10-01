package furvent.stockwine.webService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import furvent.stockwine.webService.entity.enums.WineCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "wine_reference")
public final class WineReference {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@NotNull
	private String publicId;

	@Column(length = 300)
	@NotNull
	private String name;

	@NotNull
	private float capacity;

	@NotNull
	@Enumerated(EnumType.STRING)
	private WineCategory category;

	@ManyToOne
	@JoinColumn(nullable = true, name = "fk_protected_designation_id")
	private ProtectedDesignation protectedDesignation;

	@ManyToOne
	@NotNull
	@JoinColumn(nullable = false, name = "fk_wine_domain_id")
	private WineDomain wineDomain;

	public WineReference(@NotNull String publicId, @NotNull String name, @NotNull float capacity,
			@NotNull WineCategory category, @NotNull WineDomain wineDomain) {
		super();
		this.publicId = publicId;
		this.name = name;
		this.capacity = capacity;
		this.category = category;
		this.wineDomain = wineDomain;
	}

	public WineReference(@NotNull String publicId, @NotNull String name, @NotNull float capacity,
			@NotNull WineCategory category, @NotNull WineDomain wineDomain, ProtectedDesignation protectedDesignation) {
		this(publicId, name, capacity, category, wineDomain);
		this.protectedDesignation = protectedDesignation;
	}

}
