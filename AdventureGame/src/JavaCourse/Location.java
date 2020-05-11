package com.wizard;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;
// There are improvemnets have been made to make this class immutable in order to prevent instance variables to be edited externally after
    // they have been initialized. Also a if not null condition has also been set to avoid NullPointerException.
    protected Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits != null) {
            this.exits = new HashMap<String, Integer>(exits);
        } else {
            this.exits = new HashMap<String, Integer>();
        }
        this.exits.put("Q",0);
    }

    protected String getDescription() {
        return description;
    }

    protected Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }

    protected int getLocationID() {
        return locationID;
    }
}
