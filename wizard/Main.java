package com.wizard;

import java.util.*;

public class Main {

    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody planet = new HeavenlyBody("Mercury",88);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        planet = new HeavenlyBody("Venus",225);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        planet = new HeavenlyBody("Earth",365);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        HeavenlyBody moon = new HeavenlyBody("Moon",27);
        solarSystem.put(moon.getName(),moon);
        planet.addMoon(moon);

        planet = new HeavenlyBody("Mars",455);
        solarSystem.put(planet.getName(),planet);
        planets.add(planet);

        moon = new HeavenlyBody("Deimos",39);
        solarSystem.put(moon.getName(),moon);
        planet.addMoon(moon);

        moon = new HeavenlyBody("Phobos",41);
        solarSystem.put(moon.getName(),moon);
        planet.addMoon(moon);

        planet = new HeavenlyBody("Jupiter",879);
        solarSystem.put(planet.getName(),planet);
        planets.add(planet);

        moon = new HeavenlyBody("Callisto",50);
        solarSystem.put(moon.getName(),moon);
        planet.addMoon(moon);

        moon = new HeavenlyBody("Europa",47);
        solarSystem.put(moon.getName(),moon);
        planet.addMoon(moon);

        moon = new HeavenlyBody("IO",43);
        solarSystem.put(moon.getName(), moon);
        planet.addMoon(moon);

        System.out.println("Planets in the Solar System");
        for(HeavenlyBody p : planets) {
            System.out.println("\t"+p.getName());
        }

        planet = solarSystem.get("Mars");
        System.out.println("Moons of "+planet.getName());
        for(HeavenlyBody p : planet.getSatellites()) {
            System.out.println("\t"+p.getName());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody p : planets) {
            moons.addAll(p.getSatellites());
        }

        System.out.println("All moons");
        for(HeavenlyBody m : moons) {
            System.out.println("\t"+m.getName());
        }

        HeavenlyBody pluto = new HeavenlyBody("Mars",1099);
        planets.add(pluto);

        for(HeavenlyBody p : planets) {
            System.out.println(p.getName()+ " - "+p.getOrbitalPeriod());
        }

        Object o = new Object();
        o.equals(o);
        "pluto".equals("");
    }
}
