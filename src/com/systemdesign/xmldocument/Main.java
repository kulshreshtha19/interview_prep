package com.systemdesign.xmldocument;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Tag> hmap = new HashMap<>();

        Element element = new Element("Tag1", "Value1");
        ElementList elementList = new ElementList(element);
        hmap.put("Tag1", elementList);

        Element element1 = new Element("Tag2", "Value2");
        ElementList elementList1 = new ElementList(element1);
        hmap.put("Tag2", elementList1);

        elementList.addTag(elementList1);
        elementList.printTag();

        elementList1.printTag();
    }
}
