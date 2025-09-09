package com.amer.inventory.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.amer.inventory.InventoryApplication
import com.amer.inventory.ui.home.HomeViewModel
import com.amer.inventory.ui.item.ItemDetailsViewModel
import com.amer.inventory.ui.item.ItemEditViewModel
import com.amer.inventory.ui.item.ItemEntryViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire Inventory app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for ItemEditViewModel
        initializer { ItemEditViewModel(this.createSavedStateHandle()) }
        // Initializer for ItemEntryViewModel
        initializer { ItemEntryViewModel() }

        // Initializer for ItemDetailsViewModel
        initializer { ItemDetailsViewModel(this.createSavedStateHandle()) }

        // Initializer for HomeViewModel
        initializer { HomeViewModel() }
    }
}

/**
 * Extension function to retrieve the [InventoryApplication] instance from [CreationExtras].
 *
 * This function is used by ViewModels to access the application context, which is necessary
 * for interacting with the database or other application-level components.
 *
 * @return The [InventoryApplication] instance.
 * @throws IllegalStateException if the [InventoryApplication] cannot be found in the [CreationExtras].
 *                                This typically means the ViewModel is not being created correctly
 *                                through the [ViewModelProvider.Factory].
 */
fun CreationExtras.inventoryApplication(): InventoryApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as InventoryApplication)