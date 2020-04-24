package ru.ifmo.base.lesson16.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

@ClassConfig(prefix = "test", version = 22)
public class TestAnnotations {
    @Required
    private String stringData;

    public String getStringData() {
        return stringData;
    }

    public void setStringData(String stringData) {
        this.stringData = stringData;
    }

    @Override
    public String toString() {
        return "TestAnnotations{" +
                "stringData='" + stringData + '\'' +
                '}';
    }

    public static void main(String[] args) {

        Class testClass = TestAnnotations.class;
        // получим все аннотации класса
        Annotation[] annotations = testClass.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        // проверим наличие аннотации
        if (testClass.isAnnotationPresent(ClassConfig.class)){
            System.out.println("ClassConfig");
            // получим ссылку на аннотацию
            ClassConfig classConfig = (ClassConfig) testClass
                    .getDeclaredAnnotation(ClassConfig.class);
            // получим значения prefix и version
            System.out.println(classConfig.prefix());
            System.out.println(classConfig.version());
        }

        // получим аннотации полей класса
        Field[] fields = testClass.getDeclaredFields();
        for (Field field: fields){
            Annotation[] fieldAnnotations =
                    field.getDeclaredAnnotations();
            System.out.println(Arrays.toString(fieldAnnotations));
            if (field.isAnnotationPresent(Required.class)){
                System.out.println("поле с Required");
            }
        }

        // ДЗ к понедельнику
        // выбрать наиболее важные (интересные) на Ваш взгляд! методы
        // Class
        // Field
        // Method
        // Modifier

        // 1. написать рефлексивный статический static toString(Object o)
        // вывести информацию по полям объекта, используя рефлексию:
        // название поля: значение поля
//        примитивы / строки
    //        age: 67
    //        login: qwe
//        User user
//        user : @hashCode
//        int[] data
//        data: @hashCode

        // 2. если класс аннотирован аннотацией ConfigClass,
        // создать объект данного класса (использовать рефлексию!)
        // если поле отмечено аннотацией @Required - установить значение
        // данного поля (значение любое!)
        // значение поля установить через сеттер!!!
        // stringData / setStringData
        // field.getName()
        // field.getType()
        // у созданного объекта вызвать метод public String toString(),
        // используя рефлексию

    }

}
