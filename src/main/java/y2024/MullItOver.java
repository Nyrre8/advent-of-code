import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MullItOver {
    public MullItOver() {

        try (BufferedReader br = new BufferedReader(new FileReader("y2024/inputmullitover.txt"))) {






        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;


    }
}
