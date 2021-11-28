package br.com.projetoviagem

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

class videoView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)
        val videoView: VideoView = findViewById(R.id.videoView)

        val videoPath = "android.resource://"+packageName+"/"+R.raw.dicasviagem
        val uri = Uri.parse(videoPath)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()

    }
}