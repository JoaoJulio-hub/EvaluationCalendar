/**
 * Professor class
 * Created by Joao Julio && Rodrigo Freitas
 */
package Person;
import Course.*;

import dataStructures.Iterator;

public class ProfessorClass extends AbstractPerson implements Professor {
    public ProfessorClass(String name) {
        super(name);
    }

    @Override
    public int getNumberOfStudents() {
        int counter = 0;
        Iterator<Course> it = coursesIterator();
        while(it.hasNext()) {
            Course c = it.next();
            counter += c.getNumberStudents();
        }
        return counter;
    }
}
