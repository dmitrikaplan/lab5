package JavaClasses;

import java.util.UUID;

public class Person {

    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer height; //Поле может быть null, Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Поле может быть null
    private Location location; //Поле не может быть null
    private static int id = 0;

    public Person(String name, Integer height, Location location){

        this.name = name;
        this.height = height;
        this.passportID = UUID.randomUUID().toString();
        this.location = location;


    }


    @Override
    public String toString(){

        return "\nИмя : " + name +
                "\nРост : "+ height +
                "\nID паспорта : " + passportID +
                "\nМестоположение : " + location;

    }


}

