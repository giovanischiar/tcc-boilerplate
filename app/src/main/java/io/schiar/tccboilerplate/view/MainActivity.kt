package io.schiar.tccboilerplate.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import io.schiar.tccboilerplate.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Atividade que controla toda a navegação dos fragmentos da aplicação.
 * @property navController utilizado para o navigation.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    /**
     * Define qual o XML de view que a Atividade vai usar, define a toolbar criada no XML como a barra superior
     * da aplicação, e passar o controle de navegação para ela, para assim poder integrar o navigation a aplicação
     * @param savedInstanceState guarda dados da última execução permitindo restaurar o estado anterior.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        navController = Navigation.findNavController(this, R.id.initial_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    /**
     * Utilizar o método do navigation para voltar ao fragmento anterior quando há um evento de botão da barra superior.
     * de voltar
     * @return true se foi possível voltar ao fragmento anterior, false caso contrário
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    /**
     * Utilizar o método do navigation para voltar ao fragmento anterior quando há um evento de botão físico de voltar.
     */
    override fun onBackPressed() {
        super.onBackPressed()
        navController.navigateUp()
    }
}
