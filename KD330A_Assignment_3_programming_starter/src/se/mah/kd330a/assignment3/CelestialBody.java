package se.mah.kd330a.assignment3;

/**
 * The basic celestial body information
 * 
 * @author ksango
 * 
 */
public class CelestialBody {

	private String name;
	private int image;

	public CelestialBody(String name, int image) {
		super();
		this.name = name;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

}
