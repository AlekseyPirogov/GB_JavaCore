package Lesson_2_Exeption;

public class ArraySizeExeption extends Exception {
    // Перегруженный параметризированный констурктор обрабатывающий объект типа String
    ArraySizeExeption(String str) {
        super(str);     // вызов родительского конструктора
    }
    // Перегруженный параметризированный констурктор обрабатывающий массив объектов типа String
    ArraySizeExeption(String[][] array) {
        super("ArraySizeExeption: в функцию передан массив размерности " + array.length + " x " + array[0].length + ", что отличается от 4 x 4 ...");
    }
}
