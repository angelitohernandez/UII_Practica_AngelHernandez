package mx.edu.utez.angel.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mx.edu.utez.angel.ui.screens.amigos.AmigosScreen
import mx.edu.utez.angel.ui.screens.conversor.ConversorScreen
import mx.edu.utez.angel.ui.screens.menu.MenuScreen
import mx.edu.utez.angel.ui.screens.propinas.PropinasScreen
import mx.edu.utez.angel.ui.screens.calculadora.CalculadoraScreen
import mx.edu.utez.angel.ui.screens.galeria.GaleriaScreen

// Definición de las rutas de navegación
sealed class Route(val path: String) {
    object Menu : Route("menu")
    object Conversor : Route("conversor")
    object Propinas : Route("propinas")
    object Calculadora : Route("calculadora")
    object Galeria : Route("galeria")
    object Amigos : Route("amigos")
}

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Route.Menu.path,
        modifier = modifier
    ) {
        // 1. Pantalla Menú Principal
        composable(Route.Menu.path) {
            MenuScreen(
                onNavigateToConversor = { navController.navigate(Route.Conversor.path) },
                onNavigateToPropinas = { navController.navigate(Route.Propinas.path) },
                onNavigateToCalculadora = { navController.navigate(Route.Calculadora.path) },
                onNavigateToGaleria = { navController.navigate(Route.Galeria.path) },
                onNavigateToAmigos = { navController.navigate(Route.Amigos.path) }
            )
        }

        // 2. Pantalla Conversor de Divisas
        composable(Route.Conversor.path) {
            ConversorScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        // 3. Pantalla Calculadora de Propinas
        composable(Route.Propinas.path) {
            PropinasScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        // 4. Calculadora Básica
        composable(Route.Calculadora.path) {
            CalculadoraScreen(onBackClick = { navController.popBackStack() })
        }

        // 5. Galeria de fotos
        composable(Route.Galeria.path) {
            GaleriaScreen(onBackClick = { navController.popBackStack() })
        }
        // 5. Mejores Amigos
        composable(Route.Amigos.path) {
            AmigosScreen(onBackClick = { navController.popBackStack() })
        }
    }
}
