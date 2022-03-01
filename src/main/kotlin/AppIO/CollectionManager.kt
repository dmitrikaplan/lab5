package AppIO

import JavaClasses.MusicBand
import java.time.LocalDateTime
import java.util.*
import kotlin.math.max

/**
 * Класс для работы с коллекцией музыкальных групп
 * @param lastSaveTime время последнего сохранения коллекции в файл
 * @param lastInitTime время последнего создания элемента коллекции
 */
class CollectionManager(private val fileManager: FileManager, private val inputData : InputData) {

    private var collectionOfMusicBands: MutableList<MusicBand> = LinkedList();
    private lateinit var lastSaveTime: LocalDateTime;
    private lateinit var lastInitTime: LocalDateTime;


    fun update(id: String, list: List<String> = listOf()) {

        try {

            val newId = id.toInt()
            for (i in collectionOfMusicBands.indices) {

                if (collectionOfMusicBands[i].id == newId) {

                    if(list.isEmpty()){

                        collectionOfMusicBands[i] = inputData.askMusicBand()!!;
                        break;

                    }
                    else {

                        val localParam = inputData.askMusicBand(list)
                        if(localParam != null)
                        collectionOfMusicBands[i] = localParam;
                    };
                    collectionOfMusicBands.sortBy { it.name }
                }
            }
        } catch (e : NumberFormatException) {
            println("Данная строка не является числом")
        }catch (e : IllegalArgumentException) {
            println("Данная строка не является числом")
        }catch (e : NullPointerException){
            println("")
        }
}

    fun addFileCommandsToCollection(){

        val collection = fileManager.collectionReader("bootData");
        var mx = 0;
        collection.forEach {
            mx = max(it.id, mx)
            collectionOfMusicBands.add(it)
        }
        MusicBand.setId(mx + 1)
        collectionOfMusicBands.sortBy { it.name }
        lastInitTime = LocalDateTime.now();



    }

    fun info(){

        try {
            println(
                "Date of init : $lastInitTime\n" +
                        "Date of last save : $lastSaveTime\n" +
                        "Type : ${collectionOfMusicBands::class.simpleName}\n" +
                        "Count of elements : ${collectionOfMusicBands.size}\n"
            )
        }
        catch (e : UninitializedPropertyAccessException){

            try{
                println(
                    "Date of init : $lastInitTime\n" +
                            "Date of last save : the collection wasn't saved to a file\n" +
                            "Type : ${collectionOfMusicBands::class.simpleName}\n" +
                            "Count of elements : ${collectionOfMusicBands.size}\n"
                )
            }
            catch (e : UninitializedPropertyAccessException){
                println(
                    "Date of init : the collection is empty\n" +
                            "Date of last save : the collection wasn't saved to a file\n" +
                            "Type : ${collectionOfMusicBands::class.simpleName}\n" +
                            "Count of elements : ${collectionOfMusicBands.size}\n"
                )
            }

        }

    }

    fun show(){

        if (collectionOfMusicBands.size > 0) {
            collectionOfMusicBands.forEach {
                println(it.toString())
            println()
            }
        }
        else println("Коллекция пуста")

    }

    fun add(list : List<String> = listOf()){

        val musicBand = inputData.askMusicBand(list);

        if(musicBand != null)
            collectionOfMusicBands.add(musicBand);
            collectionOfMusicBands.sortBy { it.name }
            lastInitTime = LocalDateTime.now();

    }

    fun clear(){

        collectionOfMusicBands.removeAll(collectionOfMusicBands);
        println("Коллекция очищена")

    }

    fun remove(id : String){

        try {

            val newId = id.toInt()
            if(newId < collectionOfMusicBands.size - 1) {

                for (i in collectionOfMusicBands.indices) {

                    if (collectionOfMusicBands[i].id == newId) {

                        collectionOfMusicBands.remove(collectionOfMusicBands[i])
                        println("Элемент удален")
                        break;
                    }
                }
            } else println("Id не найден")

        } catch (e : NumberFormatException){
            println("Данная строка не является числом")
        }catch (e : IllegalArgumentException){
            println("Данная строка не является числом")
        }
    }

    fun save(){

        fileManager.collectionWriter(collectionOfMusicBands);
        lastSaveTime = LocalDateTime.now();


    }


    fun removeFirst(){

        if(collectionOfMusicBands.size > 0) {

            collectionOfMusicBands.remove(collectionOfMusicBands[0]);
            println("Первый элемент удален");

        }
        else println("Невозможно удалить первый элемент - коллекция пуста")

    }

    fun removeAllByDescription(description : String){

        var cnt = 0;

        try {
            for (i in collectionOfMusicBands.indices) {

                if (collectionOfMusicBands[i].description.equals(description)) {

                    collectionOfMusicBands.remove(collectionOfMusicBands[i]);
                    cnt++

                }
            }
        }catch (e : IndexOutOfBoundsException){
        }


        when{

            cnt == 0 -> println("Элемент по описанию не найден");

            cnt == 1 -> println("Элемент удален");

            cnt >= 2 -> println("Элементы удалены");

        }
    }


    fun removeGreater(name : String){

            try {

                for(i in collectionOfMusicBands.indices) {


                    if (collectionOfMusicBands[i].name == name) {

                        collectionOfMusicBands = collectionOfMusicBands.subList(0, i + 1);
                        println("Элемент удален")
                        break;
                    }

                    if(i == collectionOfMusicBands.size - 1) println("Элемент не найден")
                }

            }catch (e : NullPointerException){
                println("Ошибка при вводе имени")
            }
    }



    fun countLessThan(numberOfParticipants : String){

        try {

            val newNumber = numberOfParticipants.toLong();
            var cnt : Int = 0;
            for(i in collectionOfMusicBands.indices){

                if(collectionOfMusicBands[i].numberOfParticipants < newNumber){

                    cnt++;
                }
            }
            println(cnt)
        }catch (e : NumberFormatException){
            println("Данная строка не является числом")
        }catch (e : IllegalArgumentException){
            println("Данная строка не является числом")
        }
    }

    fun printlnFrontManDescending(){

        val newCollection = collectionOfMusicBands.asReversed();
        for(i in newCollection.indices){

            println(newCollection[i].frontMan.toString())

        }
    }

}
