/**
 * Abstract Class for any evaluation
 * Created by Joao Julio && Rodrigo Freitas
 */
package evaluation;
import java.time.*;

public abstract class AbstractEvaluation implements Evaluation{

    /**
     * Constants
     */
    private final int year, month, day;
    private final String courseName, name;

    /**
     * Constructor of the class
     * @param year
     * @param month
     * @param day
     * @param name
     * @param courseName
     */
    protected AbstractEvaluation(String courseName, int year, int month, int day, String name) {
        this.courseName = courseName;
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;
    }

    /**
     * Method to get the year of an evaluation
     *
     * @return the year of the evaluation
     */
    @Override
    public int getYear() {
        return year;
    }

    /**
     * Method to get the month of an evaluation
     *
     * @return the month of the evaluation
     */
    @Override
    public int getMonth() {
        return month;
    }

    /**
     * Method to get the day of an evaluation
     *
     * @return the day of the evaluation
     */
    @Override
    public int getDay() {
        return day;
    }

    @Override
    public LocalDate getDate() {
        return LocalDate.of(year, month, day);
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Method to get the name of the course associated with the evaluation
     *
     * @return the name of the course
     */
    @Override
    public String getCourseName() {
        return courseName;
    }

    @Override
    public int compareTo(Evaluation other) {
        return this.getDate().compareTo(other.getDate());
    }
}

