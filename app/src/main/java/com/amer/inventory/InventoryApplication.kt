package com.amer.inventory

import android.app.Application
import com.amer.inventory.data.AppContainer
import com.amer.inventory.data.AppDataContainer

/**
 * Application class for the Inventory app.
 *
 * This class is responsible for initializing the dependency injection container ([AppContainer])
 * when the application is created.
 */
class InventoryApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    /**
     * Called when the application is starting, before any other application objects have been created.
     * Initializes the [AppContainer] instance.
     */
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}