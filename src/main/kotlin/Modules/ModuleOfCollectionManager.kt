package Modules

import AppIO.CollectionManager
import AppIO.FileManager
import AppIO.InputData
import dev.shustoff.dikt.Create
import dev.shustoff.dikt.CreateSingle
import dev.shustoff.dikt.ProvideSingle
import dev.shustoff.dikt.UseModules

@UseModules(ModuleOfFileManager::class)
class ModuleOfCollectionManager(private val moduleOfFileManager: ModuleOfFileManager) {


    @ProvideSingle
    private fun fileManager() : FileManager

    @CreateSingle
    private fun inputData() : InputData

    @Create
    fun collectionManager() : CollectionManager




}

