package bif3.swe1.tdd.weapon;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class FixtureLightsaberTest {
    Lightsaber lightsaberOfLuke;
    Lightsaber lightsaberOfDarth;
    Lightsaber unusedLightsaber;

    @BeforeEach
    void setUp() {
        lightsaberOfLuke = new Lightsaber();
        lightsaberOfLuke.setBelongTo("Luke");

        lightsaberOfDarth = new Lightsaber();
        lightsaberOfDarth.setBelongTo("Darth");

        unusedLightsaber = new Lightsaber();
    }


    @Test
    @DisplayName("Lightsaber fighters should get their corresponding color")
    void testGetColor_ShouldHaveRightColor() {
        assertSame(lightsaberOfLuke.getColor(), Lightsaber.Color.GREEN, "Lukes lightsaber color should be GREEN");
        assertSame(lightsaberOfDarth.getColor(), Lightsaber.Color.RED, "Darths lightsaber color should be RED");
        assertEquals( unusedLightsaber.getColor(), Lightsaber.Color.NONE, "For unused lightsabers the color should be NONE");
    }

    @Test
    @Disabled("Will be working in the next release...")
    @DisplayName("Lightsaber fighters should get their corresponding color - always check all")
    void testGetColor_ShouldHaveRightColor_testAll() {
        assertAll( "colors",
                ()-> assertSame(lightsaberOfLuke.getColor(), Lightsaber.Color.GREEN, "Lukes lightsaber color should be GREEN"),
                ()-> assertSame(lightsaberOfDarth.getColor(), Lightsaber.Color.RED, "Darths lightsaber color should be RED"),
                ()->assertEquals( unusedLightsaber.getColor(), Lightsaber.Color.NONE, "For unused lightsabers the color should be NONE")
        );
    }

    @AfterEach
    void tearDown() {
        // clean-up work
        lightsaberOfLuke.setBelongTo("");
        lightsaberOfDarth.setBelongTo("");
    }
}