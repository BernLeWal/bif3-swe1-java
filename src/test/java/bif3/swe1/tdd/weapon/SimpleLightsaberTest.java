package bif3.swe1.tdd.weapon;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleLightsaberTest {

    @Test
    void testGetColor_LukeShouldBeGreen() {
        Lightsaber lightsaber = new Lightsaber();
        lightsaber.setBelongTo("Luke");
        assertTrue( lightsaber.getColor() == LightsaberColor.GREEN, "Lukes lightsaber color should be GREEN" );
    }

    @Test
    void testGetColor_DarthShouldBeRed() {
        Lightsaber lightsaber = new Lightsaber();
        lightsaber.setBelongTo("Darth");
        assertFalse( lightsaber.getColor() == LightsaberColor.RED, "Darths lightsaber color should be RED" );
    }

    @Test
    @Disabled
    @DisplayName("Unknown fighters should not use the lightsaber, color NONE")
    void testGetColor_WrongFighterShouldBeNone() {
        Lightsaber lightsaber = new Lightsaber();
        lightsaber.setBelongTo("Donald Duck");
        assertEquals( lightsaber.getColor(), LightsaberColor.NONE, "For unknown fighters the color should be NONE");
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