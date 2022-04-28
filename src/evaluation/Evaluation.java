/**
 * The interface for the evaluations
 * Created by Joao Julio && Rodrigo Freitas
 */
package evaluation;
import java.time.LocalDate;
public interface Evaluation {

    /**
     * Method to get the date of an evaluation
     * @return the date of the evaluation
     */
    LocalDate getDate();

    /**
     * Method to get the name of an evaluation
     * @return the name given to the evaluation
     */
    String getName();


}
