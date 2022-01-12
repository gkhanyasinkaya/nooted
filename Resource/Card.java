package com.app.nooted.Resource;

public class Card {

    private int id;
    private  int elementId;
    private  int workSpaceId;
    private String name;
    private int positionX;
    private  int positionY;
    private String bgColor;

    public Card(){}

    public Card(int id, int elementId, int workSpaceId, String name, int positionX, int positionY,String bgColor) {
        this.id = id;
        this.elementId = elementId;
        this.workSpaceId = workSpaceId;
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.bgColor = bgColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public int getWorkSpaceId() {
        return workSpaceId;
    }

    public void setWorkSpaceId(int workSpaceId) {
        this.workSpaceId = workSpaceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }


}