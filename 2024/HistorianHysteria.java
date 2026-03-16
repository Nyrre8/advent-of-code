import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class HistorianHysteria {


    public HistorianHysteria() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String line;

        ArrayList<Integer> leftColumn = new ArrayList<Integer>();
        ArrayList<Integer> rightColumn = new ArrayList<Integer>();
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("   ");
            leftColumn.add(Integer.parseInt(parts[0]));
            rightColumn.add(Integer.parseInt(parts[1]));


        }

        Collections.sort(leftColumn);
        Collections.sort(rightColumn);

        int totalDistance = 0;
        int simScore = 0;
        int leftColumnComparisonNr = 0;
        int counterOfEquals = 0;


        for (int i = 0; i < leftColumn.size(); i++) {
            int addToTotalDistance = Math.abs(leftColumn.get(i) - rightColumn.get(i));
            totalDistance += addToTotalDistance;

        }

        for (int i = 0; i < leftColumn.size(); i++) {

            leftColumnComparisonNr = leftColumn.get(i);
            for (int x = 0; x < leftColumn.size(); x++) {
                if (leftColumnComparisonNr == rightColumn.get(x)) {
                    counterOfEquals++;

                }

            }
            simScore += (leftColumnComparisonNr * counterOfEquals);
            counterOfEquals = 0;
        }


        IO.println(totalDistance);
        IO.println(simScore);


    }
}

