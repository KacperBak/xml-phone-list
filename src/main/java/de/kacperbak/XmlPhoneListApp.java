package de.kacperbak;

import de.kacperbak.domain.PhoneItem;
import de.kacperbak.domain.PhoneItems;

import java.util.ArrayList;

/**
 * Created by bakka on 14.01.16.
 */
public class XmlPhoneListApp {


    public static void main(String[] args) {
        boolean loop = true;
        PhoneItems phoneItems = new PhoneItems(new ArrayList<>());

        CliUtils.welcome();
        String scannerInput = CliUtils.SCANNER.nextLine();

        while(loop){
            switch(scannerInput){

                case "d":
                    CliUtils.displayItems(phoneItems);
                    scannerInput = CliUtils.SCANNER.nextLine();
                    break;

                case "n":
                    CliUtils.enterFirstName();
                    String firstName = CliUtils.SCANNER.nextLine();
                    CliUtils.enterLastName();
                    String lastName = CliUtils.SCANNER.nextLine();
                    CliUtils.enterNumber();
                    String number = CliUtils.SCANNER.nextLine();
                    PhoneItem item = new PhoneItem(firstName, lastName, number);
                    phoneItems.getItems().add(item);
                    CliUtils.newItemCreated();
                    CliUtils.actions();
                    scannerInput = CliUtils.SCANNER.nextLine();
                    break;

                case "s":
                    Actions.marshalToFile(phoneItems);
                    CliUtils.savedItems();
                    scannerInput = CliUtils.SCANNER.nextLine();
                    break;

                case "t":
                    phoneItems = Actions.testData();
                    CliUtils.displayItems(phoneItems);
                    scannerInput = CliUtils.SCANNER.nextLine();
                    break;

                case "e":
                    CliUtils.exit();
                    loop = false;
                    break;

                default:
                    CliUtils.actionNotImlemented();
                    CliUtils.actions();
                    scannerInput = CliUtils.SCANNER.nextLine();
                    break;
            }
        }
    }
}
