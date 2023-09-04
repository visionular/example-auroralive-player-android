package com.visionular.auroralive.player.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import com.visionular.auroralive.AuroraLivePlayer
import com.visionular.auroralive.utils.AuroraLogLevel
import org.webrtc.SurfaceViewRenderer
import java.util.*


class MainActivity : AppCompatActivity() , AuroraLivePlayer.Listener {

    private lateinit var player: AuroraLivePlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AuroraLivePlayer.logLevel = AuroraLogLevel.WARN

        player = AuroraLivePlayer(applicationContext, this)
        player.renderer = findViewById<SurfaceViewRenderer>(R.id.video_view)

        lifecycleScope.launch {
            // token is optional
            player.play("<your_playback_id>", "<your_jwt_token>")
        }

    }

    override fun onDestroy() {
        super.onDestroy()

        if (this::player.isInitialized) {
            player.close()
        }
    }

    override fun onPlayerError(msg: String) {
        // player error
    }

    override fun onRequestStats(stats: AuroraLivePlayer.Stats) {
        // got player video/audio stats
    }

    override fun onRequestStatsError(msg: String) {
        // get player video/audio stats failed
    }

    override fun onPlaybackSuccess() {
        // play success
    }

    override fun onSwitchLayerSuccess() {
        // switch video layer success
    }

    override fun onSwitchLayerFailed(msg: String) {
        // switch video layer failed
    }

}