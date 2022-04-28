/**
 * Class that implements the project interface
 * Created by Joao Julio && Rodrigo Freitas
 */
package evaluation;
import java.time.LocalDate;

public class ProjectClass extends AbstractEvaluation implements Project {

    /**
     * Constructor of the class
     * @param year
     * @param month
     * @param day
     * @param name
     */
    public ProjectClass(int year, int month, int day, String name) {
        super(year, month, day, name);
    }
}
