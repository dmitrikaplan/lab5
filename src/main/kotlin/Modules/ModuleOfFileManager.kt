package Modules

import AppIO.FileManager
import dev.shustoff.dikt.Create

class ModuleOfFileManager(val outputData : String) {

    @Create
    fun fileManager() : FileManager;

}