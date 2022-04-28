import Person.Person;
import evaluationCalendar.*;
import dataStructures.*;
import Person.*;

import java.awt.*;
import java.util.Scanner;

public class Main {

    /**
     * User commands.
     */
    private static final String PEOPLE = "PEOPLE";
    private static final String EXIT = "EXIT";

    /**
     * Program feedback.
     */
    private static final String EXITING = "Bye!\n";
    private static final String DATA_BASE_EMPTY = "No people registered!\n";
    private static final String HEADER_LIST_ACCOUNTS = "All people:";

    /**
    Main program. Calls the commands interpreter
    @param args - arguments for the execution of the aplication.
     */
    public static void main(String[] args) {
        Main.commands();
    }

    /**
    Command interpreter
     */
    private static void commands() {
        EvaluationCalendar ec = new EvaluationCalendarClass();
        Scanner in = new Scanner(System.in);
        String c = in.next().toUpperCase();
        while (!c.equals(EXIT)) {
            switch (c) {
                case PEOPLE:
                    listPeople(ec);

            }
            c = in.next().toUpperCase();
        }
        System.out.println(EXITING);
        in.close();
    }

    /**
     * Lists everyone
     * @param ec - the evaluation calendar
     */
    private static void listPeople(EvaluationCalendar ec){
        if(ec.isEmpty()){
            System.out.println(DATA_BASE_EMPTY);
        } else {
            Iterator<Person> it =  ec.listAll();
            System.out.println(HEADER_LIST_ACCOUNTS);
            while(it.hasNext()){
                Person person = it.next();
                if(person instanceof Student){

                }
            }
        }
    }
}
