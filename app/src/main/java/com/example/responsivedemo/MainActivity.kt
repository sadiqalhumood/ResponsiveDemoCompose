package com.example.responsivedemo

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.responsivedemo.ui.theme.ResponsiveDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResponsiveDemoTheme {
               Surface(){
                   BoxWithConstraintsExample()
               }
        }
    }
}


    @Composable
    fun BoxWithConstraintsExample() {
        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.dp
        val screenHeight = configuration.screenHeightDp.dp

        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val boxWidth = maxWidth
            val boxHeight = maxHeight

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Screen width: $screenWidth")
                Text(text = "Screen height: $screenHeight")
                Text(text = "Box width: $boxWidth")
                Text(text = "Box height: $boxHeight")

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .width(if (screenWidth > 800.dp) 400.dp else if (screenWidth > 600.dp) 300.dp else 150.dp)
                        .height(if (screenHeight > 800.dp) 300.dp else if (screenHeight > 600.dp) 200.dp else 100.dp)
                        .background(Color.Blue),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Responsive Box", color = Color.White)
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BoxWithConstraintsPreview() {
        ResponsiveDemoTheme {
            BoxWithConstraintsExample()
        }
    }
}