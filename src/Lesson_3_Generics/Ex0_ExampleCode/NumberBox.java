package Lesson_3_Generics.Ex0_ExampleCode;

import java.util.Arrays;

// Пример класса с ограничением типа хранимых значений

// Ограничение применяется типа применяется когда требуется ограничить тип параметра.
// Когда указывается параметр типа, можно создать ограничение сверху, которое укажет суперкласс, от которого
// должны быть унаследованы все аргументы типов.

// В роли ограничителя сверху может выступать не только класс, но и один или несколько интерфейсов.
// Для указания нескольких элементов используется оператор &. Примеры:
// - <T extends Cat>
// - <T extends Animal & Serializable>
// - <T extends Serializable>
// - <T extends Clonable & Serializable>

// Если в качестве ограничителя используется класс и интерфейс, то класс должен быть указан первым.
// Параметр Т может быть заменен только самим суперклассом или его подклассами. Он объявляет включающую
// верхнюю границу. Можно использовать ограничение сверху, чтобы исправить класс.

public class NumberBox<TypeVariable extends Number> {

    private TypeVariable[] array;

    // Параметризованный конструктор класса, принимающий произвольное количестов аргуметов типа TypeVariable
    // (массив элементов, синтаксический сахар Java)
    public NumberBox(TypeVariable... array){
        this.array = array;
    }

    // Набор из геттера и сеттера:
    public TypeVariable[] getArray() {
        return array;
    }

    public void setArray(TypeVariable[] array) {
        this.array = array;
    }

    // Метод для вывода содержимого массива
    @Override
    public String toString() {
        return "NumberBox{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    // Метод для вывода типа массива
    public String getType() {
        return array.getClass().getSimpleName();
    }

    // Метод для вывода среднего значения по массиву
    public double avg() {
        double sum = 0.0;
        for (TypeVariable num: array) {
            // Метод doubleValue() из класса Number позволяет любой числовой объект привести к double
            sum += num.doubleValue();
        }
        return sum / array.length;
    }

    // Метод контекста класса для получения произвольного элемента массива
    // Никакой сатический член не может использовать тип параметра, объявленный в его классе
    public static <UserType extends Number> UserType getItemArray(NumberBox<UserType> box, int numberItem) {
        return box.getArray()[numberItem];
    }

    // Класс NumberBox является обобщенным, и при написании метода isSameAvg() непонятно какой тип указать для аргумента.
    // Представленный код будет работать только с объектом класса NumberBox тип которого совпадает с вызывающим объектом.
    public boolean isSameAvg_(NumberBox<TypeVariable> varBox) {
        // Чтобы не столкнуться с ошибкой округления при сравнении двух дробных чисел,
        // нужно сравнить средние значения в пределах дельты 0.0001
        return Math.abs(this.avg() - varBox.avg()) < 0.0001;
    }

    // Для создания обобщенной версии метода isSameAvg, следует использовать метасимвольные аргументы.
    // Запись NumberBox<?> соответствует любому объекту класса NumberBox. Можно сравнивать средние значения любых двух
    // объектов этого класса.

    // Метасимвольный аргумент не влияет на тип создаваемого объекта класса NumberBox. Это зависит от extends в объявлении
    // класса NumberBox

    // Метод для проверки средних значений для текущей коробки и аргумента
    // public boolean isSameAvg(numberBox<T> varBox) {}
    public boolean isSameAvg(NumberBox<?> varBox) {
        // Чтобы не столкнуться с ошибкой округления при сравнении двух дробных чисел,
        // нужно сравнить средние значения в пределах дельты 0.0001
        return Math.abs(this.avg() - varBox.avg()) < 0.0001;
    }

    // Никакой статический член не может использовать тип параметра, объявленный в его классе
    // static T data;       <-- неверно, нельзя создать статические переменные типа Т
    // static T getData() { return data; }          <-- неверно, ни один статический метод не может использовать Т
    // Нельзя объявить статические члены, использующие обобщенный тип. Но можно объявлять обобщённые статические методы,
    // определяющие их собственные парамеры типа

    // Ограничения обобщенных исключений. Обобщенный класс не может расширять класс Throwable. Значит, создать обобщенные
    // классы исключений невозможно.

    public static void main(String[] args) {

        // Объекты типа NumberBox параметризованные типом Integer:
        NumberBox<Integer> numberBox1 = new NumberBox<>(1, 2, 3, 5, 0);
        System.out.println("Содержимое \"numberBox1\": " + numberBox1.toString());
        System.out.println("Среднее значение \"numberBox1\": " + numberBox1.avg());
        System.out.println("Первый элемент массива \"numberBox1\": " + getItemArray(numberBox1,0));

        NumberBox<Integer> numberBox2 = new NumberBox<>(1, 2, 3, 5, 4);
        System.out.println("Содержимое \"numberBox2\": " + numberBox2.toString());
        System.out.println("Среднее значение \"numberBox2\": " + numberBox2.avg());
        System.out.println("Послдений элемент массива \"numberBox2\": " + getItemArray(numberBox2,numberBox2.array.length-1));

        // Пример работы функции isSameAvg() для numberBox1 и numberBox2
        System.out.println("\nСредние заначения \"numberBox1\" и \"numberBox2\" равны - " + numberBox1.isSameAvg(numberBox2) + "\n");

        NumberBox<Double> doubleNumberBox1 = new NumberBox<>(1.2, 2.5, 4.45, 30.1, 0.723);
        System.out.println("Содержимое \"doubleNumberBox1\": " + doubleNumberBox1.toString());
        System.out.println("Среднее значение \"doubleNumberBox1\": " + doubleNumberBox1.avg() + "\n");

        // Пример работы функции isSameAvg() для Integer и Double
        System.out.println("\nСредние заначения \"numberBox1\" и \"doubleNumberBox1\" равны - " + numberBox1.isSameAvg(doubleNumberBox1));

        NumberBox<Double> doubleNumberBox2 = new NumberBox<>(1.0, 2.0, 3.0, 5.0, 0.0);
        System.out.println("Содержимое \"doubleNumberBox2\": " + doubleNumberBox2.toString());
        System.out.println("Среднее значение \"doubleNumberBox2\": " + doubleNumberBox2.avg() + "\n");

        System.out.println("\nСредние заначения \"numberBox1\" и \"doubleNumberBox2\" равны - " + numberBox1.isSameAvg(doubleNumberBox2));
    }
}
