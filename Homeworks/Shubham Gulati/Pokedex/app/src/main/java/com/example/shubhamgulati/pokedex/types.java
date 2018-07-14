package com.example.shubhamgulati.pokedex;

public class types {
    int slot;
    type type;

    public types(int slot, com.example.shubhamgulati.pokedex.type type) {
        this.slot = slot;
        this.type = type;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public com.example.shubhamgulati.pokedex.type getType() {
        return type;
    }

    public void setType(com.example.shubhamgulati.pokedex.type type) {
        this.type = type;
    }
}
