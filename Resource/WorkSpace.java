package com.app.nooted.Resource;

import java.util.ArrayList;

public class WorkSpace {

    private int id;
    private  String workSpaceName;
    private String bgColor;


    public  WorkSpace(){};

    public WorkSpace(int id, String workSpaceName, String bgColor) {
        this.id = id;
        this.workSpaceName = workSpaceName;
        this.bgColor = bgColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkSpaceName() {
        return workSpaceName;
    }

    public void setWorkSpaceName(String workSpaceName) {
        this.workSpaceName = workSpaceName;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

}