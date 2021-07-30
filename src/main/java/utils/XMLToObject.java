package utils;

import model.RozetkaFilters;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLToObject {
    public static RozetkaFilters readXMLToObject() {
        try {
            File file = new File("src/main/resources/rozetkaFilter.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(RozetkaFilters.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (RozetkaFilters) jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}