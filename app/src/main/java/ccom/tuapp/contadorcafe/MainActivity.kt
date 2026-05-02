package ccom.tuapp.contadorcafe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ccom.tuapp.contadorcafe.ui.CoffeeCounterScreen
import ccom.tuapp.contadorcafe.ui.theme.ContadorCafeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContadorCafeTheme {
                var count by remember { mutableStateOf(0) }

                CoffeeCounterScreen(
                    count   = count,
                    onAdd   = { count++ },
                    onReset = { count = 0 }
                )
            }
        }
    }
}