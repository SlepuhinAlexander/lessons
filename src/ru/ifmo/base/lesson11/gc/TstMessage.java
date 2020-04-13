package ru.ifmo.base.lesson11.gc;

public class TstMessage {

    public static void main(String[] args) {
        String data = "Срочное сообщение";
        int num = 10;

        printStart();

        Message message = new Message();
        message.setText(data);
        message.setCode(num);

    }

    private static void printStart(){
        System.out.println("START");
        // объект типа Message создается в heap памяти
        Message message = new Message();
        // еще один объект типа Message создается в heap памяти
        message = new Message();
        // обнуление ссылки (не удаление объекта)
        message = null;
    }
}
