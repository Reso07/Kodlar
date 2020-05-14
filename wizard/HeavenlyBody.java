package com.wizard;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes {
        MOON,
        PLANET,
        STAR
    }

    public HeavenlyBody(String name, double orbitalPeriod,BodyTypes bodyType) {
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        key = new Key(name,bodyType);
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }


    public boolean addSatellite(HeavenlyBody satellite) {
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<HeavenlyBody>(this.satellites);
    }

    @Override
    public String toString() {
        return key.getBodyType() + " : " + key.getName() + ", " + getOrbitalPeriod();
    }

    @Override
    public final int hashCode() {
        return key.hashCode();
    }

    public Key getKey() {
        return key;
    }

    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj instanceof HeavenlyBody) {
            HeavenlyBody object = (HeavenlyBody) obj;
            return (key == object.getKey());
        }
        if(obj == null || !obj.getClass().equals(this.getClass())) {
            return false;
        }
        return false;
    }

    protected static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name,bodyType);
    }


    protected static final class Key {
        private String name;
        private BodyTypes bodyType;

        public Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        public String getName() {
            return name;
        }

        @Override
        public int hashCode() {
            return name.hashCode() + 57 + bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            obj = (Key) obj;
            if(name.equals(((Key) obj).getName())) {
                return (bodyType == ((Key) obj).getBodyType());
            }
            return false;
        }
    }
}
