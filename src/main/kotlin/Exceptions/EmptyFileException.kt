package Exceptions

class EmptyFileException : Exception(){

    override fun toString(): String {
        return "Пустая коллекция"
    }
}