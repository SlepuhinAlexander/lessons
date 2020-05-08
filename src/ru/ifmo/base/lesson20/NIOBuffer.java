package ru.ifmo.base.lesson20;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

public class NIOBuffer {
    public static void main(String[] args) {
        // включить assert VM options -ea

        //Java NIO (New IO / Non-blocking IO) - предназначенн для работы с вводом-выводм.
        // Каналы, Буферы, Селекторы
        // Неблокирующий
        // Асинхронный
        // Буфер-ориентированный

        //Каналы:
        // канал может быть использован и для записи и для чтения
        // чтение и запись может происходить асинхронно
        // каналы всегда пишут в буфер и читают из буфера
        // Каналы могут быть созданы на основе:
        // - FileChannel - работа с файлами
        // - DatagramChannel - udp протокол
        // - SocketChannel - tcp протокол
        // - ServerSocketChannel

        // Буферы могут быть:
        // ByteBuffer
        // CharBuffer
        // DoubleBuffer
        // FloatBuffer
        // IntBuffer
        // LongBuffer
        // ShortBuffer

        // свойсва буфера:
        // capacity - емкость (не меняется после установки)
        // position - текущая позиция в буфере (изначально 0)
        // limit - до какого значения можно читать/писать данные (изначально равен capacity)

        //IntBuffer intBuffer = IntBuffer.allocate(33); // new int[33]
        //CharBuffer charBuffer = CharBuffer.allocate(33); // new char[33]

        ByteBuffer buffer = ByteBuffer.allocate(16);
        assert buffer.position() == 0;
        assert buffer.capacity() == 16;
        assert buffer.limit() == 16;
        assert buffer.remaining() == 16; // разница между position и limit

        // buffer.position(0); // установить позицию в 0
        // buffer.limit(6); // установить лимит на 6

        // Увеличивает позицию на 4.
        buffer.putInt(100);

        assert buffer.position() == 4;
        assert buffer.remaining() == 12;

        // Увеличивает позицию на 8.
        buffer.putDouble(100.25);

        assert buffer.position() == 12;
        assert buffer.remaining() == 4;

        // Устанавливает лимит на место позиции,
        // сбрасывает позицию в 0 (для чтения из буфера)
        buffer.flip();

        assert buffer.limit() == 12;
        assert buffer.position() == 0;
        assert buffer.remaining() == 12;

        // Увеличивает позицию на 4.
        int anInt = buffer.getInt();

        assert buffer.position() == 4;
        assert buffer.remaining() == 8;

        // Увеличивает позицию на 8.
        double aDouble = buffer.getDouble();

        assert buffer.position() == 12; // buffer.limit() == 12;
        assert buffer.remaining() == 0;

        // Сбрасывает позицию в 0
        // (limit остается на прежнем месте - для повторного чтения)
        buffer.rewind();

        assert buffer.position() == 0;
        assert buffer.limit() == 12;
        assert buffer.remaining() == 12;

        // Увеличивает позицию на 4.
        assert anInt == buffer.getInt();
        // Увеличивает позицию на 8.
        assert aDouble == buffer.getDouble();

        // Сбрасывает позицию в 0, ставит лимит, равный емкости буфера (для записи в буфер)
        buffer.clear();

        assert buffer.position() == 0;
        assert buffer.capacity() == 16;
        assert buffer.limit() == 16;
        assert buffer.remaining() == 16;

        // копирует все непрочитанные данные в начало буфера.
        // Лимит равен емкости буфера
        // (для записи в буфер после непрочитанных данных)
        // buffer.compact();








    }
}