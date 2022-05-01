/**
 * The interface for the evaluations
 * Created by Joao Julio && Rodrigo Freitas
 */
package evaluation;
import java.time.LocalDate;
public interface Evaluation extends Comparable<Evaluation> {

    /**
     * Method to get the date of an evaluation
     * @return the date of the evaluation
     */
    LocalDate getDate();

    /**
     * Method to get the year of an evaluation
     * @return the year of the evaluation
     */
    int getYear();

    /**
     * Method to get the month of an evaluation
     * @return the month of the evaluation
     */
    int getMonth();

    /**
     * Method to get the day of an evaluation
     * @return the day of the evaluation
     */
    int getDay();

    /**
     * Method to get the name of an evaluation
     * @return the name given of the evaluation
     */
    String getName();

    /**
     * Method to get the name of the course associated with the evaluation
     * @return the name of the course
     */
    String getCourseName();

}
