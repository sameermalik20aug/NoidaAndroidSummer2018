package com.example.shubhamgulati.pokedex;

import java.util.ArrayList;

public class APIResponse {
    private ArrayList<stats> stats;
    String name;
    int weight;
    sprites sprites;
    int height;
    int id;
    int base_experience;
    ArrayList<types> types;

    public APIResponse(ArrayList<com.example.shubhamgulati.pokedex.stats> stats, String name, int weight, com.example.shubhamgulati.pokedex.sprites sprites, int height, int id, int base_experience, ArrayList<com.example.shubhamgulati.pokedex.types> types) {
        this.stats = stats;
        this.name = name;
        this.weight = weight;
        this.sprites = sprites;
        this.height = height;
        this.id = id;
        this.base_experience = base_experience;
        this.types = types;
    }

    public ArrayList<com.example.shubhamgulati.pokedex.stats> getStats() {
        return stats;
    }

    public void setStats(ArrayList<com.example.shubhamgulati.pokedex.stats> stats) {
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public com.example.shubhamgulati.pokedex.sprites getSprites() {
        return sprites;
    }

    public void setSprites(com.example.shubhamgulati.pokedex.sprites sprites) {
        this.sprites = sprites;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }

    public ArrayList<com.example.shubhamgulati.pokedex.types> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<com.example.shubhamgulati.pokedex.types> types) {
        this.types = types;
    }
}
