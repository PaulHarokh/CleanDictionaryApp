package by.paulharokh.cleandictionary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import by.paulharokh.cleandictionary.ui.theme.CleanDictionaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanDictionaryTheme {

            }
        }
    }
}

