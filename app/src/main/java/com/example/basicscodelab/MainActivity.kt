package com.example.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicsCodelabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun GreetingScreen(modifier: Modifier = Modifier) {
    // State untuk mengontrol apakah teks harus ditampilkan
    var showText by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Tampilkan teks hanya jika `showText` bernilai true
        if (showText) {
            Text(text = "Hello Android!", style = MaterialTheme.typography.headlineMedium)
        }

        Spacer(modifier = Modifier.height(16.dp)) // Jarak antara tombol dan teks

        // Tombol yang harus diklik terlebih dahulu
        Button(onClick = { showText = true }) {
            Text(text = "Klik Disini")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicsCodelabTheme {
        GreetingScreen()
    }
}

