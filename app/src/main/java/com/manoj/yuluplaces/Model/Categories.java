package com.manoj.yuluplaces.Model;

import com.google.gson.Gson;
import com.manoj.yuluplaces.Model.Icon;

public class Categories {
    private String pluralName;

    private String name;

    private Icon icon;

    private String id;

    private String shortName;

    private String primary;

    public String getPluralName() {
        return pluralName;
    }

    public void setPluralName(String pluralName) {
        this.pluralName = pluralName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    @Override
    public String toString() {
        return toJson();
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}