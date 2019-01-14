package me.darshpratap.coaster.activity

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_insight.*
import me.darshpratap.coaster.R

class InsightActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_performance -> {
                message.setText(R.string.performance)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_accessibility -> {
                message.setText(R.string.accessibility)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_best_practices -> {
                message.setText(R.string.best_practices)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_pwa -> {
                message.setText(R.string.pwa)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_seo -> {
                message.setText(R.string.seo)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insight)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
