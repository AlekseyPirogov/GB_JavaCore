package Lesson_1_Object.Ex2_Team.CalssRunner;

import Lesson_1_Object.Ex3_Course.Track;

public interface Run {

    // Сигнатура метода для бега
    default void run(Object track) {
        return;
    }

    default void run(Track track) {
        return;
    }

}
