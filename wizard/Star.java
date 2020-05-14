package com.wizard;

import java.util.HashSet;
import java.util.Set;

public class Star extends HeavenlyBody {

    public Star(String name,double orbitalPeriod) {
        super(name,orbitalPeriod,BodyTypes.STAR);
    }

    @Override
    public boolean addSatellite(HeavenlyBody planet) {
        if(planet.getKey().getBodyType() == BodyTypes.PLANET) {
            return super.addSatellite(planet);
        }
        return false;
    }
}
