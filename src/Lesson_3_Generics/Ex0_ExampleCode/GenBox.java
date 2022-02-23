package Lesson_3_Generics.Ex0_ExampleCode;

    // GenBox - GenericBox
    // Обобщения - параметризованные типы данных, которые позволяют объявлять обобщенные классы, интерфейсы и методы,
    // где тип данных, которыми они оперируют, указан в виде параметра. Обобщения добавляют в Java безопасность типов
    // и делают управление проще. Исключается необходимость применять явные приведения типов, так как благодаря обобще
    // ниям все приведения выполняются неявно, в автоматическом режиме.

    // В объявлении класса, T представляет собой имя параметра типа, на место которого при создании объекта класса
    // GenBox будет подставлен конкретный тип данных. То есть используется обобщения можно создавать переменные типы
    // данных. Обобщения работают только с сылочными типами данных. Для работы с примитивами надо использовать классы-обертки

    // Обычно для параметризации используются:
    // E - элемент коллекции
    // K, V - key, value
    // T - type
    // S, U, V - соседи буквы T для обозначения тип

    // Но возможно использовать и сочетание букв или вообще слово, например: Type, typeVariable,variableName.
    // При работе с обобщениями важно помнить, что обобщения работают только с сылочными типами данных, а для
    // работы с примитивами надо будет использовать классы-обертки.

// Пример параметризованного класса
public class GenBox<typeVariable> {

    // В статтие нельзя менять тип данных, статические поля существуют в контексте класса:
    // private static T obj;
    // - нельзя создавать функцию с параметризованным типом:
    // public static T test() {}
    // - нельзя создать конструктор с параметризованным типом:
    // public void test2() {
    //      T obj = new T();    <- у класса может просто не быть конструктора по-умолчанию
    // }

    private typeVariable object;

    // Парметризованный конструктор класса с парметризованным аргументом
    public GenBox(typeVariable object) {
        this.object = object;
    }

    // Набор из геттера и сеттера для парметризованного поля object
    public typeVariable getObject() {
        return this.object;
    }

    public void setObject(typeVariable object) {
        this.object = object;
    }

    // Метод для определения типа переменной
    public void showType(String nameVar) {
        System.out.println("Метод \"showType\" переменной \"" + nameVar + "\": " + this.getObject().getClass().getName());
    }

    // Переопределенный метод toString
    @Override
    public String toString() {
        return "GenBox{" +
                "object=" + object +
                '}';
    }

    public static void main(String[] args) {

        // Создание объектов разного типа с ипользованием инструментов параметризации:
        GenBox<Integer> integerGenBox1 = new GenBox<>(10);
        GenBox<Integer> integerGenBox2 = new GenBox<>(100);
        GenBox<Double> doubleGenBox = new GenBox<>(10.0);
        GenBox<String> stringGenBox = new GenBox<>("100.0");

        // При получении значений из представленных переменных не требуется преобразование типов, integerGenBox1.getObject()
        // сразу возвращает Integer, а stringGenBox.getObject() - String. То есть приведение типов выполняется неявно, авто-
        // матически

        // Вывод информации об объектах:
        System.out.println("integerGenBox1.getObject(): " + integerGenBox1.getObject());
        System.out.println("integerGenBox1.getObject().getClass().getName(): " + integerGenBox1.getObject().getClass().getName());
        System.out.println("integerGenBox1.getObject().getClass().getSimpleName()" + integerGenBox1.getObject().getClass().getSimpleName());
        // Вызов метод для определения типа хранимого объекта
        integerGenBox1.showType("integerGenBox1");

        System.out.println("\nintegerGenBox2.getObject(): " + integerGenBox2.getObject());
        System.out.println("integerGenBox2.getObject().getClass().getName(): " + integerGenBox2.getObject().getClass().getName());
        System.out.println("integerGenBox2.getObject().getClass().getSimpleName()" + integerGenBox2.getObject().getClass().getSimpleName());
        integerGenBox2.showType("integerGenBox2");

        // Сложение объектов:
        System.out.println("\n\nintegerGenBox1.getObject() + integerGenBox2.getObject() = " + (integerGenBox1.getObject() + integerGenBox2.getObject()) + "\n\n");

        // Если объект создан как GenBox<Integer>, то нельзя записать строку в поле. При попытке написать такую строку
        // кода будет выдана ошибка на этапе компиляции, то есть обобщения отлеживают корректность используемых типов данных
        // integerGenBox1.setObject("Java");    <-- ошибка компиляции

        // Эти две особенности приводит к повышению безопасности типовых данных, и упрощению работы при написании кода.
        // Ссылка на одну специфичную версию обобщенного типа не обладает совместимостью с другой версией того же обобщенного типа:
        // integerGenBox1 = stringGenBox;       <-- принадлежит классу GenBox<typeVariable>, но представляют собой ссылки на разные
        // типы - ведь типы их параметров отличается


        // Вывод информации о других переменных
        doubleGenBox.showType("doubleGenBox");
        stringGenBox.showType("stringGenBox");


        // Если не используется паметризация, то по-сути GenBox вырождается до Box
        GenBox genBox = new GenBox(10.0);

        // Вывод информации об объектах:
        System.out.println("\ngenBox.getObject(): " + genBox.getObject());
        System.out.println("genBox.getObject().getClass().getName(): " + genBox.getObject().getClass().getName());
        System.out.println("genBox.getObject().getClass().getSimpleName(): " + genBox.getObject().getClass().getSimpleName());


    }
}
