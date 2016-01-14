package de.kacperbak.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by bakka on 14.01.16.
 */
@XmlRootElement(name = "PHONE_ITEMS")
public class PhoneItems {

    @XmlElement(name = "PHONE_ITEM")
    private List<PhoneItem> items;

    public PhoneItems(List<PhoneItem> items) {
        this.items = items;
    }

    public PhoneItems() {
    }

    public List<PhoneItem> getItems() {
        return items;
    }
}
