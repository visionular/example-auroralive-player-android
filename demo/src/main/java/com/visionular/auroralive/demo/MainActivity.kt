package com.visionular.auroralive.demo

import android.media.AudioManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.visionular.auroralive.AuroraLivePlayer
import com.visionular.auroralive.demo.databinding.ActivityMainBinding
import com.visionular.auroralive.utils.AuroraLogLevel
import org.webrtc.SurfaceViewRenderer

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AuroraLivePlayer.logLevel = AuroraLogLevel.INFO

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onResume() {
        super.onResume()

        // Set volume control stream type to WebRTC audio.
        volumeControlStream = AudioManager.STREAM_MUSIC
    }

    override fun onPause() {
        super.onPause()
        volumeControlStream = AudioManager.USE_DEFAULT_STREAM_TYPE;
    }

    // override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        // menuInflater.inflate(R.menu.menu_main, menu)
        // return true
    // }

    // override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // return when (item.itemId) {
            // else -> super.onOptionsItemSelected(item)
        // }
    // }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}