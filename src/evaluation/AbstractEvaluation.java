package evaluation;
import Course.Course;

import java.time.*;
import java.util.Objects;

// Created by Joao Julio (61610) && Rodrigo Freitas (62942)
public abstract class AbstractEvaluation implements Evaluation {

    /**
     * Instance Variables
     */
    private final int year, month, day;
    private final String courseName, name;

    /**
     * Constructor of the class
     *
     * @param year
     * @param month
     * @param day
     * @param name
     */
    protected AbstractEvaluation(int year, int month, int day, String courseName, String name) {
        this.courseName = courseName;
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Evaluation))
            return false;
        Evaluation other = (Evaluation) obj;
        return Objects.equals(name, other.getName());
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
    public LocalDate getDate() {
        return LocalDate.of(year, month, day);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCourseName() {
        return courseName;
    }
}

