// Дисциплина: Java Core для тестировщиков
// Домашнее задание №1 "Класс Object"
// Студент: Алексей Пирогов
// Дата: 14.02.2021

package Lesson_2_Exeption;

// Задача 1. Написать метод на вход которому подаётся двухмерный строковый массив размером 4x4.
// При подаче массива другого размера необходимо бросить исключение MyArraySizeExeption.                        (+)

// Задача 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.       (+-)
// Если в каком-то элементе преобразование не удалось (например, если в ячейке лежит символ или текст вместо
// числа), надо бросить исключение MyArrayDataExeption с детализацией, в какой ячейке неверные данные.

// Задача 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException
// и MyArrayDataException и вывести результат расчёта.

public class JavaCore_HWApp {

    public static int[] AdressErrorItem = {0,0};    // Массив для хранения адреса чейки массива 4 x 4 с некорректными данными
    public static int TotalItemArray = 0;           // Переменная типа int для хранения алгебраической суммы элементов массива
    public static boolean ExitInCycle = false;      // Переменная для цикла do ... while при полном переборе массива 4 x 4

    public static void main(String[] args) {

        // 1.Вызов метода functionMyException c валидным значением по размерности массива и
        // невалидными данными для отражения факта генерации исключений (объектов) ArraySizeExeption
        System.out.println("Пример обработки исключения ArraySizeExeption для функции functionMyException:");
        String[][] array_1x4 = new String[1][4];
        try {
            // При вызове функции functionMyException c параметром array_3x3 будет создан обект класса ArraySizeExeption,
            // который будет размещён на вершине стека, если не появится иных ошибок
            functionMyException(array_1x4);     // вызов функции с невалидными данными
        } catch (ArraySizeExeption MyArraySizeExeption) { // создание объекта класса ArraySizeExeption
            // вызов метода printStackTrace объекта MyArraySizeExeption, дочернего по отнонению к классу Exception
            MyArraySizeExeption.printStackTrace();
        }

        String[][] array_4x1 = new String[4][1];
        try {
            // При вызове функции functionMyException c параметром array_3x3 будет создан обект класса ArraySizeExeption,
            // который будет размещён на вершине стека, если не появится иных ошибок
            functionMyException(array_4x1);     // вызов функции с невалидными данными
        } catch (ArraySizeExeption MyArraySizeExeption) { // создание объекта класса ArraySizeExeption
            // вызов метода printStackTrace объекта MyArraySizeExeption, дочернего по отнонению к классу Exception
            MyArraySizeExeption.printStackTrace();
        }

        String[][] array_3x3 = new String[3][3];
        try {
            // При вызове функции functionMyException c параметром array_3x3 будет создан обект класса ArraySizeExeption,
            // который будет размещён на вершине стека, если не появится иных ошибок
            functionMyException(array_3x3);     // вызов функции с невалидными данными
        } catch (ArraySizeExeption MyArraySizeExeption) { // создание объекта класса ArraySizeExeption
            // вызов метода printStackTrace объекта MyArraySizeExeption, дочернего по отнонению к классу Exception
            MyArraySizeExeption.printStackTrace();
        }

        String[][] array_5x5 = new String[5][5];
        try {
            // При вызове функции functionMyException c параметром array_5x5 будет создан обект класса ArraySizeExeption,
            // который будет размещён на вершине стека, если не появится иных ошибок
            functionMyException(array_5x5);     // вызов функции с невалидными данными
        } catch (ArraySizeExeption MyArraySizeExeption) { // создание объекта класса ArraySizeExeption
            // вызов метода printStackTrace объекта MyArraySizeExeption, дочернего по отнонению к классу Exception
            MyArraySizeExeption.printStackTrace();
        }

        // 2.Вызов метода functionMyException c валидным значением по размерности массива и
        // и валидными данными для отражения факта отсутствия генерации исключений (объектов)
        // типа ArraySizeExeption и ArrayDataExeption
        System.out.println("\nПример обработки исключения ArrayDataExeption для функции functionMyException:");
        System.out.println("- валидные данные:");
        String[][] array_4x4_correctData = {{"0", "1", "-1", "2"},
                {"6", "-0", "5", "10"},
                {"0", "1", "100", "-90"},
                {"0", "1", "3", "1"}};
        try {
            functionMyException(array_4x4_correctData);     // вызов функции с валидными данными
        } catch (ArraySizeExeption e) {
            //System.out.println("Функция корректно отработала ... \n Содержимое стека:");
            e.printStackTrace();
        } finally {
            System.out.println("Итоговая сумма элементов массива: " + TotalItemArray);
        }

        // 3.1.Вызов метода functionMyException c валидным значением по размерности массива и
        // и невалидными данными для отражения факта генерации исключений (объектов)
        // типа ArrayDataExeption
        System.out.println("\n- невалидные данные, до первого факта появления данных:");
        String[][] array_4x4_uncorrectData_1 = {{"0", "1", "-1a", "2a"},
                {"6", "0", "5", "10a"},
                {"0", "1", "100", "-90"},
                {"0a", "1a", "3", "1q"}};
        AdressErrorItem[0] = 0;
        AdressErrorItem[1] = 0;
        TotalItemArray = 0;
        try {
            functionMyException(array_4x4_uncorrectData_1);     // вызов функции с невалидными данными
        } catch (ArraySizeExeption | ArrayDataExeption MyExeption) {
            MyExeption.printStackTrace();
        } finally {
            System.out.println("Итоговая сумма элементов массива: " + TotalItemArray);
        }

        // 3.2.Вызов метода functionMyException c валидным значением по размерности массива и
        // и невалидными данными для отражения факта генерации исключений (объектов)
        // типа ArrayDataExeption
        System.out.println("\n- невалидные данные, полный перебор данных массива ...");
        String[][] array_4x4_uncorrectData_2 = {{"0x78", "1", "-1", "2"},
                {"6", "0", "5", "10a"},
                {"0", "1", "100", "-90"},
                {"0a", "1a", "3т", "1q"}};
        AdressErrorItem[0] = 0;
        AdressErrorItem[1] = 0;
        TotalItemArray = 0;
        ExitInCycle = false;
        do {
            try {
                functionMyException(array_4x4_uncorrectData_2);     // вызов функции с невалидными данными
            } catch (ArraySizeExeption | ArrayDataExeption MyExeption) {
                MyExeption.printStackTrace();
            }
            if (ExitInCycle == true) {
                System.out.println("Итоговая сумма элементов массива: " + TotalItemArray + "\n");
            }
        } while (!ExitInCycle);

        // 2.2.Вызов метода functionMyException c валидным значением по размерности массива и
        // и невалидными данными для отражения факта генерации исключений (объектов)
        // типа ArrayDataExeption
        /*
        String[][] array_4x4_uncorrectData_2 = {{"0", "1", "-1", "2"},
                                                {"6", "-0ф", "a5", "10"},
                                                {"0", "1", "100", "-90"},
                                                {"0", "1", "3", "asaasa"}};
        try {
            functionMyException(array_4x4_uncorrectData_2);     // вызов функции с валидными данными
        } catch (ArraySizeExeption MyArraySizeExeption) {
            //System.out.println("Функция корректно отработала ... \n Содержимое стека:");
            MyArraySizeExeption.printStackTrace();
        }
        */
        System.out.println("Все окей, улыбаемся и пляшем!");
    }

    // Исключения (Exeptions) - объекты, генерируемые во время появления ошибочных ситуаций и содержащие информацию о
    // последних, но в отличии от ошибок (Error), исключения могут быть перехвачены программой, обработаны, что
    // предотвратит завершение работы приложения. Ислючения делятся на две группы:
    // - класс Exeptions и его подклассы: исключения, которые обязательно должны быть перехвачены программой (checked)
    // - класс RuntimeExeptions и его продклассы: исключения, охватывающие ситуации такие, как деление на ноль или
    // ошибочная индексация массивов (Unchecked)

    // Метод для генерации исключений
    public static void functionMyException(String[][] array) throws ArrayDataExeption, ArraySizeExeption {
        // Условие для генерациии исключения по размерности массива
        if ((array.length != 4) || (array[0].length != 4)) {
            // Пример создания объекта типа ArraySizeExeption, который является потомком класса Exception
            ArraySizeExeption MyArraySizeExeption = new ArraySizeExeption("ArraySizeExeption: в функцию передан массив размерности " + array.length + " x " + array[0].length + ", что отличается от 4 x 4 ...");
            // Генерация исключения
            throw MyArraySizeExeption;
        } else {
            // ----------------------------------------------------------------------------------------------------------
            // Пример генерации объекта класса ArraySizeExeption (потомок класса Exception):
            // throw new ArraySizeExeption("MyArraySizeExeption: в функцию передан массив размерности равной 4 x 4 ... всё окей на данном этапе!");
            // -----------------------------------------------------------------------------------------------------------

            // Создание массива буффера для хранения промежуточных данных
            // выделение памяти под будущий с размерами эквивалентными массиву типа String, передаваемому в виде параметра
            int bufferArrayItem = 0;
            // Переменная для хранения признака печати элемента массива и управления логикой вывода суммы элементов массива
            boolean noPrint = false;
            // Цикл для копирования данных из массива String в массив Integer c проверкой условия по генерации исключения ArrayDataExeption
            for (int i = AdressErrorItem[0]; i < array.length; i++) {
                for (int j = AdressErrorItem[1]; j < array[i].length; j++) {
                    try {
                        bufferArrayItem = Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException searchNumberFormatException) {
                        //searchNumberFormatException.printStackTrace();
                        noPrint = true;     // сняте запрета на вывод данных с уточнением информации об адресе элемента не подлежащего к преобразованию
                    }
                    if (noPrint == false) {
                        // Добавление к сумме элементов массива значение из ячейки с адресом [i][j]
                        TotalItemArray += bufferArrayItem;
                        System.out.println("Элемент \"" + array[i][j] + "\" успешно преобразован к типу Integer: " + bufferArrayItem + ". Сумма элементов массива: " + TotalItemArray + ".");
                    } else {
                        System.out.print("\"" + array[i][j] + "\" - невозможно преобразовать к типу Integer, адресс элемента в массиве: [" + i + "][" + j + "].");
                        System.out.print(" Сумма элементов массива: " + TotalItemArray + ".\n");
                        AdressErrorItem[0] = i;
                        AdressErrorItem[1] = j;
                        if ((AdressErrorItem[0] < (array.length - 1)) && (AdressErrorItem[1] < (array[0].length - 1))) {
                            AdressErrorItem[1]++;
                        } else if ((AdressErrorItem[0] < (array.length - 1)) && (AdressErrorItem[1] == (array[0].length - 1))) {
                            AdressErrorItem[0]++;
                            AdressErrorItem[1] = 0;
                        } else if ((AdressErrorItem[0] == (array.length - 1)) && (AdressErrorItem[1] < (array[0].length - 1))) {
                            AdressErrorItem[1]++;
                        } else if ((AdressErrorItem[0] == (array.length - 1)) && (AdressErrorItem[1] == (array[0].length - 1))) {
                            ExitInCycle = true;
                        }
                        throw new ArrayDataExeption("ArrayDataExeption: \"" + array[i][j] + "\" - невозможно преобразовать к типу Integer, адресс элемента в массиве: [" + i + "][" + j + "]. Сумма элементов массива: " + TotalItemArray + ".\n");
                    }
                    // Установка переменной в исходное состояние
                    noPrint = false;
                }
            }
        }
    }
}
