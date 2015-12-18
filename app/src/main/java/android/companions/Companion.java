package android.companions;

public class Companion {

    String companion;

    int gender;
    int face;
    int health;
    int joy;
    int hunger;
    int thirst;
    int bladder;
    int manky;
    int full;

    Companion (String petName, int petGender, int petFace) {
        companion = petName;
        gender = petGender;
        face = petFace;
        health = 10;
        joy = 10;
        hunger = 0;
        thirst = 0;
        bladder = 0;
        manky = 0;
        full = 0;
    }

    public void setHealth(int h) {
        this.health = h;
    }
    public void setJoy(int j) {
        this.joy = j;
    }
    public void setHunger(int h) {
        this.hunger = h;
    }
    public void setThirst(int t) {
        this.thirst = t;
    }

    public void setBladder(int b) {
        this.bladder = b;
    }

    public void setManky(int m) {
        this.manky = m;
    }

    public void setFull(int f) {
        this.full = f;
    }
    void setGender(int newGender) {
        gender = newGender;
    }
    void setFace(int newFace) {
        face = newFace;
    }
    void setCompanion(String name) {
        companion = name;
    }



    int getGender() {
        return gender;
    }
    int getFace() {
        return face;
    }
    String getCompanion() {
        return companion;
    }
    int getHunger() {
        return hunger;
    }
    int getThirst() {
        return thirst;
    }
    int getBladder() {
        return bladder;
    }
    int getManky() {
        return manky;
    }
    int getJoy() {
        return joy;
    }
    int getFull() {
        return full;
    }
    int getHealth() {
        return health;
    }


    void calcStats() {

        if (full > 0) {
            bladder++;
            full--;
        } else {
            if (hunger < 100) {
                hunger++;
            }
            if (thirst < 100) {
                thirst++;
            }
        }

        if (bladder >= 100) {
            manky = manky + 10;
            bladder = 0;
        }

        if (manky >= 100) {

        }
    }

    void reset() {
        health = 10;
        joy = 10;
        hunger = 0;
        thirst = 0;
        bladder = 0;
        manky = 0;
        full = 0;
    }
}
