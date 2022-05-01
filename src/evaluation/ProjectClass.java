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
     * @param courseName
     * @param name
     */
    public ProjectClass(int year, int month, int day, String courseName, String name) {
        super(year, month, day, courseName, name);
    }

    @Override
    public int compareTo(Project other) {
        if (this.getDate().compareTo(other.getDate()) < 0) {
            return 1;
        } else if (this.getDate().compareTo(other.getDate()) > 0) {
            return -1;
        } else {
            return this.getCourseName().compareTo(other.getCourseName());
        }
    }
}
