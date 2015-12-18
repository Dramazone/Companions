package android.companions;

public class Game {
    int comSize;
    int points;
    long lifeTime;

    Game(int size) {
        comSize = size;
        points = 0;
        lifeTime = System.currentTimeMillis();
    }

    public void setPoints(int p) {
        this.points = p;
    }

    public void setLifeTime(long l) {
        this.lifeTime = l;
    }

    public void addPoints(int p) {
        this.points = this.points + p;
    }
    public void subPoints(int p) {
        this.points = this.points - p;
    }

    public int getPoints() {
        return points;
    }

    public long getLifeTime() {
        return lifeTime;
    }

    public int getComSize() {
        return comSize;
    }

}
