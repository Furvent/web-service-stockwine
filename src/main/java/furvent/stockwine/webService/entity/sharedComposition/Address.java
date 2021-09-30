package furvent.stockwine.webService.entity.sharedComposition;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Address {
	
	private int number;
	
	@Column(length = 300)
	private String streetName, cityName, regionName, countryName;
	
	@Column(length = 1000)
	private String othersInformations;
}
