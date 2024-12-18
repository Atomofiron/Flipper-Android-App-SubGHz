package com.flipperdevices.filemanager.listing.impl.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.flipperdevices.core.ui.ktx.clickableRipple
import com.flipperdevices.core.ui.theme.LocalPalletV2
import com.flipperdevices.filemanager.listing.impl.composable.options.ListOptionsDropDown
import com.flipperdevices.filemanager.listing.impl.viewmodel.OptionsViewModel
import com.flipperdevices.filemanager.listing.impl.viewmodel.OptionsViewModel.Action
import flipperapp.components.core.ui.res.generated.resources.ic_more_points
import org.jetbrains.compose.resources.painterResource
import flipperapp.components.core.ui.res.generated.resources.Res as CoreUiRes

@Composable
fun MoreIconComposable(
    optionsState: OptionsViewModel.State,
    canCreateFiles: Boolean,
    onAction: (Action) -> Unit,
    onSelectClick: () -> Unit,
    onUploadClick: () -> Unit,
    onCreateFileClick: () -> Unit,
    onCreateFolderClick: () -> Unit,
    modifier: Modifier = Modifier

) {
    Box(modifier = modifier) {
        Icon(
            modifier = Modifier
                .padding(end = 14.dp)
                .size(24.dp)
                .clickableRipple(onClick = { onAction.invoke(Action.ToggleMenu) }),
            painter = painterResource(CoreUiRes.drawable.ic_more_points),
            contentDescription = null,
            tint = LocalPalletV2.current.icon.blackAndWhite.blackOnColor
        )
        ListOptionsDropDown(
            isVisible = optionsState.isVisible,
            canCreateFiles = canCreateFiles,
            onAction = onAction,
            isHiddenFilesVisible = optionsState.isHiddenFilesVisible,
            onUploadClick = {
                onAction.invoke(Action.ToggleMenu)
                onUploadClick.invoke()
            },
            onSelectClick = {
                onAction.invoke(Action.ToggleMenu)
                onSelectClick.invoke()
            },
            onCreateFileClick = {
                onAction.invoke(Action.ToggleMenu)
                onCreateFileClick.invoke()
            },
            onCreateFolderClick = {
                onAction.invoke(Action.ToggleMenu)
                onCreateFolderClick.invoke()
            },
        )
    }
}