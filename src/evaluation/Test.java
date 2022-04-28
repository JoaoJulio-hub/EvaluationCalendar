package evaluation;

import java.time.LocalDateTime;

public interface Test extends Evaluation{

    int getHour();

    int getMinutes();

    int getDuration();

    LocalDateTime createTime(int hour, int minutes, int duration);
}
