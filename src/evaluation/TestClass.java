package evaluation;

import java.time.*;

public class TestClass extends AbstractEvaluation implements Test {
    int hour, minute, duration;

    public TestClass(int year, int month, int day, String name, int hour, int minute, int duration) {
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
