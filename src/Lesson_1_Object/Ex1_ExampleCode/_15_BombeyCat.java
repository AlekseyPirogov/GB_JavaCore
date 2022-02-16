package Lesson_1_Object.Ex1_ExampleCode;

// Класс BombeyCat - класс поттомок от класса Cat, который потомок HomeAnimal, который потомок Animal
public class _15_BombeyCat extends _14_Cat{
    // Содержит поле типа private
    private int privateVarBombeyCat;

    // Пример конструктора в классе использующего вызов super для инициализации полей наследуемых от супперклассов
    public _15_BombeyCat(int privateVarHomeAnimal, int privateVarCat, int privateVarBombeyCat) {
        super(privateVarHomeAnimal, privateVarCat);
        this.privateVarBombeyCat = privateVarBombeyCat;
    }
    // Порядок вызова конструкторов:
    // при вызове конструктора BombeyCat будут по цепочке вызваны конструкторы родительских классов, начиная с самого
    // первого класса. Конструкторы вызываются в порядке наследования, поскольку суперклассу ничего неизвестно о своих
    // подклассах, и поэтому любая инициализация должна быть выполнена в нём совершенно независимо от любой инициализации,
    // выполняемой подклассом. Следовательно она должна выполняться в первую очередь.

    //BombeyCat bombeyCat = new BombeyCat();
    // Animal() => Cat() => BombeyCat()
}
