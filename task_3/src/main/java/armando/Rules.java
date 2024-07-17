package armando;

import static java.lang.Math.floor;
import java.util.ArrayList;
import java.util.Arrays;

public class Rules{
	public int victoryCheck(String[] options, String computerMove, String userMove){
		ArrayList<String> moves = new ArrayList<>(Arrays.asList(options));
		int half = (int)floor(moves.size()/2);
		int a = moves.indexOf(computerMove);	 
		int b = moves.indexOf(userMove);
		int distance = (b - a + moves.size()) % moves.size();

        // Determine the result based on the circular distance
        int result;
        if (distance == 0) {
            result = 0;  // It's a tie
        } else if (distance <= half) {
            result = 1;  // User wins
        } else {
            result = -1; // Computer wins
        }

        return result;
    }
}	
