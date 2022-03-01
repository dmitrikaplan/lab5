package commands


/**
 * Класс, представляющий собой команду, которая
 * считывает и исполняет скрипт из указанного файла.
 */
class ExecuteScriptCommand : Command {

    constructor()
            : super("execute_script file_name", "считывает и исполняет скрипт из указанного файла(file_name должен содержать полный путь до файла и быть формата txt).")


}