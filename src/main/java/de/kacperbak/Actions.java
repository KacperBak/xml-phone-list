package de.kacperbak;

import de.kacperbak.domain.PhoneItem;
import de.kacperbak.domain.PhoneItems;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles all business cases
 */
public class Actions {

    public static Marshaller MARSHALLER = initMarshaller();
    public static String FILE_NAME = "phoneItems.xml";

    public static PhoneItems testData(){
        List<PhoneItem> phoneItems = new ArrayList<>();
        phoneItems.add(new PhoneItem("Kacper", "Bak", "+49/123"));
        phoneItems.add(new PhoneItem("Max", "Muster", "+49/456"));
        phoneItems.add(new PhoneItem("Elena", "Trupp", "+49/789"));
        return new PhoneItems(phoneItems);
    }

    private static Marshaller initMarshaller(){
        Marshaller jaxbMarshaller = null;
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance( PhoneItems.class );
            jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
        } catch(Exception e){
            e.printStackTrace();
        }
        return jaxbMarshaller;
    }

    public static void marshalToFile(PhoneItems phoneItems){
        try{
            Actions.MARSHALLER.marshal( phoneItems, new File(FILE_NAME) );
            Actions.MARSHALLER.marshal( phoneItems, System.out );
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
