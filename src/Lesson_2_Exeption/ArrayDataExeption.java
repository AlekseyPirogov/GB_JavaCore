package Lesson_2_Exeption;

// класс ArrayDataExeption является наследником класса NumberFormatException
public class ArrayDataExeption extends NumberFormatException {

    // Перегруженный параметризированный констурктор обрабатывающий объект типа String
    ArrayDataExeption(String str) {
        super(str);     // вызов родительского конструктора
    }

    // Перегруженный параметризированный констурктор обрабатывающий массив объектов типа String
    ArrayDataExeption(String[][] array) {
        super("ArraySizeExeption: в функцию передан массив размерности " + array.length + " x " + array[0].length + ", что отличается от 4 x 4 ...");
    }
}
