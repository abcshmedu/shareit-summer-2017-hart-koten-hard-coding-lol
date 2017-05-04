package edu.hm.cs.swa.model;

public class Copy {

    private final Medium medium;

    private String owner;


    public Copy(final Medium medium, final String owner) {
        this.medium = medium;
        this.owner = owner;
    }


    public Medium getMedium() {
        return medium;
    }


    public String getOwner() {
        return owner;
    }
}
