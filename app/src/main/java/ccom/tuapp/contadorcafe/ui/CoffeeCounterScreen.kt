package ccom.tuapp.contadorcafe.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private const val CAFFEINE_LIMIT = 10

@Composable
fun CoffeeCounterScreen(
    count: Int,
    onAdd: () -> Unit,
    onReset: () -> Unit
) {
    val isDanger = count > CAFFEINE_LIMIT

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Mi contador de café ☕",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = count.toString(),
                fontSize = 96.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (isDanger) Color(0xFFA32D2D) else Color(0xFF3C3489),
                textAlign = TextAlign.Center
            )

            Text(
                text = if (count == 1) "taza hoy" else "tazas hoy",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (isDanger) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFFCEBEB)
                    )
                ) {
                    Text(
                        text = "⚠️ ¡Demasiada cafeína! Considera tomar agua.",
                        modifier = Modifier.padding(12.dp),
                        color = Color(0xFFA32D2D),
                        fontWeight = FontWeight.Medium
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onAdd,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isDanger)
                        Color(0xFFA32D2D)
                    else
                        Color(0xFF3C3489)
                )
            ) {
                Text(text = "+ Añadir taza", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedButton(
                onClick = onReset,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(text = "Reiniciar contador")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewNormal() {
    CoffeeCounterScreen(count = 3, onAdd = {}, onReset = {})
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDanger() {
    CoffeeCounterScreen(count = 12, onAdd = {}, onReset = {})
}