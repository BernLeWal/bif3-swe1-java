package bif3.swe1.tdd.combat;

import bif3.swe1.tdd.fighter.Aim;
import bif3.swe1.tdd.fighter.FighterInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;


/*
  Mocking Part 1

  Herein we show some mocking to check the behaviour
  The class LightsaberFighter is mocked, so that we can track the effects the game mechanics - a combat round -
  to the two opponents.
  The behaviour of Combat.gameMechanics() is recorded and evaluated.
 */
@ExtendWith(MockitoExtension.class)
class MoveCombatTest {
    BaseCombat combat;
    @Mock FighterInterface mockedA;    // a Mock object for opponentA is created
    @Mock FighterInterface mockedB;    // a Mock object for opponentB is created

    @BeforeEach
    void setUp() {
        // arrange

        // Uncomment the following lines when not using the @Mock annotations
        //mockedA = mock(LightsaberFighter.class);
        //mockedB = mock(LightsaberFighter.class);
        combat = new BaseCombat(mockedA, mockedB);

        // Once created, a mock will remember all interactions. Then you can selectively verify whatever interactions you are interested in.
    }

    @Test
    @DisplayName("Attack:Attack -> -1:-1")
    void testGameMechanics_AttackAttack() {
        // act
        combat.move(Aim.ATTACK, Aim.ATTACK);   // the game-mechs for one round is applied

        // assert
                                                    // now check if the vitality of the opponents was
        verify(mockedA).changeVitality(-1);         // modified the right way
        verify(mockedB).changeVitality(-1);
    }

    @Test
    @DisplayName("Attack:Defense -> -2:0")
    void testGameMechanics_AttackDefense() {
        combat.move(Aim.ATTACK, Aim.DEFENSE);
        verify(mockedA).changeVitality(-2);
        verify(mockedB, never()).changeVitality(0); // check, that changeVitality() was not called
    }

    @Test
    @DisplayName("Attack:Rest -> 0:-2")
    void testGameMechanics_AttackRest() {
        combat.move(Aim.ATTACK, Aim.REST);
        verify(mockedA, never()).changeVitality(0);
        verify(mockedB).changeVitality(-2);
    }

    @Test
    @DisplayName("Defense:Attack -> 0:-2")
    void testGameMechanics_DefenseAttack() {
        testGameMechanics(Aim.DEFENSE, Aim.ATTACK, 0, -2);
    }

    @Test
    @DisplayName("Defense:Defense -> -1:-1")
    void testGameMechanics_DefenseDefense() {
        testGameMechanics(Aim.DEFENSE, Aim.DEFENSE, -1, -1);
    }

    @Test
    @DisplayName("Defense:Rest -> 0:+1")
    void testGameMechanics_DefenseRest() {
        testGameMechanics(Aim.DEFENSE, Aim.REST, 0, +1);
    }

    @Test
    @DisplayName("Rest:Attack -> -2:0")
    void testGameMechanics_RestAttack() {
        testGameMechanics(Aim.REST, Aim.ATTACK, -2, 0);
    }

    @Test
    @DisplayName("Rest:Defense -> +1:0")
    void testGameMechanics_RestDefense() {
        testGameMechanics(Aim.REST, Aim.DEFENSE, +1, 0);
    }

    @Test
    @DisplayName("Rest:Rest -> +1:+1")
    void testGameMechanics_RestRest() {
        testGameMechanics(Aim.REST, Aim.REST, +1, +1);
    }

    private void testGameMechanics(Aim aimA, Aim aimB, int deltaA, int deltaB) {
        combat.move(aimA, aimB);
        if (deltaA!=0)
            verify(mockedA).changeVitality(deltaA);
        else
            verify(mockedA, never()).changeVitality(0);

        if (deltaB!=0)
            verify(mockedB).changeVitality(deltaB);
        else
            verify(mockedB, never()).changeVitality(0);
    }
}