package laboratory_5;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConverterOfTheDate implements Convertible {

    public int convertDate(String inputFile, String outputFile) throws IOException {
        int numberOfRewrittenDates = 0;
        List<MyData> myDataList = new ArrayList<>();
        DataReader dataReader = new DataReader(inputFile);
        DataWriter dataWriter = new DataWriter(outputFile);
        try {
            List<String> inputFileLines = dataReader.readLines();
            for (String inputFileLine : inputFileLines) {
                MyData myData = extractDate(inputFileLine);
                if (myData != null && !myDataList.contains(myData)) {
                    myDataList.add(myData);
                }
            }
            for (MyData myData : myDataList) {
                dataWriter.writeLines(formatDate(myData));
                numberOfRewrittenDates++;
            }
        } finally {
            dataReader.close();
            dataWriter.close();
        }
        return numberOfRewrittenDates;
    }

    @Override
    public MyData extractDate(String inputFileLine) {
        String datePattern = findDatePattern(inputFileLine);
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern, Locale.ENGLISH);
            Calendar calendar = Calendar.getInstance();
                Date date = simpleDateFormat.parse(inputFileLine);
                Pattern weekdayPattern = Pattern.compile("[A-Za-z]+");
                Matcher weekdayMatcher = weekdayPattern.matcher(inputFileLine);
                if (weekdayMatcher.find()) {
                    String dayOfTheWeek = weekdayMatcher.group().trim();
                    calendar.setTime(date);
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    int month = calendar.get(Calendar.MONTH) + 1;
                    int year = calendar.get(Calendar.YEAR);
                    return new MyData(day, month, year, dayOfTheWeek);
                }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    private String findDatePattern(String inputFileLine) {
        Pattern pattern = Pattern.compile
                ("(\\d{4}-\\d{2}-\\d{2}|\\d{2}/\\d{2}/\\d{4}|\\d{2}/\\d/\\d{4}|[A-Za-z]+ \\d{2}\\.\\d{2}\\.\\d{4})");
        Matcher matcher = pattern.matcher(inputFileLine);

        if (matcher.find()) {
            String datePart = matcher.group();
            if (datePart.matches("\\d{4}-\\d{2}-\\d{2}")) {
                return "yyyy-MM-dd EEEE";
            } else if (datePart.matches("\\d{2}/\\d{2}/\\d{4}")) {
                return "dd/MM/yyyy EEEE";
            } else if (datePart.matches("\\d{2}/\\d/\\d{4}")) {
                return "dd/M/yyyy EEEE";
            } else if (datePart.matches("[A-Za-z]+ \\d{2}\\.\\d{2}\\.\\d{4}")) {
                return "EEEE dd.MM.yyyy";
            }
        }

        return null;
    }

    @Override
    public String formatDate(MyData myData) {
        return "day = " + myData.getDay() +
                ", month = " + myData.getMonth() +
                ", year = " + myData.getYear() +
                ", weekday = " + myData.getDayOfTheWeek();
    }
}
