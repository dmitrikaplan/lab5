package AppIO

import Exceptions.CommandException
import kotlin.system.exitProcess


/**
 * Класс для обработки команд, введенных пользователем
 * и дальнейшего выполнения их
 */
class CommandFinder{

    private val commandManager : CommandManager
    private val collectionManager : CollectionManager;

    constructor(commandManager: CommandManager, collectionManager: CollectionManager) {

        this.commandManager = commandManager;
        this.collectionManager = collectionManager;
        println("Справка по всем доступным командам :")
        commandManager.help();

    }



    /**
     * Функция обработки текста, который ввел пользователь
     * @throws NullPointerException если пользователь ничего не ввел
     * @throws CommandException команда состоит больше, чем их двух слов
     */
    fun commandSearcher(){

        while(true){

            try{

            val userCommand = readLine()!!.split(" ").toList()

                if(userCommand.size > 2) throw CommandException()
                userCommand.forEach { it.trim() }
                commandManager.addToHistory(userCommand[0]);

                launchCommand(userCommand);

            }catch (e : NullPointerException){
                println("Ошибка ввода");
            }catch (e : CommandException){
                println("команда не распознана")
            }
        }
    }



    private fun scriptMode(fileName: String){

        val list = commandManager.executeScript(fileName);
        var i = 0;
        while(i < list.size){

            val localList = list[i].split(' ')
            if(localList[0] in commandManager.getCommandsString()){


                when{

                   localList[0] == "add" && localList.size == 1-> {
                        collectionManager.add(list.subList(i + 1, i + 12));
                        i += 12;
                    };

                    localList[0] == "update" && localList.size == 2 -> {

                        collectionManager.update(localList[1],list.subList(i + 1, i + 12))
                        i += 12;

                    }

                    else ->{
                        launchCommand(localList)
                        i += 1;
                    }
                }
            }
        }
    }

    /**
     * Функция выбора команды по введенному тексту
     * @param userCommand коллекция слов, введенных пользователем
     */
    private fun launchCommand(userCommand: List<String>){

        when{

            userCommand.size == 1 && userCommand[0] == "help" -> commandManager.help()

            userCommand.size == 1 && userCommand[0] == "info" -> collectionManager.info()

            userCommand.size == 1 && userCommand[0] == "show" -> collectionManager.show()

            userCommand.size == 1 && userCommand[0] == "add" -> collectionManager.add()

            userCommand.size == 2 && userCommand[0] == "update" -> collectionManager.update(userCommand[1])

            userCommand.size == 2 && userCommand[0] == "remove_by_id" -> collectionManager.remove(userCommand[1])

            userCommand.size == 1 && userCommand[0] == "clear" -> collectionManager.clear()

            userCommand.size == 1 && userCommand[0] == "save" -> collectionManager.save()

            userCommand.size == 2 && userCommand[0] == "execute_script" ->{
                scriptMode(userCommand[1]);
            }

            userCommand.size == 1 && userCommand[0] == "exit" -> {
                println("Программа завершена");
                exitProcess(0);
            }

            userCommand.size == 1 && userCommand[0] == "remove_first" -> collectionManager.removeFirst()

            userCommand.size == 2 && userCommand[0] == "remove_greater" -> collectionManager.removeGreater(userCommand[1]);

            userCommand.size == 1 && userCommand[0] == "history" -> commandManager.history();

            userCommand.size == 2 && userCommand[0] == "remove_all_by_description" -> collectionManager.removeAllByDescription(userCommand[1]);

            userCommand.size == 2 && userCommand[0] == "count_less_than_number_of_participants" -> collectionManager.countLessThan(userCommand[1]);

            userCommand.size == 1 && userCommand[0] == "print_field_descending_front_man" -> collectionManager.printlnFrontManDescending();

            else -> println("Команда не найдена")


            }
        }


}



