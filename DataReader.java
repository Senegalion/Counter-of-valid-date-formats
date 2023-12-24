package laboratory_5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private final BufferedReader bufferedReader;

    public DataReader(String fileAddress) throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(fileAddress));
    }

    public List<String> readLines() throws IOException {
        List<String> lines = new ArrayList<>();
        String inputFileLine;
        while ((inputFileLine = bufferedReader.readLine()) != null) {
            lines.add(inputFileLine);
        }
        return lines;
    }

    public void close() throws IOException {
        bufferedReader.close();
    }
}
