package com.example.android.unit5mid_unitpractical.model;

/**
 * Created by C4Q on 1/24/18.
 */
import java.util.jar.Attributes;

public class User {

    private Name name;
    private Location location;
    private String email;
    private String dob;
    private String cell;
    private Picture picture;

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getCell() {
        return cell;
    }

    public Picture getPicture() {
        return picture;
    }
}