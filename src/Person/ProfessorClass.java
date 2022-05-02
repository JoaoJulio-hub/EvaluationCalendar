package Person;
import Course.*;
import dataStructures.Iterator;

// Created by Joao Julio (61610) && Rodrigo Freitas (62942)

/**
 * Creates a Professor with a given name
 */
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
