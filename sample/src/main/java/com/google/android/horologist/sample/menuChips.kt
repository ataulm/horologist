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

package com.google.android.horologist.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text

@Composable
fun FillMaxRectangleChip(navigateToRoute: (String) -> Unit) {
    SampleChip(
        onClick = { navigateToRoute(Screen.FillMaxRectangle.route) },
        label = "Fill Max Rectangle",
        content = {
            if (LocalConfiguration.current.isScreenRound) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.Black)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.Red)
                            .size(24.dp)
                    )
                }
            } else {
                Box(
                    modifier = Modifier
                        .background(Color.Red)
                        .fillMaxSize()
                )
            }
        }
    )
}

@Composable
fun VolumeScreenChip(navigateToRoute: (String) -> Unit) {
    SampleChip(
        onClick = { navigateToRoute(Screen.Volume.route) },
        label = "Volume Screen",
        content = {
            Icon(
                imageVector = Icons.Default.VolumeUp,
                contentDescription = "Volume Screen"
            )
        }
    )
}

@Composable
fun FadeAwayChip(
    label: String,
    navigateToRoute: () -> Unit
) {
    SampleChip(
        onClick = { navigateToRoute() },
        label = label,
        content = {
            Box(
                modifier = Modifier.fillMaxSize().let {
                    if (LocalConfiguration.current.isScreenRound)
                        it.clip(CircleShape)
                    else
                        it
                },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "10:10 AM", fontSize = 6f.sp)
            }
        }
    )
}