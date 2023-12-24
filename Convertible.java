package laboratory_5;

import java.io.IOException;

public interface Convertible {
    int convertDate(String inputFile, String outputFile) throws IOException;

    String formatDate(MyData myData);

    MyData extractDate(String inputFileLine);
}
