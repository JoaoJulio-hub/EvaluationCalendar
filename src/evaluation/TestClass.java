package evaluation;
import java.time.*;

// Created by Joao Julio (61610) && Rodrigo Freitas (62942)

public class TestClass extends AbstractEvaluation implements Test {
    /**
     * Constants
     */
    final int hour, minute, duration;

    /**
     * Constructor of the class
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param duration
     * @param courseName
     * @param name
     */
    public TestClass(int year, int month, int day, int hour,
                     int minute, int duration, String courseName, String name) {
        super(year, month, day, courseName, name);
        this.hour = hour;
        this.minute = minute;
        this.duration = duration;
    }

    @Override
    public int getHour() {
        return hour;
    }

    @Override
    public int getMinute() {
        return minute;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public LocalTime getStartingHour() {
        return LocalTime.of(hour, minute);
    }

    @Override
    public int compareTo(Test other) {
        if (this.getDate().compareTo(other.getDate()) < 0) {
            return 1;
        } else if (this.getDate().compareTo(other.getDate()) > 0) {
            return -1;
        } else if (this.getDate().compareTo(other.getDate()) == 0 &&
                this.getStartingHour().compareTo(other.getStartingHour()) < 0) {
            return 1;
        } else if (this.getDate().compareTo(other.getDate()) == 0 &&
                this.getStartingHour().compareTo(other.getStartingHour()) > 0) {
            return -1;
        } else {
            return this.getCourseName().compareTo(other.getCourseName());
        }
    }
}
