package ru.ifmo.base.lesson12;
// если необходимо создать собственное необрабатываемое исключение,
// то класс исключения должен наследоваться от RuntimeException

// если необходимо создать собственное обрабатываемое исключение,
// то класс исключения должен наследоваться от Exception
public class ChatException extends Exception{
    // можем создавать необходимые свойства и методы

    public ChatException(String message) {
        super(message);
    }

    // можем переопределять методы родителя (расширять их или
    // использовать свою реализацию)
    @Override
    public String getMessage() {
        return super.getMessage() + " Следите за кодом!!!";
    }
}
