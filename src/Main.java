import Course.*;
import Person.*;
import evaluation.*;
import evaluationCalendar.*;
import dataStructures.*;
import Person.*;
import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    /**
     * Date and time formatting
     */
    private static final String WRITE_DATE_FORMAT = "dd-MM-yyyy";
    private static final String WRITE_TIME_FORMAT = "HH'h'mm";
    private static final String WRITE_DEADLINE_MSG = "The deadline for %s is %s.\n";
    private static final String WRITE_TEST_MSG = "%s is scheduled for %s %s-%s.\n";


    /**
     * User commands.
     */
    private static final String PEOPLE = "PEOPLE";
    private static final String PROFESSOR = "PROFESSOR";
    private static final String STUDENT = "STUDENT";
    private static final String COURSES = "COURSES";
    private static final String COURSE = "COURSE";
    private static final String ROSTER = "ROSTER";
    private static final String ASSIGN = "ASSIGN";
    private static final String ENROL = "ENROL";
    private static final String INTERSECTION = "INTERSECTION";
    private static final String COURSEDEADLINES = "COURSEDEADLINES";
    private static final String PERSONALDEADLINES = "PERSONALDEADLINES";
    private static final String DEADLINE = "DEADLINE";
    private static final String COURSETESTS = "COURSETESTS";
    private static final String PERSONALTESTS = "PERSONALTESTS";
    private static final String SCHEDULE = "SCHEDULE";
    private static final String SUPERPROFESSOR = "SUPERPROFESSOR";
    private static final String STRESSOMETER = "STRESSOMETER";
    private static final String HELP = "HELP";
    private static final String EXIT = "EXIT";

    /**
     * Program feedback.
     */
    private static final String EXITING = "Bye!\n";
    private static final String NO_PEOPLE = "No people registered!\n";
    private static final String HEADER_LIST_PEOPLE = "All people:\n";
    private static final String LIST_STUDENT = "[%d] %s (%d)\n";
    private static final String LIST_PROFESSOR = "%s (%d)\n";
    private static final String PROFESSOR_ADDED = "%s added.\n";
    private static final String PERSON_EXISTS = "%s already exists!\n";
    private static final String STUDENT_ADDED = "%s added.\n";
    private static final String STUDENT_NUMBER_TAKEN = "There is already a student with the number %d!\n";
    private static final String NO_COURSES = "No courses registered!\n";
    private static final String HEADER_LIST_COURSES = "All courses:";
    private static final String LIST_COURSE = "%s: %d professors, %d students, %d tests, %d deadlines.\n";
    private static final String COURSE_ADDED = "Course %s added.\n";
    private static final String COURSE_EXISTS = "Course %s already exists!\n";
    private static final String COURSE_DOESNT_EXIST = "Course %s does not exist!\n";
    private static final String HEADER_LIST_ROSTER = "Roster for course %s:\n";
    private static final String HEADER_LIST_PROFESSORS = "Professors:\n";
    private static final String HEADER_LIST_STUDENTS = "Students:\n";
    private static final String LIST_ROSTER_PROFESSORS = "%s \n";
    private static final String LIST_ROSTER_STUDENTS = "%d %s\n";
    private static final String COURSE_EMPTY = "Course %s has no assigned professors and no enrolled students.\n";
    private static final String PROFESSOR_ASSIGNED = "Professor %s assigned to %s.\n";
    private static final String PROFESSOR_DOESNT_EXIST = "Professor %s does not exist!\n";
    private static final String STUDENT_DOESNT_EXIST = "Student %s does not exist!\n";
    private static final String PERSON_DOESNT_EXIST = "%s does not exist!\n";
    private static final String PROFESSOR_IS_ASSIGNED = "Professor %s is already assigned to course %s!\n";
    private static final String STUDENTS_ENROLLED = "%d students added to course %s.\n";
    private static final String STUDENT_IS_ENROLLED = "Student %s is already enrolled in course %s!\n";
    private static final String INADEQUATE_NUMBER_OF_STUDENTS = "Inadequate number of students!\n";
    private static final String HEADER_LIST_INTERSECTION = "Intersection:\n";
    private static final String EMPTY_INTERSECTION = "No professors or students to list!\n";
    private static final String INADEQUATE_NUMBER_OF_COURSES = "Inadequate number of courses!";
    private static final String HEADER_LIST_COURSEDEADLINES = "Deadlines for course %s:\n";
    private static final String AVAILABLE_COURSEDEADLINE = "%s: %d-%d-%d\n";
    private static final String AVAILABLE_PERSONALDEADLINE = "[%s] %s: %d-%d-%d\n";
    private static final String NO_COURSEDEADLINES = "No deadlines defined for %s!\n";
    private static final String HEADER_LIST_PERSONALDEADLINES = "Deadlines for %s:\n";
    private static final String NO_PERSONALDEADLINES = "No deadlines defined for %s!\n";
    private static final String DEADLINE_ADDED = "Deadline %s added to %s.\n";
    private static final String DEADLINE_EXISTS = "Deadline %s already exists!\n";
    private static final String HEADER_LIST_COURSETESTS = "Tests for course %s:\n";
    private static final String AVAILABLE_TESTS = "%d-%d-%d %dh%d-%dh%d: %s\n";
    private static final String NO_COURSETESTS = "No scheduled tests for %s!\n";
    private static final String HEADER_LIST_PERSONALTESTS = "Tests for %s:\n";
    private static final String AVAILABLE_PERSONALTESTS = "%d-%d-%d %dh%d-%dh%d: %s - %s\n";
    private static final String NO_PERSONALTESTS = "No scheduled tests for %s!\n";
    private static final String FREE = "free";
    private static final String MILD = "mild";
    private static final String SEVERE = "severe";
    private static final String TEST_ADDED = "%s %s %s %d-%d-%d %dh%d-%dh%d (%d, %d)\n";
    private static final String TEST_EXISTS = "Course %s already has a test named %s!\n";
    private static final String INVALID_TEST_TIME = "Cannot schedule test %s at that time!\n";
    private static final String LIST_SUPERPROFESSOR = "%s (%d).\n";
    private static final String NO_PROFESSORS = "There are no professors!\n";
    private static final String HEADER_LIST_STRESSOMETER = "Most stressed students:\n";
    private static final String MOST_STRESSED = "%d %s (%d days, %d evaluations)\n";
    private static final String NO_STRESSED_STUDENTS = "There are no stressed students right now!\n";
    private static final String INVALID_NUMBER = "Invalid number of students!\n";

    /**
     * Main program. Calls the commands interpreter
     *
     * @param args - arguments for the execution of the aplication.
     */
    public static void main(String[] args) {
        Main.commands();
    }

    /**
     * Command interpreter
     */
    private static void commands() {
        EvaluationCalendar ec = new EvaluationCalendarClass();
        Scanner in = new Scanner(System.in);
        String c = in.next().toUpperCase();
        while (!c.equals(EXIT)) {
            switch (c) {
                case PEOPLE:
                    listPeople(ec);
                    break;
                case PROFESSOR:
                    addProfessor(in, ec);
                    break;
                case STUDENT:
                    addStudent(in, ec);
                    break;
                case COURSES:
                    listCourses(ec);
                    break;
                case COURSE:
                    addCourse(in, ec);
                    break;
                case ROSTER:
                    roster(in, ec);
                    break;
                case ASSIGN:
                    assign(in, ec);
                    break;
                case ENROL:
                    enrol(in, ec);
                    break;
                case INTERSECTION:
                    intersection(in, ec);
                    break;
                case COURSEDEADLINES:
                    courseDeadlines(in, ec);
                    break;
                case PERSONALDEADLINES:
                    personalDeadlines(in, ec);
                    break;
                case DEADLINE:
                    deadline(in, ec);
                    break;
                case COURSETESTS:
                    courseTests(in, ec);
                    break;
                case PERSONALTESTS:
                    personalTests(in, ec);
                    break;
                case SCHEDULE:
                    schedule(in, ec);
                    break;
                case SUPERPROFESSOR:
                    superProfessor(in, ec);
                    break;
                case STRESSOMETER:
                    stressometer(in, ec);
                    break;
                case HELP:


            }
            c = in.next().toUpperCase();
        }
        System.out.println(EXITING);
        in.close();
    }

    /**
     * Lists everyone
     *
     * @param ec - the evaluation calendar
     */
    private static void listPeople(EvaluationCalendar ec) {
        if (ec.peopleIsEmpty()) {
            System.out.printf(NO_PEOPLE);
        } else {
            Iterator<Person> it = ec.listAll();
            System.out.printf(HEADER_LIST_PEOPLE);
            while (it.hasNext()) {
                Person p = it.next();
                if (p instanceof Student) {
                    System.out.printf(LIST_STUDENT, ((Student) p).getId(), p.getName(), p.numberOfCourses());
                } else {
                    System.out.printf(LIST_PROFESSOR, p.getName(), p.numberOfCourses());
                }
            }
        }
    }

    private static void addProfessor(Scanner in, EvaluationCalendar ec) {
        String name = in.nextLine().trim();
        if (ec.personExists(name))
            System.out.printf(PERSON_EXISTS, name);
        else {
            ec.addProfessor(name);
            System.out.printf(PROFESSOR_ADDED, name);
        }
    }

    private static void addStudent(Scanner in, EvaluationCalendar ec) {
        int id = in.nextInt();
        String name = in.nextLine().trim();
        if (ec.personExists(name)) {
            System.out.printf(PERSON_EXISTS, name);
        } else if (ec.studentIdExists(id)) {
            System.out.printf(STUDENT_NUMBER_TAKEN, id);
        } else {
            ec.addStudent(id, name);
            System.out.printf(STUDENT_ADDED, name);
        }
    }

    private static void listCourses(EvaluationCalendar ec) {
        if (ec.coursesIsEmpty())
            System.out.printf(NO_COURSES);
        else {
            Iterator<Course> it = ec.listCourses();
            System.out.println(HEADER_LIST_COURSES);
            while (it.hasNext()) {
                Course c = it.next();
                System.out.printf(LIST_COURSE, c.getName(), c.getNumberProfessors(),
                        c.getNumberStudents(), c.getNumberTests(), c.getNumberProjects());
            }
        }
    }

    private static void addCourse(Scanner in, EvaluationCalendar ec) {
        String course = in.nextLine().trim();
        if (ec.courseExists(course)) {
            System.out.printf(COURSE_EXISTS, course);
        } else {
            ec.addCourse(course);
            System.out.printf(COURSE_ADDED, course);
        }
    }

    private static void roster(Scanner in, EvaluationCalendar ec) {
        String course = in.nextLine().trim();
        if (!ec.courseExists(course)) {
            System.out.printf(COURSE_DOESNT_EXIST, course);
        } else if (ec.coursesIsEmpty()) {
            System.out.printf(COURSE_EMPTY, course);
        } else {
            Iterator<Person> it = ec.listAll();
            System.out.printf(HEADER_LIST_ROSTER);
            System.out.printf(HEADER_LIST_PROFESSORS);
            while (it.hasNext()) {
                Person p = it.next();
                if (p instanceof Professor) {
                    System.out.printf(LIST_ROSTER_PROFESSORS, p.getName());
                }
            }
            it.rewind();
            System.out.printf(HEADER_LIST_STUDENTS);
            while (it.hasNext()) {
                Person p = it.next();
                if (p instanceof Student) {
                    System.out.printf(LIST_ROSTER_STUDENTS, ((Student) p).getId(), p.getName());
                }
            }
        }
    }

    /**
     * assigns a professor to a course
     *
     * @param in
     * @param ec
     */
    private static void assign(Scanner in, EvaluationCalendar ec) {
        String name = in.nextLine().trim();
        String course = in.nextLine().trim();
        if (!ec.professorExists(name)) {
            System.out.printf(PROFESSOR_DOESNT_EXIST, name);
        } else if (!ec.courseExists(course)) {
            System.out.printf(COURSE_DOESNT_EXIST, course);
        } else if (ec.professorIsAssigned(name, course)) {
            System.out.printf(PROFESSOR_IS_ASSIGNED, name, course);
        } else {
            ec.assignProfessor(name, course);
            System.out.printf(PROFESSOR_ASSIGNED, name, course);
        }
    }

    /**
     * adds a given amount of students to a course
     *
     * @param in
     * @param ec
     */
    private static void enrol(Scanner in, EvaluationCalendar ec) {
        int nStudents = in.nextInt();
        String course = in.nextLine().trim();
        int success = 0;
        if (nStudents < 1) {
            System.out.printf(INADEQUATE_NUMBER_OF_STUDENTS);
        } else if (!ec.courseExists(course)) {
            System.out.printf(COURSE_DOESNT_EXIST, course);
        } else {
            for (int i = 0; i < nStudents; i++) {
                String name = in.nextLine().trim();
                if (!ec.studentExists(name)) {
                    System.out.printf(STUDENT_DOESNT_EXIST, name);
                } else if (ec.studentIsEnrolledToCourse(name, course)) {
                    System.out.printf(STUDENT_IS_ENROLLED, name, course);
                } else {
                    ec.enrolToCourse(name, course);
                    success++;
                }
            }
            System.out.printf(STUDENTS_ENROLLED, success, course);
        }

    }

    private static void intersection(Scanner in, EvaluationCalendar ec) {
        int numberOfCourses = in.nextInt();
        int condition = -1;
        if (numberOfCourses < 2) {
            System.out.printf(INADEQUATE_NUMBER_OF_COURSES);
        } else {
            Array<Person> personArray = new ArrayClass<Person>();
            for (int i = 0; i < numberOfCourses; i++) {
                String course = in.nextLine().trim();
                if (!ec.courseExists(course)) {
                    System.out.printf(COURSE_DOESNT_EXIST, course);
                    condition = 0;
                    break;
                } else {
                    Course c = ec.getCourseByName(course);
                    for (int j = 0; j < c.getSize(); j++) {
                        Person p = c.getByPos(j);
                        personArray.insertLast(p);
                    }
                    if (i >= 1) {
                        personArray = ec.multiIntersectCourses(personArray);
                    }
                    if (personArray.size() == 0) {
                        System.out.printf(EMPTY_INTERSECTION);
                        condition = 1;
                        break;
                    }
                }
            }
            if (condition < 0) {
                Iterator<Person> it = personArray.iterator();
                System.out.printf(HEADER_LIST_INTERSECTION);
                System.out.printf(HEADER_LIST_PROFESSORS);
                while (it.hasNext()) {
                    Person person = it.next();
                    if (person instanceof Professor) {
                        System.out.printf(LIST_ROSTER_PROFESSORS, person.getName());
                    }
                }
                it.rewind();
                System.out.printf(HEADER_LIST_STUDENTS);
                while (it.hasNext()) {
                    Person person = it.next();
                    if (person instanceof Student) {
                        System.out.printf(LIST_ROSTER_STUDENTS, ((Student) person).getId(), person.getName());
                    }
                }
            }
        }
    }

    private static void courseDeadlines(Scanner in, EvaluationCalendar ec) {
        String course = in.nextLine().trim();
        if (!ec.courseExists(course)) {
            System.out.printf(COURSE_DOESNT_EXIST, course);
        } else if (ec.getCourseByName(course).getNumberProjects() == 0) {
            System.out.printf(NO_COURSEDEADLINES, course);
        } else {
            Iterator<Project> it = ec.courseDeadlines(course);
            System.out.printf(HEADER_LIST_COURSEDEADLINES, course);
            while (it.hasNext()) {
                Project p = it.next();
                System.out.printf(AVAILABLE_COURSEDEADLINE, p.getName(), p.getYear(),
                        p.getMonth(), p.getDay());
            }
        }
    }


    private static void personalDeadlines(Scanner in, EvaluationCalendar ec) {
        String name = in.nextLine().trim();
        if (!ec.personExists(name)) {
            System.out.printf(PERSON_DOESNT_EXIST, name);
        } else if (ec.getPerson(name).deadlineIsEmpty()) {
            System.out.printf(NO_PERSONALDEADLINES, name);
        } else {
            Iterator<Project> it = ec.personalDeadlines(name);
            System.out.printf(HEADER_LIST_PERSONALDEADLINES, name);
            while (it.hasNext()) {
                Project p = it.next();
                System.out.printf(AVAILABLE_PERSONALDEADLINE, p.getCourseName(), p.getName(),
                        p.getYear(), p.getMonth(), p.getDay());
            }
        }
    }

    private static void deadline(Scanner in, EvaluationCalendar ec) {
        String course = in.nextLine().trim();
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        String name = in.nextLine().trim();
        if (!ec.courseExists(course)) {
            System.out.printf(COURSE_DOESNT_EXIST, course);
        } else if (ec.deadlineExists(name)) {
            System.out.printf(DEADLINE_EXISTS, name);
        } else {
            ec.newDeadline(course, year, month, day, name);
            System.out.printf(DEADLINE_ADDED, name, course);
        }
    }

    //falta acabar (time)
    private static void courseTests(Scanner in, EvaluationCalendar ec) {
        String course = in.nextLine().trim();
        if (!ec.courseExists(course)) {
            System.out.printf(COURSE_DOESNT_EXIST, course);
        } else if (ec.getCourseByName(course).getNumberTests() == 0) {
            System.out.printf(NO_COURSETESTS, course);
        } else {
            Iterator<Test> it = ec.courseTests(course);
            System.out.printf(HEADER_LIST_COURSETESTS, course);
            while (it.hasNext()) {
                Test t = it.next();
                System.out.printf(AVAILABLE_TESTS, t.getYear(), t.getMonth(),
                        t.getDay(), t.);
            }
        }
    }

    //falta acabar (time)
    private static void personalTests(Scanner in, EvaluationCalendar ec) {
        String name = in.nextLine().trim();
        Student student = (Student) ec.getPerson(name);
        if (!ec.personExists(name)) {
            System.out.printf(STUDENT_DOESNT_EXIST, name);
        } else if ((student.testsIsEmpty())) {
            System.out.printf(NO_PERSONALTESTS, name);
        } else {
            Iterator<Test> it = ec.personalTests(name);
            System.out.printf(HEADER_LIST_PERSONALTESTS, name);
            while (it.hasNext()) {
                Test t = it.next();
                System.out.printf(AVAILABLE_PERSONALTESTS, p.getYear(), p.getMonth(), p.getDay()
                );
            }
        }
    }

    private static void schedule(Scanner in, EvaluationCalendar ec) {
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        int hour = in.nextInt();
        int minute = in.nextInt();
        int duration = in.nextInt();
        String course = in.nextLine().trim();
        String name = in.nextLine().trim();
        if (!ec.courseExists(course)) {
            System.out.printf(COURSE_DOESNT_EXIST, course);
        } else if(ec.getCourseByName(course).hasTest(name)){
            System.out.printf(TEST_EXISTS, course, name);
        } else if(ec.getCourseByName(course).)
    }

    private static void superProfessor(Scanner in, EvaluationCalendar ec) {
        if(ec.noProfessors()){
            System.out.printf(NO_PROFESSORS);
        } else {
            System.out.printf(LIST_SUPERPROFESSOR, ec.superProfessor(), ec.superProfessor().getNumberOfStudents());
        }
    }

    private static void stressometer(Scanner in, EvaluationCalendar ec) {
        int numberOfStudents = in.nextInt();
        if (numberOfStudents < 1) {
            System.out.printf(INVALID_NUMBER);
        } else if (ec.numberOfStudentsWithEvaluation() == 0) {
            System.out.printf(NO_STRESSED_STUDENTS);
        } else {
            Iterator<Student> it = ec.mostStressedStudents();
            System.out.printf(HEADER_LIST_STRESSOMETER);
            while (it.hasNext()) {
                Student s = it.next();
                System.out.printf(MOST_STRESSED, s.getId(), s.getName(), s.getStraightDays(), s.getNumberOfEvaluations());
            }
        }
    }
}
