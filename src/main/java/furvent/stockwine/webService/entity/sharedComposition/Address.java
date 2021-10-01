package furvent.stockwine.webService.entity.sharedComposition;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Address {

	@NotNull
	private Integer number;

	@Column(length = 300)
	@NotNull
	private String streetName, cityName, regionName, countryName;

	@Column(length = 1000)
	@NotNull
	private String othersInformations;

	public Address(@NotNull int number, @NotNull String streetName, @NotNull String cityName,
			@NotNull String regionName, @NotNull String countryName) {
		this.number = number;
		this.streetName = streetName;
		this.cityName = cityName;
		this.regionName = regionName;
		this.countryName = countryName;
	}

	public Address(@NotNull int number, @NotNull String streetName, @NotNull String cityName,
			@NotNull String regionName, @NotNull String countryName, @NotNull String othersInformations) {
		this(number, streetName, cityName, regionName, countryName);
		this.othersInformations = othersInformations;
	}

}
