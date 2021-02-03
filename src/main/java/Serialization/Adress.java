package Serialization;

import java.io.Serializable;

/**
 * @project EpamSobes
 * author Stas Vladyka on 13.08.2019.
 */

public class Adress implements Serializable {
    private String street;
    private String city;
    private String coutry;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCoutry() {
        return coutry;
    }

    public void setCoutry(String coutry) {
        this.coutry = coutry;
    }

    public Adress() {
        super();
    }

    public Adress(String street, String city, String coutry) {
        this.street = street;
        this.city = city;
        this.coutry = coutry;
    }

	@Override
	public String toString() {
		return "Adress{" +
				"street='" + street + '\'' +
				", city='" + city + '\'' +
				", coutry='" + coutry + '\'' +
				'}';
	}
}
