package com.amer.inventory.data

/**
 * Entity data class represents a single row in the database.
 * @param id The unique identifier for the item. Defaults to 0.
 * @param name The name of the item.
 * @param price The price of the item.
 * @param quantity The quantity of the item in stock.
 */
class Item(val id: Int = 0, val name: String, val price: Double, val quantity: Int)