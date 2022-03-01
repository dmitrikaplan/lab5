package JavaClasses;

import java.time.LocalDate;


public class MusicBand {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long numberOfParticipants; //Поле не может быть null, Значение поля должно быть больше 0
    private String description; //Поле не может быть null
    private MusicGenre genre; //Поле может быть null
    private Person frontMan; //Поле не может быть null
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

        return "Id группы : " + id +
                "\nНазвание группы : " + name +
                "\nДата создания элемента : " +  creationDate.toString() +
                "\nКоординаты местоположения группы : " + coordinates.toString() +
                "\nКоличество участников : " + numberOfParticipants +
                "\nОписание группы : " + description +
                "\nМузыкальный жанр : " + genre.toString() +
                "\nСолист : " + frontMan;
    }
}
