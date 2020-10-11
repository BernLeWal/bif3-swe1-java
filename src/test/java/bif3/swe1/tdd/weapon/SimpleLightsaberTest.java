package bif3.swe1.tdd.weapon;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleLightsaberTest {

    @Test
    void testGetColor_LukeShouldBeGreen() {
        // arrange
        Lightsaber lightsaber = new Lightsaber();
        lightsaber.setBelongTo("Luke");

        // act
        LightsaberColor actualColor = lightsaber.getColor();
        LightsaberColor expectedColor = LightsaberColor.GREEN;

        // assert
        assertTrue( expectedColor == actualColor, "Lukes lightsaber color should be GREEN" );
    }

    @Test
    void testGetColor_DarthShouldBeRed() {
        Lightsaber lightsaber = new Lightsaber();
        lightsaber.setBelongTo("Darth");
        assertFalse( lightsaber.getColor() != LightsaberColor.RED);
    }

    @Test
    //@Disabled
    @DisplayName("Unknown fighters should not use the lightsaber, color NONE")
    void testGetColor_WrongFighterShouldBeNone() {
        Lightsaber lightsaber = new Lightsaber();
        lightsaber.setBelongTo("Donald Duck");
        assertEquals( LightsaberColor.NONE, lightsaber.getColor(), "For unknown fighters the color should be NONE");
    }

    @Test
    @DisplayName("Unused lightsabers should not glow, color NONE")
    void testGetColor_UnusedShouldBeNone() {
        Lightsaber lightsaber = new Lightsaber();
        if( lightsaber.getColor() != LightsaberColor.NONE ) {
            fail("For unused lightsabers the color should be NONE");
        }
    }
}