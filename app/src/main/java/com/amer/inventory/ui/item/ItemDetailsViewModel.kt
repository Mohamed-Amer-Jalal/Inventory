package com.amer.inventory.ui.item

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * ViewModel to retrieve, update and delete an item from the [com.amer.inventory.data.ItemsRepository]'s data source.
 */
class ItemDetailsViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val itemId: Int = checkNotNull(savedStateHandle[ItemDetailsDestination.ITEM_ID_ARG])

    /**
     * Companion object for ItemDetailsViewModel.
     *
     * Contains constants used within the ViewModel.
     */
    companion object {

        /**
         * Timeout for item deletion, in milliseconds.
         */
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * Represents the UI state for the ItemDetailsScreen.
 *
 * @param outOfStock A boolean indicating whether the item is out of stock. Defaults to true.
 * @param itemDetails An [ItemDetails] object containing the details of the item. Defaults to an empty [ItemDetails] object.
 */
data class ItemDetailsUiState(
    val outOfStock: Boolean = true,
    val itemDetails: ItemDetails = ItemDetails(),
)