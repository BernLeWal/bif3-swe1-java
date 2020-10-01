package bif3.swe1.tdd.fighter;

public interface Fightable {
    enum Aim {
        ATTACK,
        DEFENSE,
        REST
    }

    Aim nextAim();

    int getVitality();
    void changeVitality(int change);
    boolean isDead();
}
