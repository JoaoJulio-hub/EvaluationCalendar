/**
 * The interface for the test objects
 * Created by Joao Julio && Rodrigo Freitas
 */
package evaluation;
import java.time.LocalTime;

public interface Test extends Evaluation {

    /**
     * Gets the starting hour of a test
     * @return the time object that represents the start of the test
     */
    LocalTime getStartingHour();

    /**
     * Gets the ending hour of a test
     * @return the time object that represents the end of the test
     */
    LocalTime getEndingHour();
}
