package com.study.tastingnote.ui.liquor

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.study.tastingnote.R
import com.study.tastingnote.data.model.TrackResult
import com.study.tastingnote.data.room.Liquor
import com.study.tastingnote.databinding.ActivityWriteTrackBinding
import com.study.tastingnote.viewModel.WriteTrackViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WriteTrackActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteTrackBinding
    private val viewModel:WriteTrackViewModel by viewModel()

    val data : TrackResult by lazy {
        intent.getParcelableExtra<TrackResult>("track")!!
    }
    @SuppressLint("SetTextI18n")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteTrackBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this@WriteTrackActivity

        setContentView(binding.root)

        Glide.with(applicationContext)
            .load(data.ImageUrl)
            .placeholder(R.drawable.img_placeholder)
            .into(binding.trackImg)

        binding.artistName.text = "Artist Name : " + data.artistName
        binding.albumName.text = "Collection Name :" + data.collectionName
        binding.trackName.text = "Track Name : " + data.trackName

        binding.writeSaveBtn.setOnClickListener {
            if(!binding.writeTrack.text.equals("")) {
                val trackData : Liquor = Liquor(
                    data.trackId,
                    trackName = data.trackName,
                    collectionName = data.collectionName,
                    artistName = data.artistName,
                    imgUrl = data.ImageUrl,
                    writeText = binding.writeTrack.text.toString()
                )
                viewModel.insertTrack(trackData)
            }
            finish()
        }
    }
}