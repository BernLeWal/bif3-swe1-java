package bif3.swe1.tdd.combat;

import bif3.swe1.tdd.fighter.Fightable;
import bif3.swe1.tdd.fighter.LightsaberFighter;

import java.util.Optional;

public class Combat {
    private LightsaberFighter opponentA;
    private LightsaberFighter opponentB;

    public Combat(LightsaberFighter opponentA, LightsaberFighter opponentB) {
        this.opponentA = opponentA;
        this.opponentB = opponentB;
    }

    public void fightForLifeAndDeath() {
        System.out.printf("%s fights agains %s\n", opponentA.getName(), opponentB.getName());
        System.out.println("Let the fight begin!");
        int turn = 1;
        while( !isFightOver() ) {
            Fightable.Aim aimA = opponentA.nextAim();
            Fightable.Aim aimB = opponentB.nextAim();
            System.out.printf("%d.turn: %s <---> %s  \n", turn++, aimA, aimB);

            gameMechanics(aimA, aimB);
        }
        Optional<LightsaberFighter> optWinner = getWinner();
        if( optWinner.isEmpty() )
            System.out.println("There is no winner");
        else
            System.out.printf("The winner is %s \n", optWinner.get().getName());
    }

    public void limitedFight(int turns) {
        System.out.printf("%s fights agains %s\n", opponentA.getName(), opponentB.getName());
        System.out.println("Let the fight begin!");
        for( int turn = 1; turn<turns && !isFightOver(); turn++ ) {
            Fightable.Aim aimA = opponentA.nextAim();
            Fightable.Aim aimB = opponentB.nextAim();
            System.out.printf("%d.turn: %s <---> %s  \n", turn, aimA, aimB);

            gameMechanics(aimA, aimB);
        }
        Optional<LightsaberFighter> optWinner = getWinner();
        if( optWinner.isEmpty() )
            System.out.println("There is no winner");
        else
            System.out.printf("The winner is %s \n", optWinner.get().getName());
    }

    private void gameMechanics(Fightable.Aim aimA, Fightable.Aim aimB) {
        if( aimA == Fightable.Aim.ATTACK ) {
            if( aimB == Fightable.Aim.ATTACK ) {
                opponentA.changeVitality(-1);
                opponentB.changeVitality(-1);
            }
            else if( aimB == Fightable.Aim.DEFENSE ) {
                opponentA.changeVitality(-2);
            }
            else { // REST
                opponentB.changeVitality(-2);
            }
        } else if( aimA == Fightable.Aim.DEFENSE ) {
            if( aimB == Fightable.Aim.ATTACK ) {
                opponentB.changeVitality(-2);
            }
            else if( aimB == Fightable.Aim.DEFENSE ) {
                opponentA.changeVitality(-1);
                opponentB.changeVitality(-1);
            }
            else { // REST
                opponentB.changeVitality(+1);
            }
        } else if( aimA == Fightable.Aim.REST ) {
            if( aimB == Fightable.Aim.ATTACK ) {
                opponentA.changeVitality(-2);
            }
            else if( aimB == Fightable.Aim.DEFENSE ) {
                opponentA.changeVitality(+1);
            }
            else { // REST
                opponentA.changeVitality(+1);
                opponentB.changeVitality(+1);
            }
        }
    }

    public boolean isFightOver() {
        return opponentA.isDead() || opponentB.isDead();
    }

    public Optional<LightsaberFighter> getWinner() {
        if( opponentA.isDead() && opponentB.isDead() )
            return Optional.empty();    // all are dead - no winner

        if( opponentA.isDead() )
            return Optional.of(opponentB);
        if( opponentB.isDead() )
            return Optional.of(opponentA);

        if( opponentA.getVitality() == opponentB.getVitality() )
            return Optional.empty();    // both equal - still no winner
        return Optional.of( (opponentA.getVitality() > opponentB.getVitality() ) ? opponentA : opponentB);
    }
}
