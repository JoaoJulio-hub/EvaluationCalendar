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
    private final String name;

    /**
     * Constructor of the class
     * @param year
     * @param month
     * @param day
     * @param name
     */
    protected AbstractEvaluation(int year, int month, int day, String name) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;
    }

    @Override
    public LocalDate getDate() {
        return LocalDate.of(year, month, day);
    }

    @Override
    public String getName() {
        return name;
    }

}
