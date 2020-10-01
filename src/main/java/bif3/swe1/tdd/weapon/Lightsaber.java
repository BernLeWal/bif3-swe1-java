package bif3.swe1.tdd.weapon;


import lombok.Getter;
import lombok.ToString;

@ToString
public class Lightsaber {
    public enum Color {
        NONE,   // when the lightsaber is not used
        GREEN,  // Jedi Knight Luke Skywalker
        RED,    // Sith Lord Darth Vader
        BLUE    // Jedi Master Yoda
    }

    @Getter
    private Color color;

    public Lightsaber() {
        color = Color.NONE;
    }

    public void setBelongTo(String fighter) {
        color = switch( fighter ) {
            case "Luke" -> Color.GREEN;
            case "Darth" -> Color.RED;
            case "Yoda" -> Color.BLUE;
            default -> Color.NONE;
        };
    }
}
