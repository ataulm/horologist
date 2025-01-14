/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.horologist.media.ui.components.animated

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.wear.compose.material.ButtonColors
import androidx.wear.compose.material.ButtonDefaults
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.android.horologist.audio.ui.components.animated.LocalStaticPreview
import com.google.android.horologist.media.ui.ExperimentalHorologistMediaUiApi
import com.google.android.horologist.media.ui.R
import com.google.android.horologist.media.ui.components.controls.SeekToPreviousButton

@ExperimentalHorologistMediaUiApi
@Composable
public fun AnimatedSeekToPreviousButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.iconButtonColors(),
) {
    if (LocalStaticPreview.current) {
        SeekToPreviousButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            colors = colors
        )
    } else {
        val composition by rememberLottieComposition(
            spec = LottieCompositionSpec.Asset("lottie/Next.json"),
        )
        val lottieAnimatable = rememberLottieAnimatable()

        Box(modifier = Modifier.graphicsLayer(scaleX = -1f)) {
            AnimatedMediaButton(
                modifier = modifier,
                onClick = onClick,
                contentDescription = stringResource(id = R.string.horologist_seek_to_next_button_content_description),
                enabled = enabled,
                colors = colors,
                composition = composition,
                lottieAnimatable = lottieAnimatable,
            )
        }
    }
}
