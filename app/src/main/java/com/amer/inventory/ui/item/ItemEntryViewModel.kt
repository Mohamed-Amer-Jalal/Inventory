package com.amer.inventory.ui.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.amer.inventory.data.Item
import java.text.NumberFormat


/**
 * ViewModel to validate and insert items in the Room database.
 * This ViewModel is responsible for managing the UI state of the item entry screen
 * and validating user input.
 */
class ItemEntryViewModel : ViewModel() {

    /**
     * Holds current item ui state. This property is private to prevent direct modification from outside
     * the ViewModel. Use [updateUiState] to update its value.
     */
    var itemUiState by mutableStateOf(ItemUiState())
        private set

    /**
     * Updates the [itemUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(itemDetails: ItemDetails) {
        itemUiState =
            ItemUiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    /**
     * Validates the input details.
     *
     * @param uiState The current UI state of the item details.
     * @return True if all input fields (name, price, quantity) are not blank, false otherwise.
     */
    private fun validateInput(uiState: ItemDetails = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }
}

/**
 * Represents the UI state for an item.
 *
 * @property itemDetails The details of the item.
 * @property isEntryValid Whether the current item details are valid.
 */
data class ItemUiState(
    val itemDetails: ItemDetails = ItemDetails(),
    val isEntryValid: Boolean = false
)

/**
 * Represents the details of an item.
 *
 * @property id The unique identifier of the item. Defaults to 0.
 * @property name The name of the item. Defaults to an empty string.
 * @property price The price of the item as a string. Defaults to an empty string.
 * @property quantity The quantity of the item as a string. Defaults to an empty string.
 */
data class ItemDetails(
    val id: Int = 0,
    val name: String = "",
    val price: String = "",
    val quantity: String = "",
)

/**
 * Extension function to convert [ItemDetails] to [Item]. If the value of [ItemDetails.price] is
 * not a valid [Double], then the price will be set to 0.0. Similarly if the value of
 * [ItemDetails.quantity] is not a valid [Int], then the quantity will be set to 0.
 */
fun ItemDetails.toItem(): Item = Item(
    id = id,
    name = name,
    price = price.toDoubleOrNull() ?: 0.0,
    quantity = quantity.toIntOrNull() ?: 0
)

/**
 * Extension function to format the price of an [Item] as currency.
 *
 * @return A [String] representing the formatted price.
 */
fun Item.formatedPrice(): String {
    return NumberFormat.getCurrencyInstance().format(price)
}

/**
 * Extension function to convert [Item] to [ItemUiState]
 *
 * @param isEntryValid a boolean indicating whether the current entry is valid or not.
 *                     Defaults to false.
 * @return [ItemUiState] representing the UI state of the item.
 */
fun Item.toItemUiState(isEntryValid: Boolean = false): ItemUiState = ItemUiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Item.toItemDetails(): ItemDetails = ItemDetails(
    id = id,
    name = name,
    price = price.toString(),
    quantity = quantity.toString()
)