import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.android.tools.screenshot.PreviewTest
import com.example.experimentaltesting.HomeScreen
import com.example.experimentaltesting.ui.theme.ExperimentalTestingTheme


class PreviewTests {

    @PreviewTest
    @Preview
    //@PreviewScreenSizes
    //@PreviewFontScales
    //@PreviewLightDark
    @Composable
    fun HomeScreenPreview() {
        ExperimentalTestingTheme {
            HomeScreen(Modifier)
        }
    }

}

