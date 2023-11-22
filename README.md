# example-auroralive-player-android
A sample app which use the AuroraLive Player Android SDK.

## Docs

Source Docs: https://docs.visionular.com/auroralive/playersdk/android/

## Install SDK

```
repositories {
    mavenCentral()
}

dependencies {
     implementation 'com.visionular:auroralive-player:1.0.4'
}

```

## Create the Player
```kotlin
// <this> refers to the current Android Activity, and implements AuroraLivePlayer.Listener
val player = AuroraLivePlayer(applicationContext, this)
```

## Play the stream

* add org.webrtc.SurfaceViewRenderer to your Android UI layout

```kotlin
// add surface view
// SurfaceViewRenderer is org.webrtc.SurfaceViewRenderer
player.renderer = findViewById<SurfaceViewRenderer>(R.id.video_view)

// play stream
lifecycleScope.lauch {
    player.play(<your_playback_id>, <your_jwt_token>)
}
```

## Release the Player
```kotlin
player.close()
```
