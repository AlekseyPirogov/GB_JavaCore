package Lesson_1_Object.Ex3_Course;

import Lesson_1_Object.Ex2_Team.CalssRunner.Runner;
import Lesson_1_Object.Ex2_Team.ChildRunner.Dog;
import Lesson_1_Object.Ex2_Team.ChildRunner.Human;
import Lesson_1_Object.Ex2_Team.ChildRunner.Robot;
import Lesson_1_Object.Ex2_Team.ChildRunner.Tiger;
import Lesson_1_Object.Ex2_Team.Team;

public class Course {

    // Перечень параметров для инициализации полосы препятствий
    protected static int numberCourse;
    protected String nameOfCourse;
    public Object[] arrayCourse;

    // Инициализатор static отвечает за зануление счётчика количества количествв объектов класса
    // вызывается при первом обращении к конструктору, создании первого объекта класса
    static {
        numberCourse = 0;
    }

    // Инициализатор отвечает за инкремент поля numberCourse.
    // Вызывается при каждом образещении к конструктору, создании объекта класса.
    {
        numberCourse++;
    }

    // Непараметризированный конструктор класса Course, используется по умолчанию для создания объектов класса
    // Служит для формирование массива экземпляров класса типа Object для хранения: объектов типа Track чередующихся с объектами типа Wall
    public Course(String nameOfCourse) {
        System.out.println("Формирование полосы препятствий: ");
        arrayCourse = new Object[7];    // размерность будущей полосы препятствий (по умолчанию 7 элементов)
        createCourse(arrayCourse);       // вызов метода для формирования полосы
        this.nameOfCourse = nameOfCourse;
        System.out.println("Полоса препятствий c именем \"" + this.nameOfCourse + "\"" + " (на " + arrayCourse.length + " препятствий) сформирована.\n\n");
    }

    // Параметризированный конструктор класса Course, используется для создания объектов класса
    // с заданным числом препятствий (количество препятствий передаётся в виде параметра)
    public Course(int countWall, String nameOfCourse) {
        if (countWall < 0) {
            System.out.println("Ошибка. В конструктор Course передано отрицательное значение!");
        } else {
            System.out.println("Формирование полосы препятствий: c именем \"" + nameOfCourse + "\"");
            countWall = 2 * countWall + 1; // Формирование размерности полосы препятствий с учётом количества препятствий
            arrayCourse = new Object[countWall];    // Размерность будущей полосы препятствий, тип: Object (!)
            // Каждый элемента массива arrayCourse[] хранит в себе некторый объект класса Track или Barrier, согласно логике его заполнения
            this.createCourse(arrayCourse);   // Взов функции createCourse с массивом arrayCourse[] в качестве аргумента
            this.nameOfCourse = nameOfCourse;
            System.out.println("Полоса препятствий c именем \"" + this.nameOfCourse + "\"" + " (на " + arrayCourse.length + " препятствий) сформирована.\n\n");
        }
    }

    // Приватный метод класcа Course предназначен для создания объектов типа Track и Wall, а также их инициализации
    private void createCourse(Object arrayCourse[]) {
        // Цикл на countWall повторений, по чётным элементам массива (по трекам, объектам класса Track) начиная с нулевого элемента,
        // также в цикле обрабатываются соседние с i-м элементы, нечётные элементы (i+1) - объеты класса Barrier,
        for (int i = 0; i < arrayCourse.length; i = i + 2) {
            // Адресация элементов массива до TrackWithWall.length - 1
            if (i < arrayCourse.length - 1) {
                // Нулевой элемент в полосе препятсвий - объект класса Track всегда c длиной 20 м
                if (i == 0) {
                    arrayCourse[i] = new Track(20);   // <- нулевой элемент c длиной 20 м
                } else {    //, а прочие дорожки с произвольной длиной
                    arrayCourse[i] = new Track();           // <- прочие отрезки полосы препятствий с произвольной длиной
                }
                // Каждый нечётный элемент в массиве TrackWithWall[] - объект класса Barrier
                arrayCourse[i + 1] = new Barrier();         // <- высота препятсвиия определяемой произвольным образом
                // Адресация последнего элемента массива, для формирования конца полосы препятствий
            } else {
                arrayCourse[arrayCourse.length - 1] = new Track(20); // <- окончание полосы препятствий с длиной 20 м
            }
        }

        // Вызов методов, принадлежащих контекту класса Track и Barrier:
        Track.setCounterTrack(0);   // <- зануление счётчика с количеством дорожек
        Barrier.setCounterWall(0);  // <- зануление счётчика с количеством препятствий
    }

    public void doIt(Team arrayParcipiants) {
        // Набор констант для управления логикой движения по полосе препятсвий команды из участников
        int TrackWithWall_lengthArray = this.arrayCourse.length;
        int TrackWithWallPenultimateElement = this.arrayCourse.length - 1;
        int Participants_lengthArray = arrayParcipiants.Participants.length;

        // Цикл по препятсвиям (по секторам) для команды класса Team
        // Состав сектора: трек до препятствия и само препятсвтвие
        for (int i = 0; i < TrackWithWall_lengthArray; i += 2) {
            if (i < (TrackWithWallPenultimateElement)) {
                // Цикл для бега для команды класса Team:
                for (int j = 0; j < Participants_lengthArray; j++) {
                    if (arrayParcipiants.Participants[j] instanceof Tiger) {
                        ((Tiger) arrayParcipiants.Participants[j]).run((Track) this.arrayCourse[i]);
                    } else if (arrayParcipiants.Participants[j] instanceof Dog) {
                        ((Dog) arrayParcipiants.Participants[j]).run((Track) this.arrayCourse[i]);
                    } else if (arrayParcipiants.Participants[j] instanceof Human) {
                        ((Human) arrayParcipiants.Participants[j]).run((Track) this.arrayCourse[i]);
                    } else if (arrayParcipiants.Participants[j] instanceof Robot) {
                        ((Robot) arrayParcipiants.Participants[j]).run((Track) this.arrayCourse[i]);
                    }
                }
                // Цикл для прыжков команды класса Team:
                for (int j = 0; j < Participants_lengthArray; j++) {
                    if (arrayParcipiants.Participants[j] instanceof Tiger) {
                        ((Tiger) arrayParcipiants.Participants[j]).jump((Barrier) this.arrayCourse[i + 1]);
                    } else if (arrayParcipiants.Participants[j] instanceof Dog) {
                        ((Dog) arrayParcipiants.Participants[j]).jump((Barrier) this.arrayCourse[i + 1]);
                    } else if (arrayParcipiants.Participants[j] instanceof Human) {
                        ((Human) arrayParcipiants.Participants[j]).jump((Barrier) this.arrayCourse[i + 1]);
                    } else if (arrayParcipiants.Participants[j] instanceof Robot) {
                        ((Robot) arrayParcipiants.Participants[j]).jump((Barrier) this.arrayCourse[i + 1]);
                    }
                }
                // Иллюстрация движения по финишной прямой для команды класса Team
            } else {
                int nobodyFinished = 1; // Переменная для хранения признака отсутствия финиширующих
                System.out.println("\n\nФинишная прямая ...");
                // Цикл по массиву участников забега
                for (int j = 0; j < Participants_lengthArray; j++) {
                    // Если элемент массива принадлежит типу Tiger и учатник НЕ принимает участие
                    if (arrayParcipiants.Participants[j] instanceof Tiger) {
                        if (((Tiger) arrayParcipiants.Participants[j]).getTakePart() == false) {
                            nobodyFinished *= 1;    // то сохранение признака nobodyFinished = 1
                            continue;               // и переход к следующму участнику, на следующую итерацию цикла
                        } else {
                            // Если элемент массива принадлежит типу Tiger и учатник НЕ принимает участие
                            nobodyFinished *= 0;    // то установка признака nobodyFinished = 0
                            // бег по финишной прямой:
                            ((Tiger) arrayParcipiants.Participants[j]).run((Track) this.arrayCourse[TrackWithWallPenultimateElement]);
                        }
                    }

                    // Аналогичные действия для оставшихся элементов массива Participants:
                    if (arrayParcipiants.Participants[j] instanceof Dog) {
                        if (((Dog) arrayParcipiants.Participants[j]).getTakePart() == false) {
                            nobodyFinished *= 1;
                            continue;
                        } else {
                            nobodyFinished *= 0;
                            ((Dog) arrayParcipiants.Participants[j]).run((Track) this.arrayCourse[TrackWithWallPenultimateElement]);
                        }
                    }
                    if (arrayParcipiants.Participants[j] instanceof Human) {
                        if (((Human) arrayParcipiants.Participants[j]).getTakePart() == false) {
                            nobodyFinished *= 1;
                            continue;
                        } else {
                            nobodyFinished *= 0;
                            ((Human) arrayParcipiants.Participants[j]).run((Track) this.arrayCourse[TrackWithWallPenultimateElement]);
                        }
                    }
                    if (arrayParcipiants.Participants[j] instanceof Robot) {
                        if (((Robot) arrayParcipiants.Participants[j]).getTakePart() == false) {
                            nobodyFinished *= 1;
                            continue;
                        } else {
                            nobodyFinished *= 0;
                            ((Robot) arrayParcipiants.Participants[j]).run((Track) this.arrayCourse[TrackWithWallPenultimateElement]);
                        }
                    }
                }

                if (nobodyFinished == 1) {
                    System.out.println("До финишной прямой никто не дошёл...");
                } else {
                    System.out.println("\nДо финишной прямой дошли:");
                    for (int j = 0; j < Participants_lengthArray; j++) {
                        if (((arrayParcipiants.Participants[j] instanceof Tiger) && (((Tiger) arrayParcipiants.Participants[j]).getTakePart() == true)) ||
                                ((arrayParcipiants.Participants[j] instanceof Human) && (((Human) arrayParcipiants.Participants[j]).getTakePart() == true)) ||
                                ((arrayParcipiants.Participants[j] instanceof Dog) && (((Dog) arrayParcipiants.Participants[j]).getTakePart() == true)) ||
                                ((arrayParcipiants.Participants[j] instanceof Robot) && (((Robot) arrayParcipiants.Participants[j]).getTakePart() == true)))
                        {
                            System.out.println(arrayParcipiants.Participants[j].toString() + "\t\t" + ((Runner) arrayParcipiants.Participants[j]).voice());
                        }
                    }
                }
            }
        }

        // Обновление характеристки учатников:
        for (int j = 0; j < Participants_lengthArray; j++) {
            if (arrayParcipiants.Participants[j] instanceof Tiger)
                ((Tiger) arrayParcipiants.Participants[j]).setRemainsDistance(((Tiger) arrayParcipiants.Participants[j]).getMaxDistance());
            if (arrayParcipiants.Participants[j] instanceof Dog)
                ((Dog) arrayParcipiants.Participants[j]).setRemainsDistance(((Dog) arrayParcipiants.Participants[j]).getMaxDistance());
            if (arrayParcipiants.Participants[j] instanceof Human)
                ((Human) arrayParcipiants.Participants[j]).setRemainsDistance(((Human) arrayParcipiants.Participants[j]).getMaxDistance());
            if (arrayParcipiants.Participants[j] instanceof Robot)
                ((Robot) arrayParcipiants.Participants[j]).setRemainsDistance(((Robot) arrayParcipiants.Participants[j]).getMaxDistance());
        }
    }
}
