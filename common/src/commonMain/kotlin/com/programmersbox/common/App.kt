package com.programmersbox.common

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
internal fun App() {
    MaterialTheme(
        colorScheme = if(isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    ) {
        Surface {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Text(getPlatformName())
                    //THIS WORKS!!!
                    val item by 5.producing()
                    Text(item.toString())
                }
                //THIS DOES NOT WORK!!!
                //val b by 4.producing()
                //Text(b.toString())
            }
        }
    }
}

context(ColumnScope)
@Composable
internal fun Int.producing(vararg key: Any) = produceState(this, *key) {
    val v = value
    for(i in v..100) {
        value = i
        delay(100L)
    }
}