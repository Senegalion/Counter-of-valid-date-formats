package laboratory_5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {
    private final BufferedWriter bufferedWriter;

    public DataWriter(String fileAddress) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(fileAddress, true));
    }

    public void writeLines(String line) throws IOException {
        bufferedWriter.write(line);
        bufferedWriter.newLine();
    }

    public void close() throws IOException {
        bufferedWriter.close();
    }
}
