import Modules.ModuleOfCollectionManager
import Modules.ModuleOfCommandFinder
import Modules.ModuleOfCommandManager
import Modules.ModuleOfFileManager
import commands.*

fun main(){

    /**
     * @author Dmitry Kaplan P3112
     * Лабораторная работа №5 по программированию
     * Главная функция, которая вызывает остальные классы
     */
    val outputData = "outputData";

    val moduleOfFileManager = ModuleOfFileManager(outputData)
    val moduleCollectionManager = ModuleOfCollectionManager(moduleOfFileManager);
    val moduleOfCommandManager = ModuleOfCommandManager(
        moduleCollectionManager,
        moduleOfFileManager,
        HelpCommand(),
        AddCommand(),
        ClearCommand(),
        CountCommand(),
        ExecuteScriptCommand(),
        HistoryCommand(),
        InfoCommand(),
        PrintFieldCommand(),
        RemoveAllCommand(),
        RemoveByID(),
        RemoveFirstCommand(),
        RemoveGreaterCommand(),
        SaveCommand(),
        ShowCommand(),
        UpdateIDCommand(),
        ExitCommand(),
    )
    val collectionManager = moduleCollectionManager.collectionManager();
    val moduleOfCommandFinder = ModuleOfCommandFinder(moduleOfCommandManager, collectionManager)


    val commandFinder = moduleOfCommandFinder.commandFinder();
    collectionManager.addFileCommandsToCollection();
    commandFinder.commandSearcher();

}
