package com.ash.nametags;

public enum Rank {

    OWNER("&c&lOwner"),
    HELPER("&a&lHelper"),
    MEMBER("&e&lMember");

    private String display;
    Rank(String display) {
        this.display = display;
    }
    public String getDisplay() {return display;}
}
