package Marshaling;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(propOrder = {"name", "capital", "continent", "population"})
@XmlRootElement(name = "Country")
public class Country {
	private String name;
	private String capital;
//	private LocalDate foundation;
	private String continent;
	private int population;

	public String getName() {
		return name;
	}

	@XmlElement(name = "Country_Name")
	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	@XmlElement(name = "Country_Capital")
	public void setCapital(String capital) {
		this.capital = capital;
	}

//	@XmlJavaTypeAdapter( DateAdapter.class )
//	public LocalDate getFoundation() {
//		return foundation;
//	}
//
//	@XmlElement(name = "Country_Foundation_Date")
//	public void setFoundation(LocalDate foundation) {
//		this.foundation = foundation;
//	}

	public String getContinent() {
		return continent;
	}

	@XmlElement( name = "Country_Continent" )
	public void setContinent(String continent) {
		this.continent = continent;
	}

	public int getPopulation() {
		return population;
	}

	@XmlElement(name = "Country_Population" )
	public void setPopulation(int population) {
		this.population = population;
	}
}
