package ru.ifmo.base.lesson13;

// в <> необходимо указать, что в классе будет использоваться generic тип
// (вместо T может быть любая буква или их сочетание
public class User<T> {  // класс User + геттеры и сеттеры + toString
    // если нужна возможность определить тип данных поля в момент создания объекта,
    // то используем generic тип
    private T id;
    private String login;
    private String pwd;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
