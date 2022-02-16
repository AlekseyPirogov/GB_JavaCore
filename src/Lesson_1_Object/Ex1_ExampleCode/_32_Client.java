package Lesson_1_Object.Ex1_ExampleCode;

public class _32_Client implements _02_ExampleInterface, _31_Information {

    // метод самого класса
    void functionClient(){

    }

    // методы интерфейсов переопределяемые в классе Client
    @Override
    public void exampleInterface(int var1) {
        System.out.println("Example interface. Variable: " + var1);
    }

    @Override
    public void function() {
        System.out.println("Function \"function\".");
    }

    // Доступ к реализации через ссылки на интерфейсы
    // По аналогии с тем, что ссылку на объект подкласса можно записать в ссылку на суперкласс (Animal a = new Cat()),
    // можно сделать и ссылку на объект любого класса, который реализует указанный интерфейс (Flyable f = new Bird(),
    // где class Bird implements Flyable). При вызове метода по одной из таких ссылок нужный вариант будет выбираться в
    // зависимости от конкретного экземпляра интерфейса, на который делается ссылка.
}
