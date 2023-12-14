package de.janburzinski.aoc.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2_2023_1 {

    private static final Pattern gamePattern = Pattern.compile("Game (\\d+): (.*)");

    public static void main(String[] args) {
        String filePath = "input_day2.txt";
        List<Day2_2023_1_Game> games = new ArrayList<>();
        int solution = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = gamePattern.matcher(line);
                if (matcher.matches()) {
                    int gameId = Integer.parseInt(matcher.group(1));
                    var gameDatArray = matcher.group(2).split("; ");
                    for (String game : gameDatArray) {
                        Day2_2023_1_Game currentGameObj = new Day2_2023_1_Game(gameId, game);
                        games.add(currentGameObj);
                        //System.out.println("Game " + gameId + ":1 " + gameObj.blue + " blue, " + gameObj.red + " red, " + gameObj.green + " green");
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }

        for (Day2_2023_1_Game game : games) {
            //System.out.println(game.gameId + ":2 " + game.blue + " blue, " + game.red + " red, " + game.green + " green");
            if (game.isPossible(game)) {
                solution += game.gameId;
            }
        }

        System.out.println("Solution: " + solution);
    }
}