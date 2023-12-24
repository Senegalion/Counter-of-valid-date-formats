package laboratory_5;

import java.util.Objects;

public class MyData {

    private final int day;
    private final int month;
    private final int year;
    private final String dayOfTheWeek;

    public MyData(int day, int month, int year, String dayOfTheWeek) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.dayOfTheWeek = dayOfTheWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return day == myData.day && month == myData.month && year == myData.year && Objects.equals(dayOfTheWeek, myData.dayOfTheWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year, dayOfTheWeek);
    }

    @Override
    public String toString() {
        return "MyData{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", dayOfTheWeek='" + dayOfTheWeek + '\'' +
                '}';
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }
}
