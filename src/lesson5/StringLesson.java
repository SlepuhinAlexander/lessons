package lesson5;

import java.util.Arrays;

public class StringLesson {
    public static void main(String[] args) {
        // Строки - ссылочный тип данных
        // Строки до 9 Java
        char charVar = 'e';
        String someStr = "jjd";

        char[] chars = {'j', 'j', 'd'};
        // строки хранятся как массив char
        // в кодировке UTF-16
        // каждый символ занимает 2 байта

        // Строки (компактные строки) с 9 Java
        // строки хранятся как массив byte[]
        // UTF-16
        // LATIN-1

        String string = "Some string";
        String string4 = "Some string";
        String string2 = new String("Some string");
        String string3 = new String("Some string");

        // сравнение строк
        System.out.println(string == string4);
        System.out.println(string2 == string3);

        System.out.println(string2.equals(string3));

        String newString = new String("new");
        String newString2 = newString.intern();

        System.out.println(string2 == string3);
        System.out.println(string2.intern() == string3.intern());
        System.out.println(string2 == string3);

        // Строки неизменны и потокобезопасны

        // Конкатенация строк
        String str1 = "строка 1";
        String str2 = "строка 2";
        String str3 = "строка 3";

        str1 = str1 + str2;
        System.out.println(str1);

        str2 = str2.concat(str3)
                .concat("Hello")
                .concat("STR");

        System.out.println("Some Data");

        str3 = String.join(" :: ", str1, str2, str3);
        System.out.println(str3);

        str1 = "Строка ";
        for (int i = 0; i < 10; i++) {
            str1 += " итерация " + i;
        }
        System.out.println(str1);

        // возможность изменять строки дают объекты
        // StringBuilder или StringBuffer
        // StringBuilder - работает быстрее, но непотокобезопасен
        // StringBuffer - работает медленнее, но потокобезопасен

        str1 = "Строка ";
//        StringBuilder sb = new StringBuilder(str1);
        StringBuilder sb = new StringBuilder();
        sb.append(str1).append("Hello");

        for (int i = 0; i < 10; i++) {
            sb.append(" итерация ").append(i);
        }
        str1 = sb.toString();
        System.out.println(str1);


        char[] charsArr = {'q', 'w', 'e'};
        String charStr = new String(charsArr);

        byte[] bytes = charStr.getBytes();
        System.out.println(bytes.toString());
        System.out.println(Arrays.toString(bytes));

        charStr = new String(bytes);

        // сравнение
        str1 = "Java";
        str2 = "java";

        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));

        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareToIgnoreCase(str2));
        System.out.println(str2.compareToIgnoreCase(str1));

        str1 = "Java";
        System.out.println(str1.startsWith("Ja"));
        System.out.println(str1.endsWith("A"));

        str1 = str1.toLowerCase();
        System.out.println(str1);
        str1 = str1.toUpperCase();
        System.out.println(str1);

        str1 = "    Стр c  ";
        System.out.println(str1.length());
        System.out.println(str1.trim().length());
        System.out.println(str1.trim());

        str1 = "Java";
        str1 = str1.replace("a", "AA");
//        System.out.println(str1.replace("a", "AA"));

        str1 = "Java Junior";
        String[] strings = str1.split("\\s");
        System.out.println(Arrays.toString(strings));

    }
}
