package com.amer.inventory.ui.home

import androidx.lifecycle.ViewModel
import com.amer.inventory.data.Item

/**
 * ViewModel to retrieve all items in the Room database.
 */
class HomeViewModel : ViewModel() {
    /**
     * Companion object for the HomeViewModel.
     *
     * Contains constants used within the ViewModel.
     */
    companion object {
        /**
         * The timeout in milliseconds for database operations.
         */
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * Represents the UI state for the Home screen.
 *
 * @param itemList The list of items to be displayed on the Home screen. Defaults to an empty list.
 */
data class HomeUiState(val itemList: List<Item> = listOf())