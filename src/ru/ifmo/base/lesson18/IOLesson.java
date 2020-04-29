package ru.ifmo.base.lesson18;

import java.io.*;

public class IOLesson {

    public static void main(String[] args) {
        // IO API (java.io)
        // передачу данных в программу и из программы

        // IO API предоставляет возможности по передече данных
        // в виде последовательности byte
        // или последовательности char

        // IO не единственная возможность передачи данных!
        // аналогичную возможность предоставляет пакет nio

        // методами класса File можно создавать/удалять
        // файлы/директории, приверять наличие файла,
        // получать тип файла и тд
        File file = new File("sources/filepath.txt");

        try {
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // возвращает абсолютный путь
        System.out.println(file.getAbsolutePath());
        // возвращает относительный путь (относительно корня)
        System.out.println(file.getPath());
        // проверка на директорю
        System.out.println(file.isDirectory());
        // проверка на файл
        System.out.println(file.isFile());
        // доступен ли для чтения
        System.out.println(file.canRead());
        // доступен ли для записи
        System.out.println(file.canWrite());
        // размер в байтах
        System.out.println(file.length());

        // если даные передаются из программы в виде
        // последовательности байт, то мы будем работать
        // с OutputStream
        // ресурс <---- java app
        // если даные передаются в программу в виде
        // последовательности байт, то мы будем работать
        // с InputStream
        // ресурс ----> java app

        try {
            writeToFile(file, "hello", false);
            writeToFileWithBuffer(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static
     void writeToFile(File file, String data, boolean append)
                                                throws IOException {
        // строка data должна быть записана в файл file
        // если append - true - запись в конец файла
        // если append - false - запись в начало файла
        // try-with-resources - доступен, начиная с 7 java
        // file <---------  java app
        try (FileOutputStream fileOutput = new FileOutputStream(file, append)){
            byte[] bytes = data.getBytes();
            fileOutput.write(bytes);
        }
    }

    private static void writeToFileWithBuffer(File file) throws IOException {
        // file <---- [buffer] <----  java app
        try (FileOutputStream fileOutput = new FileOutputStream(file);
             BufferedOutputStream bufferOut = new BufferedOutputStream(fileOutput)){
            // размер буфера по умолчанию 8192 байта, размер буфера можно
            // установить через констркутор new BufferedOutputStream(fileOutput, size)

            // задача FileOutputStream - запись в файл

            for (int i = 0; i < 1_000_000; i++) {
                bufferOut.write((i + " ").getBytes());
            }
        }
    }


}


