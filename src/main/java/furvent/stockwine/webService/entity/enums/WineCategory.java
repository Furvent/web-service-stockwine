package furvent.stockwine.webService.entity.enums;

public enum WineCategory {
	RED("RED"), WHITE("WHITE"), ROSE("ROSE"), SPARKLING("SPARKLING"), YELLOW("YELLOW"), SWEET("SWEET"),
	DESSERT("DESSERT");

	public final String label;

	private WineCategory(String label) {
		this.label = label;
	}
}
