package Person;

import dataStructures.*;
import evaluation.Evaluation;

import java.time.*;

// Created by Joao Julio (61610) && Rodrigo Freitas (62942)

/**
 * Creates an object Stress, it is used to calculate two values that measure the stress of a Student:
 * number of days straight with evaluations
 * total number of evaluations during the days
 */
public class Stress {
    /**
     * <code>straightDays</code> - number of days straight with evaluations
     * <code>numberEvaluations</code> - total number of evaluations during the days
     */
    int straightDays, numberEvaluations;

    /**
     * Array of different types of <code>evaluations</code>
     */
    Array<Evaluation> evaluations;

    /**
     * Constructor
     * Receives an array with all evaluations of a Student, sorts it
     * , and calculates <code>numberEvaluations</code> and <code>straightDays</code>
     *
     * @param evaluations
     */
    public Stress(Array<Evaluation> evaluations) {
        this.straightDays = 0;
        this.numberEvaluations = 0;
        this.evaluations = evaluations;
        evaluations.sort();
        setStraightDays();
    }

    /**
     * Get the number of days straight with evaluation
     * @return number of days straight with evaluation
     */
    public int getNumberEvaluations() {
        return numberEvaluations;
    }

    /**
     * Get the total number of evaluations during those days
     * @return total number of evaluations during those days
     */
    public int getStraightDays() {
        return straightDays;
    }

    /**
     * Calculates the number of days straight with evaluations and total number of evaluations during those days
     */
    private void setStraightDays() {
        int currentDays = 0;
        int currentEval = 0;
        for (int i = 0; i < evaluations.size(); i++) {
            if (i == 0) {
                currentDays++;
                currentEval++;
            } else if (evaluations.get(i - 1).getDate().isEqual(evaluations.get(i).getDate())) {
                currentEval++;
            } else if (evaluations.get(i - 1).getYear() == evaluations.get(i).getYear() &&
                    evaluations.get(i - 1).getMonth() == evaluations.get(i).getMonth() &&
                    evaluations.get(i - 1).getDay() == evaluations.get(i).getDay() + 1) {
                currentDays++;
                currentEval++;
            } else {
                if (currentDays > straightDays) {
                    straightDays = currentDays;
                    numberEvaluations = currentEval;
                } else if (currentDays == straightDays && currentEval > numberEvaluations) {
                    numberEvaluations = currentEval;
                }
                currentDays = 0;
                currentEval = 0;
            }
        }
    }
}
