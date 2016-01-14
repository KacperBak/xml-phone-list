package de.kacperbak;

import de.kacperbak.domain.PhoneItem;
import de.kacperbak.domain.PhoneItems;
import java.util.Scanner;

/**
 * Handles entire user interactions
 */
public class CliUtils {

    public static Scanner SCANNER =  new Scanner(System.in);

    public static final String WELCOME_TEXT = "-------------------------------\n" + "Welcome to Xml phone list 2000!\n" + "-------------------------------\n";
    public static final String ACTION_TEXT   = "Please choose an action: \n" + "(d)isplay current items\n" + "(n)ew item\n" + "(s)ave items to file\n" + "(t)est data\n";
    public static final String ACTION_NOT_IMPLEMENTED   = "----------------------\n" + "Action not implemented\n" + "----------------------\n";
    public static final String EXIT_TEXT   = "Bye ...";
    public static final String NEW_ITEM_CREATED_TEXT = "--------------------------------\n" + "SUCCESS: New phone item created!\n" + "--------------------------------\n";
    public static final String FIRST_NAME_TEXT = "Enter fristName: ";
    public static final String LAST_NAME_TEXT = "Enter lastName: ";
    public static final String NUMBER_TEXT = "Enter number: ";
    public static final String SAVED_TEXT = "------------------------\n"+ "Items saved to XML file.\n" + "------------------------\n";


    public static void welcome(){
        System.out.println(WELCOME_TEXT);
        actions();
    }

    public static void actions(){
        System.out.println(ACTION_TEXT);
    }

    public static void exit(){
        System.out.println(EXIT_TEXT);
    }

    public static void newItemCreated(){
        System.out.println(NEW_ITEM_CREATED_TEXT);
    }

    public static void actionNotImlemented(){
        System.out.println(ACTION_NOT_IMPLEMENTED);
    }

    public static void enterFirstName(){
        System.out.println(FIRST_NAME_TEXT);
    }

    public static void enterLastName(){
        System.out.println(LAST_NAME_TEXT);
    }

    public static void enterNumber(){
        System.out.println(NUMBER_TEXT);
    }

    public static void savedItems(){
        System.out.println(SAVED_TEXT);
    }

    public static void displayItems(PhoneItems phoneItems){
        StringBuilder builder = new StringBuilder();
        builder.append("FirstName: , LastName: , PhoneNumber:\n");
        builder.append("-----------, ----------, ------------\n");
        if(phoneItems != null && phoneItems.getItems() != null && phoneItems.getItems().size() > 0){
            for(PhoneItem item : phoneItems.getItems()){
                builder.append(item.getFirstName()).append(",");
                builder.append(item.getLastName()).append(",");
                builder.append(item.getNumber()).append("\n");
            }
        }
        System.out.println(builder.toString());
    }
}
