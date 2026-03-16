import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RedNosedReports {

    private boolean isSafe(int[] reports) {

        int counter = 0;
        for (int i = 0; i < reports.length - 1; i++) {
            if (reports[i] < reports[i + 1]) {
                if (Math.abs(reports[i] - reports[i + 1]) < 4 && Math.abs(reports[i] - reports[i + 1]) > 0) {
                    counter++;
                }
            }
        }
        if (counter == reports.length - 1) {
            return true;
        }

        counter = 0;

        for (int i = 0; i < reports.length - 1; i++) {
            if (reports[i] > reports[i + 1]) {
                if (Math.abs(reports[i] - reports[i + 1]) < 4 && Math.abs(reports[i] - reports[i + 1]) > 0) {
                    counter++;
                }
            }
        }
        if (counter == reports.length - 1) {
            return true;
        }
        return false;
    }

    public RedNosedReports() {


        try (BufferedReader br = new BufferedReader(new FileReader("inputrednosedreports.txt"))) {
            String line;
            int amountOfSafeReports = 0;
            int amountOfSafeReportsDampener = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int[] reportsInt = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    reportsInt[i] = Integer.parseInt(parts[i]);
                }

                if (isSafe(reportsInt)) {
                    amountOfSafeReports++;
                } else {

                    for (int i = 0; i < reportsInt.length; i++) {
                        int [] reducedReportsInt = new int [reportsInt.length-1];
                        int writeIndex = 0;

                        for (int x = 0; x < reportsInt.length; x++) {
                            if (x != i) {
                                reducedReportsInt[writeIndex] = reportsInt[x];
                                writeIndex++;
                            }
                        }

                        if(isSafe(reducedReportsInt)) {
                            amountOfSafeReportsDampener++;
                            break;
                        }
                    }

                }


            }

            IO.println(amountOfSafeReports);
            IO.println(amountOfSafeReportsDampener+amountOfSafeReports);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
