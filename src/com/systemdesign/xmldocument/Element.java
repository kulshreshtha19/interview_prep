package com.systemdesign.xmldocument;

public class Element implements Tag {

    String name;

    String value;

    Element(String name, String value) {
        this.name = name;
        this.value = value;
    }


    @Override
    public void printTag() {
        System.out.printf("<%s>%s</%s>", this.name, this.value, this.value);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
