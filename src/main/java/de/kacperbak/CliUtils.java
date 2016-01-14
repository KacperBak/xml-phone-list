package de.kacperbak;

import de.kacperbak.domain.PhoneItem;
import de.kacperbak.domain.PhoneItems;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Arrays;

/**
 * Created by bakka on 14.01.16.
 */
public class CliUtils {

    public static final String WELCOME = "-------------------------------\n" + "Welcome to Xml phone list 2000!\n" + "-------------------------------\n";

    public static Marshaller MARSHALLER = initMarshaller();

    public static void welcome(){
        System.out.println(WELCOME);
    }

    public static PhoneItems testData(){
        PhoneItem kacperBak = new PhoneItem("Kacper", "Bak", "+49/123");
        PhoneItem maxMuster = new PhoneItem("Max", "Muster", "+49/456");
        PhoneItem elenaTrupp = new PhoneItem("Elena", "Trupp", "+49/789");
        return new PhoneItems(Arrays.asList(new PhoneItem[]{kacperBak, maxMuster, elenaTrupp}));
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
            CliUtils.MARSHALLER.marshal( phoneItems, new File( "phoneItems.xml" ) );
            CliUtils.MARSHALLER.marshal( phoneItems, System.out );
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
