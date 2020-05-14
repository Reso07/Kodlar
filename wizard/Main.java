package com.wizard;

import java.util.*;

public class Main {

    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<Star> stars = new HashSet<>();
    private static Set<Planet> planets = new HashSet<>();
    private static Set<Moon> moons = new HashSet<>();

    public static void main(String[] args) {
        Star sun = new Star("Sun",200000000);
        stars.add(sun);
        Planet planet = new Planet("Mercury",88);
        solarSystem.put(planet.getKey(), planet);
        planets.add(planet);

        planet = new Planet("Venus",225);
        solarSystem.put(planet.getKey(), planet);
        planets.add(planet);

        planet = new Planet("Earth",365);
        solarSystem.put(planet.getKey(), planet);
        planets.add(planet);

        Moon moon = new Moon("Moon",27);
        solarSystem.put(moon.getKey(),moon);
        planet.addSatellite(moon);

        planet = new Planet("Mars",455);
        solarSystem.put(planet.getKey(),planet);
        planets.add(planet);


        moon = new Moon("Deimos",39);
        solarSystem.put(moon.getKey(),moon);
        planet.addSatellite(moon);

        moon = new Moon("Phobos",41);
        solarSystem.put(moon.getKey(),moon);
        planet.addSatellite(moon);

        planet = new Planet("Jupiter",879);
        solarSystem.put(planet.getKey(),planet);
        planets.add(planet);

        moon = new Moon("Callisto",50);
        solarSystem.put(moon.getKey(),moon);
        planet.addSatellite(moon);

        moon = new Moon("Europa",47);
        solarSystem.put(moon.getKey(),moon);
        planet.addSatellite(moon);

        moon = new Moon("IO",43);
        solarSystem.put(moon.getKey(), moon);
        planet.addSatellite(moon);

        System.out.println("Planets in the Solar System");
        for(HeavenlyBody p : planets) {
            System.out.println(p);
        }

        planet = (Planet) solarSystem.get(HeavenlyBody.makeKey("Mars", HeavenlyBody.BodyTypes.PLANET));
        System.out.println("Moons of "+planet.getKey().getName());
        for(HeavenlyBody p : planet.getSatellites()) {
            System.out.println(p);
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for(Planet p : planets) {
            moons.addAll(p.getSatellites());
        }

        System.out.println("All moons");
        for(HeavenlyBody m : moons) {
            System.out.println(m);
        }

        Planet pluto = new Planet("Pluto",1099);
        planets.add(pluto);



        for(Planet p : planets) {
            System.out.println(p);
        }
    }
}
