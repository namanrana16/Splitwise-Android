import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

enum class BottomBarScreen(val route: String,val icon: ImageVector) {
    Home("home", Icons.Default.Home),
    Profile("profile", Icons.Default.Person),
    Settings("Friends", Icons.Default.Settings),
    Notifications("Groups", Icons.Default.Settings),
}




@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomTabWithScreens() {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                BottomBarScreen.entries.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(screen.name) },
                        selected = navController.currentDestination?.route == screen.route,
                        onClick = {
                            coroutineScope.launch {
                                navController.navigate(screen.route)
                            }
                        }
                    )
                }
            }
        }
    ) {
        NavHost(navController, startDestination = BottomBarScreen.Home.route) {
            composable(BottomBarScreen.Home.route) { HomeScreen() }
            composable(BottomBarScreen.Profile.route) { ProfileScreen() }
            composable(BottomBarScreen.Settings.route) { SettingsScreen() }
            composable(BottomBarScreen.Notifications.route) { NotificationsScreen() }
        }
    }
}

// Define your screen content
@Composable
fun HomeScreen() {
    // Content for the Home screen
}

@Composable
fun ProfileScreen() {
    // Content for the Profile screen
}

@Composable
fun SettingsScreen() {
    // Content for the Settings screen
}

@Composable
fun NotificationsScreen() {
    // Content for the Notifications screen
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BottomTabWithScreens()
}