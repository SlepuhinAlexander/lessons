package ru.ifmo.base.lesson18;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;

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
//            writeToFileWithBuffer(file);
            readFromFileToByteArray(file);

            byte[] bytes =
                    imgToByteArray(new File("sources/marshmallow.jpg"));
            byteArrayToImage(new File("sources/new.png"), bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void writeToFile(File file, String data, boolean append)
            throws IOException {
        // строка data должна быть записана в файл file
        // если append - true - запись в конец файла
        // если append - false - запись в начало файла
        // try-with-resources - доступен, начиная с 7 java
        // file <---------  java app
        try (FileOutputStream fileOutput = new FileOutputStream(file, append)) {
            byte[] bytes = data.getBytes();
            fileOutput.write(bytes);
        }
    }

    private static void writeToFileWithBuffer(File file) throws IOException {
        // file <---- [buffer] <----  java app
        try (FileOutputStream fileOutput = new FileOutputStream(file);
             BufferedOutputStream bufferOut = new BufferedOutputStream(fileOutput)) {
            // размер буфера по умолчанию 8192 байта, размер буфера можно
            // установить через констркутор new BufferedOutputStream(fileOutput, size)

            // задача FileOutputStream - запись в файл
            // задача BufferedOutputStream - накапливать данные в буфер
            // после того, как буфер заполнится, объект BufferedOutputStream
            // вызывает метод write у того объекта типа OutputStream, который
            // был передан в конструктор,
            // в данном случае у объекта fileOutput и уже объект fileOutput
            // осуществляет запись данных в файл

            // BufferedOutputStream - декоратор (обертка, дополнительный функционал)
            // для любого OutputStream

            for (int i = 0; i < 1_000_000; i++) {
                bufferOut.write((i + " ").getBytes());
            }
        }
    }

    public static String readFromFileToByteArray(File file)
            throws IOException {
        String string = null;

        try (FileInputStream fileInput = new FileInputStream(file);
             ByteArrayOutputStream arrOut = new ByteArrayOutputStream()) {

            byte[] buf = new byte[512]; // 10 20

            int data;
            while ((data = fileInput.read(buf)) > 0) {
                System.out.println(data);
                System.out.println(Arrays.toString(buf));
                arrOut.write(buf, 0, data);
                System.out.println(Arrays.toString(arrOut.toByteArray()));
            }
            // arrOut.toString()
            string = new String(arrOut.toByteArray());

        }

        return string;
    }


    public static byte[] imgToByteArray(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(image, "png", output);
        return output.toByteArray();
    }

    public static boolean byteArrayToImage(File file, byte[] bytes)
            throws IOException {
        try (ByteArrayInputStream input = new ByteArrayInputStream(bytes)) {
            BufferedImage image = ImageIO.read(input);
            return ImageIO.write(image, "png", file);
        }

        // RandomAccessFile r;
        // передача char - Reader / Writer
    }

    private static String readFromSeveralFiles(File... files)
            throws IOException {
        String string = null;

        try (FileInputStream i1 = new FileInputStream(files[0]);
             FileInputStream i2 = new FileInputStream(files[2]);
             ByteArrayOutputStream bout = new ByteArrayOutputStream()) {

            // если InputStream больше 2х:
//            InputStream stream1 = new FileInputStream("file1.txt");
//            InputStream stream2 = new FileInputStream("file2.txt");
//            InputStream stream3 = new FileInputStream("file3.txt");
//            InputStream stream4 = new FileInputStream("file4.txt");

            // собираем их в Vector
//            Vector<InputStream> sequence = new Vector<>();
//            sequence.add(stream1);
//            sequence.add(stream2);
//            sequence.add(stream3);
//            sequence.add(stream4);

            // передаем в конструктор vector.elements()
//            SequenceInputStream sequenceInputStream =
//                      new SequenceInputStream(sequence.elements());

            SequenceInputStream stream = new SequenceInputStream(i1, i2);

            byte[] bytes = new byte[512];
            int data;
            while ((data = stream.read(bytes)) > 0) {
                bout.write(bytes, 0, data);
            }

            string = bout.toString();

        }
        return string;
    }

    private static void writeReadData(File file) throws IOException {
        try (FileOutputStream fileOutput = new FileOutputStream(file);
             DataOutputStream dataOutput = new DataOutputStream(fileOutput)) {

            // задача DataOutputStream - преобразовать данные в байты,
            // вызвать метод write у объекта OutputStream и передать
            // в него этот набор байт
            // в данном случае метод write FileOutputStream
            dataOutput.writeBoolean(true);
            dataOutput.writeBoolean(false);
            dataOutput.writeDouble(6.555);
            dataOutput.writeInt(34);
            dataOutput.writeUTF("hello");
        }

        try (FileInputStream fileInput = new FileInputStream(file);
             DataInputStream dataInput = new DataInputStream(fileInput)) {

            System.out.println(dataInput.readBoolean());
            System.out.println(dataInput.readBoolean());
            System.out.println(dataInput.readDouble());
            System.out.println(dataInput.readInt());
            System.out.println(dataInput.readUTF());
        }

    }


}


