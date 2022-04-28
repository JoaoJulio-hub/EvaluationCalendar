package Person;

public abstract class AbstractPerson implements Person{

    @Override
    public boolean isStudent() {
        return this instanceof Student;
    }
}
