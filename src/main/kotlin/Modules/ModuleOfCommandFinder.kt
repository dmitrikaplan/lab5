package Modules

import AppIO.CollectionManager
import AppIO.CommandFinder
import AppIO.CommandManager
import dev.shustoff.dikt.Create
import dev.shustoff.dikt.CreateSingle
import dev.shustoff.dikt.ProvideSingle
import dev.shustoff.dikt.UseModules


@UseModules(ModuleOfCommandManager::class)
class ModuleOfCommandFinder(private val moduleOfCommandManager: ModuleOfCommandManager, private val collectionManager: CollectionManager){


    @ProvideSingle
    private fun commandManager() : CommandManager;


    @Create
    fun commandFinder() : CommandFinder;

}