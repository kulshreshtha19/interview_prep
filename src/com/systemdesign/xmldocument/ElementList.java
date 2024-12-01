package com.systemdesign.xmldocument;

import java.util.ArrayList;
import java.util.List;

public class ElementList implements Tag {

    Tag element;

    List<Tag> tags;


    ElementList(Tag element) {
        this.element = element;
        this.tags = new ArrayList<>();
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    @Override
    public void printTag() {
        System.out.println("<" + this.element.getName() + ">" + this.element.getValue());
        for (Tag tag : tags) {
            tag.printTag();
        }
        System.out.println("</" + this.element.getName() + ">");
    }

    @Override
    public String getName() {
        return this.element.getName();
    }

    @Override
    public String getValue() {
        return this.element.getValue();
    }
}
