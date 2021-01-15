package com.qaprosoft.carina.demo.gui.enums;

public enum MenuItem {
    NOTEBOOKS("Ноутбуки"),
    MOBILES("Мобильные телефоны");

    private String value;

    MenuItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
