package Lesson_1_Object.Ex2_Team;

import Lesson_1_Object.Ex2_Team.CalssRunner.Runner;
import Lesson_1_Object.Ex2_Team.ChildRunner.Dog;
import Lesson_1_Object.Ex2_Team.ChildRunner.Human;
import Lesson_1_Object.Ex2_Team.ChildRunner.Robot;
import Lesson_1_Object.Ex2_Team.ChildRunner.Tiger;
import Lesson_1_Object.Ex3_Course.Barrier;
import Lesson_1_Object.Ex3_Course.Course;
import Lesson_1_Object.Ex3_Course.Track;

import java.util.Arrays;

public class Team {

    // Перечень атрибутов принадлежащих контексту класса:
    protected static int counterObject;     // счётчик количества объектов

    // Перечень параметров для инициализации команды:
    public static int numberTeam;
    public String nameOfTeam;
    public Object[] Participants;

    // Инициализатор static отвечает за зануление счётчика количества количествв объектов класса
    // вызывается при первом обращении к конструктору, создании первого объекта класса
    static {
        numberTeam = 0;
    }

    // Инициализатор отвечает за инкремент поля counterObject.
    // Вызывается при каждом образещении к конструктору, создании объекта класса.
    {
        numberTeam++;
    }

    // Параметризированный констркутор класса Team
    public Team(String nameOfTeam, Object... objectsArrayParticipants) {
        this.nameOfTeam = nameOfTeam;
        if (objectsArrayParticipants.length != 0) {
            // Выделение памяти под массив с учатниками и инициализация массива данными
            // передаваемыми в конструктор вторым аргументом
            Participants = new Object[objectsArrayParticipants.length];
            for (int i=0; i < objectsArrayParticipants.length; i++) {
                Participants[i] = objectsArrayParticipants[i];
            }
        } else {
            // Объявление массива с участниками размерностью 4, массив является экземпляром класса Object
            Participants = new Object[4];
            System.out.println("Подбор учатников для команды \"" + this.nameOfTeam + "\" с порядковым номером " + this.numberTeam + ":\n");
            // Инициализация ячеек массива объектами классов Cat, Dog, Human, Robot
            Participants[0] = new Tiger("Tiger", 12, "полосатый", 60, 100);
            Participants[1] = new Dog("Dog", 12, "полосатый", 600, 120);
            Participants[2] = new Human("Homo", 120, 300, 120);
            Participants[3] = new Robot("Robo", 1, 24, 200);
        }
    }

    // Вывод информации об участника в неформтировнном виде
    public void showResultParticipants() {
        System.out.println("\n\nСостояние участников команды \"" + this.nameOfTeam +"\":");
        //Вывод информации в виде строк
        for(int j = 0; j < this.Participants.length; j++) {
            System.out.println(this.Participants[j].toString());
        }
    }

    // Вывод информмации об объете класса Team
    public void showObject() {
        System.out.println(this.toString() + '\n');
    }

    // Переопределённый метод toString
    @Override
    public String toString() {
        return "Team {" +
                "nameOfTeam='" + nameOfTeam + '\'' +
                ", Participants=" + Arrays.toString(Participants) +
                '}';
    }

    // Метод для преодоления полосы препятсвий, чередование бега и прыжков
    // Цикл для бега по полосе препятствий:
    public void RunAndJump(Course TrackWithWall) {
        // Набор констант для управления логикой движения по полосе препятсвий команды из участников
        int TrackWithWall_lengthArray = TrackWithWall.arrayCourse.length;
        int TrackWithWallPenultimateElement = TrackWithWall.arrayCourse.length - 1;
        int Participants_lengthArray = this.Participants.length;

        // Цикл по препятсвиям (по секторам) для команды класса Team
        // Состав сектора: трек до препятствия и само препятсвтвие
        for (int i = 0; i < TrackWithWall_lengthArray; i += 2) {
            if (i < (TrackWithWallPenultimateElement)) {
                // Цикл для бега для команды класса Team:
                for (int j = 0; j < Participants_lengthArray; j++) {
                    if (this.Participants[j] instanceof Tiger) {
                        ((Tiger) this.Participants[j]).run((Track) TrackWithWall.arrayCourse[i]);
                    } else if (this.Participants[j] instanceof Dog) {
                        ((Dog) this.Participants[j]).run((Track) TrackWithWall.arrayCourse[i]);
                    } else if (this.Participants[j] instanceof Human) {
                        ((Human) this.Participants[j]).run((Track) TrackWithWall.arrayCourse[i]);
                    } else if (this.Participants[j] instanceof Robot) {
                        ((Robot) this.Participants[j]).run((Track) TrackWithWall.arrayCourse[i]);
                    }
                }
                // Цикл для прыжков команды класса Team:
                for (int j = 0; j < Participants_lengthArray; j++) {
                    if (this.Participants[j] instanceof Tiger) {
                        ((Tiger) this.Participants[j]).jump((Barrier) TrackWithWall.arrayCourse[i + 1]);
                    } else if (this.Participants[j] instanceof Dog) {
                        ((Dog) this.Participants[j]).jump((Barrier) TrackWithWall.arrayCourse[i + 1]);
                    } else if (this.Participants[j] instanceof Human) {
                        ((Human) this.Participants[j]).jump((Barrier) TrackWithWall.arrayCourse[i + 1]);
                    } else if (this.Participants[j] instanceof Robot) {
                        ((Robot) this.Participants[j]).jump((Barrier) TrackWithWall.arrayCourse[i + 1]);
                    }
                }
                // Иллюстрация движения по финишной прямой для команды класса Team
            } else {
                int nobodyFinished = 1; // Переменная для хранения признака отсутствия финиширующих
                System.out.println("\nФинишная прямая ...");
                // Цикл по массиву участников забега
                for (int j = 0; j < Participants_lengthArray; j++) {

                    // Если элемент массива принадлежит типу Tiger и учатник НЕ принимает участие
                    if (this.Participants[j] instanceof Tiger) {
                        if (((Tiger) this.Participants[j]).getTakePart() == false) {
                            nobodyFinished *= 1;    // то сохранение признака nobodyFinished = 1
                            continue;               // и переход к следующму участнику, на следующую итерацию цикла
                        } else {
                            // Если элемент массива принадлежит типу Tiger и учатник НЕ принимает участие
                            nobodyFinished *= 0;    // то установка признака nobodyFinished = 0
                            // бег по финишной прямой:
                            ((Tiger) this.Participants[j]).run((Track) TrackWithWall.arrayCourse[TrackWithWallPenultimateElement]);
                        }
                    }

                    // Аналогичные действия для оставшихся элементов массива Participants:
                    if (this.Participants[j] instanceof Dog) {
                        if (((Dog) this.Participants[j]).getTakePart() == false) {
                            nobodyFinished *= 1;
                            continue;
                        } else {
                            nobodyFinished *= 0;
                            ((Dog) this.Participants[j]).run((Track) TrackWithWall.arrayCourse[TrackWithWallPenultimateElement]);
                        }
                    }
                    if (this.Participants[j] instanceof Human) {
                        if (((Human) this.Participants[j]).getTakePart() == false) {
                            nobodyFinished *= 1;
                            continue;
                        } else {
                            nobodyFinished *= 0;
                            ((Human) this.Participants[j]).run((Track) TrackWithWall.arrayCourse[TrackWithWallPenultimateElement]);
                        }
                    }
                    if (this.Participants[j] instanceof Robot) {
                        if (((Robot) this.Participants[j]).getTakePart() == false) {
                            nobodyFinished *= 1;
                            continue;
                        } else {
                            nobodyFinished *= 0;
                            ((Robot) this.Participants[j]).run((Track) TrackWithWall.arrayCourse[TrackWithWallPenultimateElement]);
                        }
                    }
                }
                // Вывод информации, что до финишной прямой никто не дошёл
                if (nobodyFinished == 1) {
                    System.out.println("До финишной прямой никто не дошёл...");
                } else {
                    System.out.println("\nДо финишной прямой дошли:");
                    for (int j = 0; j < Participants_lengthArray; j++) {
                        if (((this.Participants[j] instanceof Tiger) && (((Tiger) this.Participants[j]).getTakePart() == true)) ||
                            ((this.Participants[j] instanceof Human) && (((Human) this.Participants[j]).getTakePart() == true)) ||
                            ((this.Participants[j] instanceof Dog) && (((Dog) this.Participants[j]).getTakePart() == true)) ||
                            ((this.Participants[j] instanceof Robot) && (((Robot) this.Participants[j]).getTakePart() == true)))
                        {
                            System.out.println(this.Participants[j].toString() + "\t\t" + ((Runner) this.Participants[j]).voice());
                        }
                    }
                }
            }
        }

        // Обновление характеристки учатников:
        for (int j = 0; j < Participants_lengthArray; j++) {
            if (this.Participants[j] instanceof Tiger)
                ((Tiger) this.Participants[j]).setRemainsDistance(((Tiger) this.Participants[j]).getMaxDistance());
            if (this.Participants[j] instanceof Dog)
                ((Dog) this.Participants[j]).setRemainsDistance(((Dog) this.Participants[j]).getMaxDistance());
            if (this.Participants[j] instanceof Human)
                ((Human) this.Participants[j]).setRemainsDistance(((Human) this.Participants[j]).getMaxDistance());
            if (this.Participants[j] instanceof Robot)
                ((Robot) this.Participants[j]).setRemainsDistance(((Robot) this.Participants[j]).getMaxDistance());
        }
    }
}
