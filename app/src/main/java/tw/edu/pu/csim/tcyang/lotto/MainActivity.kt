package tw.edu.pu.csim.tcyang.lotto

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import tw.edu.pu.csim.tcyang.lotto.ui.theme.LottoTheme

import androidx.compose.runtime.setValue // 引入 setValue
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LottoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Play(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Play(modifier: Modifier = Modifier) {
    var lucky by remember {
        mutableStateOf((1..100).random())  // 隨機產生 1 到 100 之間的數字
    }

    val context = LocalContext.current // 取得當前 Context

    Column(
        modifier = modifier
            .fillMaxSize()  // 讓 Column 填滿整個螢幕
            .clickable {  // 設定觸摸事件，點擊全螢幕觸發 Toast
                Toast.makeText(context, "螢幕觸控(黃福恩)", Toast.LENGTH_SHORT).show()
            },
        horizontalAlignment = Alignment.CenterHorizontally,  // 文字和元件水平置中
        verticalArrangement = Arrangement.Center  // 元件垂直置中
    ) {
        // 顯示樂透數字
        Text(
            text = "樂透數字(1-100)為 $lucky"
        )

        // 重新產生樂透碼的按鈕
        Button(
            onClick = { lucky = (1..100).random() }  // 點擊按鈕後產生新數字
        ) {
            Text("重新產生樂透碼")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LottoTheme {
        Play()
    }
}
