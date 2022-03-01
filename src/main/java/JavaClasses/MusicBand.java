package JavaClasses;

import java.time.LocalDate;


public class MusicBand {
    private int id; //�������� ���� ������ ���� ������ 0, �������� ����� ���� ������ ���� ����������, �������� ����� ���� ������ �������������� �������������
    private String name; //���� �� ����� ���� null, ������ �� ����� ���� ������
    private Coordinates coordinates; //���� �� ����� ���� null
    private java.time.LocalDate creationDate; //���� �� ����� ���� null, �������� ����� ���� ������ �������������� �������������
    private Long numberOfParticipants; //���� �� ����� ���� null, �������� ���� ������ ���� ������ 0
    private String description; //���� �� ����� ���� null
    private MusicGenre genre; //���� ����� ���� null
    private Person frontMan; //���� �� ����� ���� null
    private static int counter = 1;

   public MusicBand(String name, Coordinates coordinates, Long numberOfParticipants,
              String description, MusicGenre genre, Person frontMan){

        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDate.now();
        this.numberOfParticipants = numberOfParticipants;
        this.description = description;
        this.genre = genre;
        this.frontMan = frontMan;
        id = counter++;

    }

    public static void setId(int id){

       counter = id;

    }


    public int getId(){

        return id;
    }

    public String getName(){

        return name;

    }

    public String getDescription(){

        return description;

    }

    public Long getNumberOfParticipants(){

        return numberOfParticipants;

    }


    public Person getFrontMan(){

        return frontMan;

    }


    @Override
    public String toString(){

        return "Id ������ : " + id +
                "\n�������� ������ : " + name +
                "\n���� �������� �������� : " +  creationDate.toString() +
                "\n���������� �������������� ������ : " + coordinates.toString() +
                "\n���������� ���������� : " + numberOfParticipants +
                "\n�������� ������ : " + description +
                "\n����������� ���� : " + genre.toString() +
                "\n������ : " + frontMan;
    }
}
