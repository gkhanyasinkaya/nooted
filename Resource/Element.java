package com.app.nooted.Resource;

public class Element {
    public Element(){}

    public Element(int id, String elementName, String description) {
        this.id = id;
        this.elementName = elementName;
        this.description = description;
    }

    private  int id;
    private String elementName;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}