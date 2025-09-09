package com.amer.inventory.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    /**
     * Repository for managing inventory items.
     */
    val itemsRepository: ItemsRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository].
 *
 * This class is responsible for creating and providing dependencies related to application data.
 * It currently provides an instance of [OfflineItemsRepository] for accessing item data.
 *
 * @param context The application context, used for creating dependencies if needed.
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Lazily initialized [ItemsRepository] implementation.
     * This property provides an instance of [OfflineItemsRepository].
     */
    override val itemsRepository: ItemsRepository by lazy { OfflineItemsRepository() }
}