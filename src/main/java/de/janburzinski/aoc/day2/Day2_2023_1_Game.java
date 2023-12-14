package de.janburzinski.aoc.day2;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2_2023_1_Game {
    public int gameId;

    public int blue;
    public int red;
    public int green;

    public final Pattern bluePattern = Pattern.compile("(\\d+) blue");
    public final Pattern redPattern = Pattern.compile("(\\d+) red");
    public final Pattern greenPattern = Pattern.compile("(\\d+) green");

    public Day2_2023_1_Game(int gameId, String input) {
        this.gameId = gameId;

        String[] parts = input.split(", ");
        for (String s : parts) {
            Matcher matcher = bluePattern.matcher(s);
            if (matcher.matches()) {
                blue = Integer.parseInt(matcher.group(1));
            }
            matcher = redPattern.matcher(s);
            if (matcher.matches()) {
                red = Integer.parseInt(matcher.group(1));
            }
            matcher = greenPattern.matcher(s);
            if (matcher.matches()) {
                green = Integer.parseInt(matcher.group(1));
            }
        }
    }

    public boolean isPossible(Day2_2023_1_Game g) {
        System.out.println("Game " + g.gameId + ":2 " + g.blue + " blue, " + g.red + " red, " + g.green + " green");
        return g.red < 12 || g.green < 13 || g.blue < 14;
    }
}
