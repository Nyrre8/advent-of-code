import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MullItOver {
    public MullItOver() {

        try (BufferedReader br = new BufferedReader(new FileReader("inputmullitover.txt"))) {






        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;


    }
}
