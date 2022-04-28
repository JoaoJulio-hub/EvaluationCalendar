/**
 * Class that implements the test interface
 * Created by Joao Julio && Rodrigo Freitas
 */
package evaluation;

import java.time.*;

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
     * @param name
     */
    public TestClass(int year, int month, int day, int hour, int minute, int duration, String name) {
        super(year, month, day, name);
        this.hour = hour;
        this.minute = minute;
        this.duration = duration;
    }

    @Override
    public LocalTime getStartingHour() {
        return LocalTime.of(hour, minute);
    }

    @Override
    public LocalTime getEndingHour() {
        return getStartingHour().plusHours(duration);
    }
}
