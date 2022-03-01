package AppIO

import commands.*


/**
 * Класс для работы с командами, введенными пользователем
 * Хранит все команды и историю последних 6 введенных команд
 */
class CommandManager(
    private val helpCommand: HelpCommand,
    private val addCommand: AddCommand,
    private val clearCommand: ClearCommand,
    private val countCommand: CountCommand,
    private val executeScriptCommand: ExecuteScriptCommand,
    private val historyCommand: HistoryCommand,
    private val infoCommand: InfoCommand,
    private val printFieldCommand: PrintFieldCommand,
    private val removeAllCommand: RemoveAllCommand,
    private val removeByID: RemoveByID,
    private val removeFirstCommand: RemoveFirstCommand,
    private val removeGreaterCommand: RemoveGreaterCommand,
    private val saveCommand: SaveCommand,
    private val showCommand: ShowCommand,
    private val updateIDCommand: UpdateIDCommand,
    private val exitCommand : ExitCommand,
    private val collectionManager: CollectionManager,
    private val fileManager: FileManager
) {

    private val MAXLENGTH = 6;
    private var commands : MutableList<Command> = mutableListOf();
    private var commandsHistory : MutableList<String> = mutableListOf();


    init {
        commands.add(helpCommand)
        commands.add(addCommand)
        commands.add(clearCommand)
        commands.add(countCommand)
        commands.add(executeScriptCommand)
        commands.add(historyCommand)
        commands.add(infoCommand)
        commands.add(printFieldCommand)
        commands.add(removeAllCommand)
        commands.add(removeByID)
        commands.add(removeFirstCommand)
        commands.add(removeGreaterCommand)
        commands.add(saveCommand)
        commands.add(showCommand)
        commands.add(updateIDCommand)
        commands.add(exitCommand)
    }


    fun addToHistory(command : String){

            if(commandsHistory.size == 6) {

                commandsHistory = commandsHistory.subList(1, MAXLENGTH)
                commandsHistory.add(command);

            }
            else commandsHistory.add(command);

    }

    fun getCommandsString() : MutableList<String>{

        val commandsString = mutableListOf<String>();
        for(i in commands.indices){

            commandsString.add(commands[i].getNameCommand().split(' ')[0])

        }

        return commandsString;

    }

    fun help(){


            for(i in commands.indices){

                println(commands[i].toString())

        }
    }


    fun executeScript(fileName : String) : List<String>{

        return fileManager.scripReader(fileName);

    }


    fun history(){

        commandsHistory.forEach{ println(it)}

    }

}
