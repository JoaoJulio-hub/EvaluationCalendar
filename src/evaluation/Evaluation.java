package evaluation;

import java.time.LocalDate;

public interface Evaluation {

    int getYear();

    int getMonth();

    int getDay();

    String getCourse();

    LocalDate createDate(int year, int month, int day);



}
