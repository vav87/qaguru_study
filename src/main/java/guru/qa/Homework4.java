package guru.qa;

public class Homework4 {
    public static void main(String[] args) {

//  диапазоны типов данных для вещественных чисел
        float minFloat = Float.MIN_VALUE;
        float maxFloat = Float.MAX_VALUE;
        double minDouble = Double.MIN_VALUE;
        double maxDouble = Double.MAX_VALUE;

        System.out.println("minFloat = " + minFloat);
        System.out.println("maxFloat = " + maxFloat);
        System.out.println("minDouble = " + minDouble);
        System.out.println("maxDouble = " + maxDouble);

//  переполнения при вычислениях

        char maxChar = 65535;
//        char maxCharPlusOne = 65535 + 1;  // <- ошибка компиляции
        char newChar = (char)(maxChar + 1); // <- непредсказуемый результат
        System.out.println("newChar = " + newChar);

//        byte maxBytePlusOne = 128; // <- ошибка компиляции
        byte newByte = (byte)128;  // <- -128
        byte newByte2 = (byte)138;  // <- -118
        System.out.println("newByte2 = " + newByte2);

//        short maxShortPlusOne = 32768; // <- ошибка компиляции
        short newShort = (short)32768;  // <- -32768
        System.out.println("newShort = " + newShort);

//        int maxIntPlusOne =  2147483648; // <- ошибка компиляции
//        int newInt = (int)2147483648; // <- ошибка компиляции

        long newLong = 2147483648L; // <- суффикс L обязателен при значениях больше максимального int

        double infinity = maxDouble/0.0;  // <- Infinity
        System.out.println("infinity = " + infinity);

//  вычисления комбинаций типов данных (int и double)

        int int1 = 10;
        double double1 = 15;
//        int sum1 = int1 + double1; //  <- ошибка компиляции
        double sum2 = int1 + double1;
        System.out.println("sum2 = "+ sum2); //<- 25.0
    }
}
