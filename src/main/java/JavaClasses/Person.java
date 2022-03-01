package JavaClasses;

import java.util.UUID;

public class Person {

    private String name; //���� �� ����� ���� null, ������ �� ����� ���� ������
    private Integer height; //���� ����� ���� null, �������� ���� ������ ���� ������ 0
    private String passportID; //�������� ����� ���� ������ ���� ����������, ���� ����� ���� null
    private Location location; //���� �� ����� ���� null
    private static int id = 0;

    public Person(String name, Integer height, Location location){

        this.name = name;
        this.height = height;
        this.passportID = UUID.randomUUID().toString();
        this.location = location;


    }


    @Override
    public String toString(){

        return "\n��� : " + name +
                "\n���� : "+ height +
                "\nID �������� : " + passportID +
                "\n�������������� : " + location;

    }


}

