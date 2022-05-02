package evaluation;
import java.time.LocalTime;

// Created by Joao Julio (61610) && Rodrigo Freitas (62942)

/**
 * Interface that implements all methods for <code>Test<code/> objects, specifically
 */
public interface Test extends Evaluation, Comparable<Test> {

    int getHour();

    int getMinute();

    int getDuration();

    /**
     * Gets the starting hour of a test
     * @return the time object that represents the start of the test
     */
    LocalTime getStartingHour();
}
