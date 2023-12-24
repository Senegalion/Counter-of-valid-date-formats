package laboratory_5;

import java.io.IOException;

public class LineCounter {
    public static void main(String[] args) {
        Files inputFile = Files.INPUTFILE;
        Files outputFile = Files.OUTPUTFILE;
        try {
            int numberOfRewrittenDates = countRewrittenDates(inputFile.getFileAddress(), outputFile.getFileAddress());
            System.out.println("Number of rewritten dates: " + numberOfRewrittenDates);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println("Something went wrong with your program");
        }
    }

    private static int countRewrittenDates(String inputFile, String outputFile) throws IOException {
        ConverterOfTheDate converterOfTheDate = new ConverterOfTheDate();
        return converterOfTheDate.convertDate(inputFile, outputFile);
    }

}
