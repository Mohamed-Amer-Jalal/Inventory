package com.amer.inventory.ui.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * ViewModel to retrieve and update an item from the [com.amer.inventory.data.ItemsRepository]'s data source.
 */
class ItemEditViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    /**
     * Holds current item ui state. This is a private set property, meaning the UI state can only be
     * modified from within the ViewModel. This helps to maintain a unidirectional data flow.
     * The initial state is an empty ItemUiState.
     */
    var itemUiState by mutableStateOf(ItemUiState())
        private set

    /**
     * The ID of the item being edited.
     */
    private val itemId: Int = checkNotNull(savedStateHandle[ItemEditDestination.ITEM_ID_ARG])

    /**
     * Validates that the input fields are not blank.
     * @param uiState The current UI state of the item details.
     * @return True if all input fields are valid, false otherwise.
     */
    private fun validateInput(uiState: ItemDetails = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }
}