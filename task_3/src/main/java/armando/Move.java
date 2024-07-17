package armando;

import java.util.Random;

public class Move {
    public String generateMove(String[] moves){
        int n = moves.length;
        Random randomGenerator = new Random();
        int random = randomGenerator.nextInt(n);
        return moves[random];
    }
}
