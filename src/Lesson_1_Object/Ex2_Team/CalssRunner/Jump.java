package Lesson_1_Object.Ex2_Team.CalssRunner;

import Lesson_1_Object.Ex3_Course.Barrier;

public interface Jump {

    // Сигнатура метода для прыжка
    default void jump(Object barrier) {
        return;
    }

    default void jump(Barrier barrier) {
        return;
    }
}
