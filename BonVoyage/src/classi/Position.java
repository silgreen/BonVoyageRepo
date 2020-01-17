package classi;

public class Position {
	private String city;
	private String region;
	 
	
	public String toStringCity() {
		return "Position [city=" + city + ", region=" + region + "]";
	}
	public String getCity() {
		return city;
	}
	public String getRegion() {
		return region;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setRegion(String region) {
		this.region = region;
	}
}
