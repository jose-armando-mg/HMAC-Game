package armando;

import de.vandermeer.asciitable.AsciiTable;
import java.util.*;
import static java.lang.Math.floor;

public class TableGenerator {

    public void displayRulesTable(String[] arguments) {
        List<String> moves = new ArrayList<>(Arrays.asList(arguments));
        int half = (int)floor(moves.size()/2);
        AsciiTable table = new AsciiTable();
        table.addRule();
        List<String> header = new ArrayList<>();
        header.add("");
        header.addAll(moves);
        table.addRow(header.toArray());
        table.addRule();

        for (int i = 0; i < moves.size(); i++) {
            List<String> row = new ArrayList<>();
            row.add(moves.get(i));
            for (int j = 0; j < moves.size(); j++) {
                if (i == j) {
                    row.add("Draw");
                } else if ((j > i && j <= i + half) || (j < i && j + moves.size() <= i + half)) {
                    row.add("Win");
                } else {
                    row.add("Lose");
                }
            }
            table.addRow(row.toArray());
            table.addRule();
        }

        String renderedTable = table.render();
        System.out.println(renderedTable);
    }
}
