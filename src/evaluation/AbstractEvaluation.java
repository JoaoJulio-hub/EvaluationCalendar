package evaluation;

import java.time.LocalDate;

import static java.time.LocalDate.of;

public abstract class AbstractEvaluation implements Evaluation{

    private int year, month, day;
    private String course;

    protected AbstractEvaluation(String course, int year, int month, int day){

    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public int getMonth() {
        return month;
    }

    @Override
    public int getDay() {
        return day;
    }

    @Override
    public String getCourse() {
        return course;
    }
}
