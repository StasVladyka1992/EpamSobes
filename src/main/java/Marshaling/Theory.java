package Marshaling;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/*
https://www.javacodegeeks.com/2014/12/jaxb-tutorial-xml-binding.html
 */
public class Theory {
	public static void main(String[] args) {
		Country spain = new Country();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		spain.setContinent("Europe");
		spain.setPopulation(45000000);

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(spain, new File("country.xml"));
			jaxbMarshaller.marshal(spain, System.out);
		}
		catch (JAXBException e){
			System.out.println(e.getCause());
		}
	}
}
