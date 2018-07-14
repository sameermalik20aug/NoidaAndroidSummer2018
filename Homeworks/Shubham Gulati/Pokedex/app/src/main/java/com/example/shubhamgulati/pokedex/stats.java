package com.example.shubhamgulati.pokedex;

public class stats {
    stat stat;
    int effort;
    int base_stat;

    public stats(com.example.shubhamgulati.pokedex.stat stat, int effort, int base_stat) {
        this.stat = stat;
        this.effort = effort;
        this.base_stat = base_stat;
    }

    public com.example.shubhamgulati.pokedex.stat getStat() {
        return stat;
    }

    public void setStat(com.example.shubhamgulati.pokedex.stat stat) {
        this.stat = stat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public int getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(int base_stat) {
        this.base_stat = base_stat;
    }
}
