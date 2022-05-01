/**
 * Student class
 * Created by Joao Julio && Rodrigo Freitas
 */
package Person;

public class StudentClass extends AbstractPerson implements Student  {

    /**
     * student id
     */
    int id;

    /**
     * Constuctor
     * @param id
     * @param name
     */
    protected StudentClass(int id, String name) {
        super(name);
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

}

