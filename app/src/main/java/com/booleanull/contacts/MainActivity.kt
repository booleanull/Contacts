package com.booleanull.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.booleanull.contacts.di.DaggerActivityComponent
import com.booleanull.core.di.AppInjectHelper
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var cicerone: Cicerone<Router>

    private val navigator = object : SupportAppNavigator(this, R.id.nav_host_fragment) {
        override fun applyCommands(commands: Array<Command>) {
            super.applyCommands(commands)
            supportFragmentManager.executePendingTransactions()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerActivityComponent.builder()
            .appComponent(AppInjectHelper.provideAppComponent(applicationContext))
            .build()
            .inject(this)

        if (savedInstanceState == null) {
            cicerone.router.replaceScreen(Screens.ContactsScreen())
        }
    }

    override fun onResume() {
        super.onResume()
        cicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        cicerone.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        cicerone.router.exit()
    }
}
