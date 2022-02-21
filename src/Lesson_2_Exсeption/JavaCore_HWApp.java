// Дисциплина: Java Core для тестировщиков
// Домашнее задание №1 "Класс Object"
// Студент: Алексей Пирогов
// Дата: 20.02.2022

// Задача 1. Написать метод на вход которому подаётся двухмерный строковый массив размером 4x4.
// При подаче массива другого размера необходимо бросить исключение MyArraySizeExeption.

// Задача 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
// Если в каком-то элементе преобразование не удалось (например, если в ячейке лежит символ или текст вместо
// числа), надо бросить исключение MyArrayDataExeption с детализацией, в какой ячейке неверные данные.

// Задача 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException
// и MyArrayDataException и вывести результат расчёта.

package Lesson_2_Exсeption;

public class JavaCore_HWApp {

    public static int[] AdressErrorItem = {0,0};    // Массив для хранения адреса чейки массива 4 x 4 с некорректными данными
    public static int TotalItemArray = 0;           // Переменная типа int для хранения алгебраической суммы элементов массива
    public static boolean ExitInCycle = false;      // Переменная для цикла do ... while при полном переборе массива 4 x 4
    public static int CounterBadItem = 0;           // Переменная для хранения количества "битых" элементов в массиве 4 х 4

    public static void main(String[] args) {

        // 1.Вызов метода functionMyException с невалидным значением по размерности массива
        // для отражения факта генерации исключений (объектов) ArraySizeException
        System.out.println("Пример обработки исключения ArraySizeException для функции functionMyException.\nНевалидные данные по размерности матрицы:");

        // массив матрица 1 х 1:
        String[][] array_1x1 = new String[1][1];
        try {
            // При вызове функции functionMyException c параметром array_5x5 будет создан обект класса ArraySizeException,
            // который будет размещён на вершине стека, если не появится иных ошибок
            functionMyException(array_1x1);     // вызов функции с невалидными данными
        } catch (ArraySizeException myArraySizeException) { // создание объекта класса ArraySizeException
            // вызов метода printStackTrace объекта MyArraySizeException, дочернего по отнонению к классу Exception
            myArraySizeException.printStackTrace();
        }

        // массив вектор 1 х 4:
        String[][] array_1x4 = new String[1][4];
        try {
            // При вызове функции functionMyException c параметром array_3x3 будет создан обект класса ArraySizeExeption,
            // который будет размещён на вершине стека, если не появится иных ошибок
            functionMyException(array_1x4);     // вызов функции с невалидными данными
        } catch (ArraySizeException myArraySizeException) { // создание объекта класса ArraySizeExeption
            // вызов метода printStackTrace объекта MyArraySizeException, дочернего по отнонению к классу Exception
            myArraySizeException.printStackTrace();
        }

        // массив вектор 8 х 2:
        String[][] array_8x2 = new String[8][2];
        try {
            // При вызове функции functionMyException c параметром array_3x3 будет создан обект класса ArraySizeExeption,
            // который будет размещён на вершине стека, если не появится иных ошибок
            functionMyException(array_8x2);     // вызов функции с невалидными данными
        } catch (ArraySizeException myArraySizeException) { // создание объекта класса ArraySizeExeption
            // вызов метода printStackTrace объекта MyArraySizeExeption, дочернего по отнонению к классу Exception
            myArraySizeException.printStackTrace();
        }

        // массив матрица 3 х 3:
        String[][] array_3x3 = new String[3][3];
        try {
            // При вызове функции functionMyException c параметром array_3x3 будет создан обект класса ArraySizeExeption,
            // который будет размещён на вершине стека, если не появится иных ошибок
            functionMyException(array_3x3);     // вызов функции с невалидными данными
        } catch (ArraySizeException myArraySizeException) { // создание объекта класса ArraySizeExeption
            // вызов метода printStackTrace объекта MyArraySizeExeption, дочернего по отнонению к классу Exception
            myArraySizeException.printStackTrace();
        }

        // массив матрица 5 х 5:
        String[][] array_5x5 = new String[5][5];
        try {
            // При вызове функции functionMyException c параметром array_5x5 будет создан обект класса ArraySizeExeption,
            // который будет размещён на вершине стека, если не появится иных ошибок
            functionMyException(array_5x5);     // вызов функции с невалидными данными
        } catch (ArraySizeException myArraySizeException) { // создание объекта класса ArraySizeExeption
            // вызов метода printStackTrace объекта MyArraySizeExeption, дочернего по отнонению к классу Exception
            myArraySizeException.printStackTrace();
        }


        // 2.Вызов метода functionMyException c валидным значением по размерности массива и
        // и валидными данными для отражения факта отсутствия генерации исключений (объектов)
        // типа ArraySizeExeption и ArrayDataExeption
        System.out.println("\nПример обработки исключения ArrayDataExeption для функции functionMyException.\nПолностью валидные данные:");
        String[][] array_4x4_correctData = {{"0", "1", "-1", "2"},
                                            {"6", "-0", "5", "10"},
                                            {"0", "1", "100", "-90"},
                                            {"0", "1", "3", "1"}};
        try {
            CounterBadItem = 0;
            functionMyException(array_4x4_correctData);     // вызов функции с валидными данными
        } catch (ArraySizeException e) {
            System.out.println("Функция отработала некорректно ... \n Содержимое стека:");
            e.printStackTrace();
        } finally {
            System.out.println("Итоговая сумма элементов массива: " + TotalItemArray);
            System.out.println("Количество элементов не преобразованных к типу Integer: " + CounterBadItem);
        }


        // 3.Вызов метода functionMyException c валидным значением по размерности массива и
        // и невалидными данными для отражения факта генерации исключений (объектов)
        // типа ArrayDataExeption
        System.out.println("\nНевалидные числовые данные, полный перебор элементов массива:");
        String[][] array_4x4_uncorrectData = {{"0", "1", "-1", "2"},
                                             {"6", "0x78", "5", "10a"},
                                             {"0", "1", "100", "-90"},
                                             {"0a", "Str", "S3S", "1q"}};

        // Зануление переменных отвечающих за логику обработки исключений ArrayDataExeption
        AdressErrorItem[0] = 0;
        AdressErrorItem[1] = 0;
        TotalItemArray = 0;
        CounterBadItem = 0;
        ExitInCycle = false;

        // Цикл по всем элементам массива (до наступления условия ExitInCycle = true),
        // пока i, j не будут равны len
        do {
            // Обработка исключения (вызов функции до последнего элемента массива)
            // Массив содержит смешанные данные (валидные и невалидные)
            try {
                functionMyException(array_4x4_uncorrectData);
            } catch (ArraySizeException | ArrayDataException MyException) {
                System.out.println("Сгенерировано исключение \"ArrayDataExeption\" с порядковым номером \"" + CounterBadItem + "\" , блок кода отработал корректно... Содержимое стека см. ниже!");
                MyException.printStackTrace();
            } finally {
                System.err.println("Сумма элементов массива: " + TotalItemArray + "\n");
            }
            // -------------------------
            // Блок кода выполняемый только один раз при выходе из цикла
            if (ExitInCycle == true) {
                System.out.println("Итоговая сумма элементов массива: " + TotalItemArray + "\n");
                System.err.println("Итоговая сумма элементов массива: " + TotalItemArray);
                System.err.println("Количество элементов не преобразованных к типу Integer: " + CounterBadItem);
            }
        } while (!ExitInCycle);
    }

    // Исключения (Exсeptions) - объекты, генерируемые во время появления ошибочных ситуаций и содержащие информацию о
    // последних, но в отличии от ошибок (Error), исключения могут быть перехвачены программой, обработаны, что
    // предотвратит завершение работы приложения. Ислючения делятся на две группы:
    // - класс Exсeptions и его подклассы: исключения, которые обязательно должны быть перехвачены программой (checked)
    // - класс RuntimeExсeptions и его продклассы: исключения, охватывающие ситуации такие, как деление на ноль или
    // ошибочная индексация массивов (unchecked)

    // Метод для генерации исключений
    public static void functionMyException(String[][] array) throws ArrayDataException, ArraySizeException {
        // Условие для генерациии исключения по размерности массива
        if ((array.length != 4) || (array[0].length != 4)) {
            // Создание объекта типа ArraySizeException, который является потомком класса Exception
            ArraySizeException myArraySizeException = new ArraySizeException("ArraySizeException: в функцию передан массив размерности " + array.length + " x " + array[0].length + ", что отличается от размерности 4 x 4.");
            // Генерация исключения
            throw myArraySizeException;
        } else {
            // Пример генерации объекта класса ArraySizeExсeption (потомок класса Exception):
            // throw new ArraySizeExсeption("MyArraySizeExсeption: в функцию передан массив размерности равной 4 x 4 ... всё окей на данном этапе!");

            // Создание массива буффера для хранения промежуточных данных
            // выделение памяти под будущий с размерами эквивалентными массиву типа String, передаваемому в виде параметра
            int bufferArrayItem = 0;
            // Хранение признака печати элемента массива и управления логикой вывода промежуточный суммой элементов массива
            boolean printInfoIntegerItem = true;

            // Цикл для копирования данных из массива String в массив Integer c проверкой условия по генерации исключения ArrayDataExeption
            for (int i = AdressErrorItem[0]; i < array.length; i++) {
                for (int j = AdressErrorItem[1]; j < array[i].length; j++) {
                    // блок для обработки исключения NumberFormatException
                    // Если сложилась ситуация с невозможностью преобразования String в Integer,
                    // то есть появилось исключение, то устанавливается флаг printInfoIntegerItem = false
                    try {
                        bufferArrayItem = Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException searchNumberFormatException) {
                        // searchNumberFormatException.printStackTrace();
                        printInfoIntegerItem = false;   // вывод данных об элементе с уточнением информации об адресе элемента
                                                        // (неудачное преобразование к Integer)
                    }

                    // Выввод информации в поток out консоли:
                    // - printInfoIntegerItem = true - об успешном преобразовании элемента
                    // - printInfoIntegerItem = false - о неудачном преобразования элемента и возникшем исключении

                    if (printInfoIntegerItem == true) {
                        // Вывод информации о преобразовании элемента с адресом [i][j] к Integer,
                        // добавление к сумме элементов массива значения из ячейки с адресом [i][j]
                        TotalItemArray += bufferArrayItem;
                        System.out.println("Элемент \"" + array[i][j] + "\" успешно преобразован к типу Integer: " + bufferArrayItem + ". Сумма элементов массива: " + TotalItemArray + ".");
                    } else {
                        // Вывод информации об ошибке при преобразовании элемента с адресом [i][j]
                        System.out.print("Элемент \"" + array[i][j] + "\" - невозможно преобразовать к типу Integer, адресс элемента в массиве: [" + i + "][" + j + "].");
                        System.out.print(" Сумма элементов массива: " + TotalItemArray + ".\n");

                        // Хранение адреса элемента и инкремент счётчика количества "битых" элементов
                        AdressErrorItem[0] = i;     // <- строка
                        AdressErrorItem[1] = j;     // <- столбец
                        CounterBadItem++;           // инкремент счётчика

                        // Расчёт адреса следующего элемента массива до генерации исключения
                        if ((AdressErrorItem[0] <= (array.length - 1)) && (AdressErrorItem[1] < (array[0].length - 1))) {
                            AdressErrorItem[1]++;       // следющий столбец
                        } else if ((AdressErrorItem[0] < (array.length - 1)) && (AdressErrorItem[1] == (array[0].length - 1))) {
                            AdressErrorItem[0]++;       // следющая строка
                            AdressErrorItem[1] = 0;     // первый элемент
                        } else if ((AdressErrorItem[0] == (array.length - 1)) && (AdressErrorItem[1] == (array[0].length - 1))) {
                            ExitInCycle = true;
                        }

                        // Генерация исключения с номером, значением ячейки и адресом
                        throw new ArrayDataException("ArrayDataException №" + CounterBadItem + ": \"" + array[i][j] + "\" - невозможно преобразовать к типу Integer, адресс элемента в массиве: [" + i + "][" + j + "]");
                    }

                    // Установка переменной printInfoIntegerItem в исходное состояние
                    printInfoIntegerItem = true;
                }
            }
        }
    }
}