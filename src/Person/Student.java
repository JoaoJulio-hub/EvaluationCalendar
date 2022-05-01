/**
 * Students interface
 * Created by Joao Julio && Rodrigo Freitas
 */
package Person;

public interface Student extends Person, Comparable<Student> {

    /**
     * Gets the student id
     * @return the student id
     */
    int getId();

    /**
     * Get number of straight days with evaluations
     * @return number of days
     */
    int getStraightDays();

    /**
     * Get number of evaluations during those straight days
     * @return number of evaluations
     */
    int getNumberOfEvaluations();
}
