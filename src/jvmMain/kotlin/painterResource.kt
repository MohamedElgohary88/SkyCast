import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource



expect object PainterRes {
    @Composable
    fun splashScreenImage(): Painter
    fun weatherSunCloudImage(): Painter
    fun skyCloudBackgroundImage(): Painter
    fun searchIcon(): Painter
}

actual object PainterRes {
    @Composable
    actual fun splashScreenImage(): Painter = painterResource("drawable/splash_screen_image.png")
    @Composable
    actual fun weatherSunCloudImage(): Painter  = painterResource("drawable/weather_sun_cloud.xml")
    @Composable
    actual fun skyCloudBackgroundImage(): Painter = painterResource("drawable/sky_clouds.png")
    @Composable
    actual fun searchIcon(): Painter = painterResource("drawable/search_icon.xml")
}