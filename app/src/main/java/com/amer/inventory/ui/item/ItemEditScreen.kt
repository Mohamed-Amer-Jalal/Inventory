package com.amer.inventory.ui.item

import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.amer.inventory.InventoryTopAppBar
import com.amer.inventory.R
import com.amer.inventory.ui.AppViewModelProvider
import com.amer.inventory.ui.navigation.NavigationDestination
import com.amer.inventory.ui.theme.InventoryTheme

/**
 * Navigation destination for the Item Edit screen.
 */
object ItemEditDestination : NavigationDestination {
    /**
     * Unique name to define the path for a composable
     */
    override val route = "item_edit"

    /**
     * Resource ID for the title of the screen.
     */
    override val titleRes = R.string.edit_item_title

    /**
     * Argument name for the item ID.
     */
    const val ITEM_ID_ARG = "itemId"

    /**
     * Route for navigating to the item edit screen with arguments.
     */
    val routeWithArgs = "$route/{$ITEM_ID_ARG}"
}

/**
 * Composable that displays the item edit screen.
 *
 * @param navigateBack Callback to navigate back to the previous screen.
 * @param onNavigateUp Callback to navigate up in the navigation hierarchy.
 * @param modifier Modifier for this composable.
 * @param viewModel The view model for this screen.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemEditScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ItemEditViewModel = viewModel(factory = AppViewModelProvider.Factory),
) {
    Scaffold(
        topBar = {
            InventoryTopAppBar(
                title = stringResource(ItemEditDestination.titleRes),
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ) { innerPadding ->
        ItemEntryBody(
            itemUiState = viewModel.itemUiState,
            onItemValueChange = { },
            onSaveClick = { },
            modifier = Modifier
                .padding(
                    start = innerPadding.calculateStartPadding(LocalLayoutDirection.current),
                    end = innerPadding.calculateEndPadding(LocalLayoutDirection.current),
                    top = innerPadding.calculateTopPadding()
                )
                .verticalScroll(rememberScrollState())
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ItemEditScreenPreview() {
    InventoryTheme {
        ItemEditScreen(navigateBack = { /*Do nothing*/ }, onNavigateUp = { /*Do nothing*/ })
    }
}