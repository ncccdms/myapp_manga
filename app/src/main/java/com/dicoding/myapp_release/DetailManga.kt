package com.dicoding.myapp_release

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class DetailManga : AppCompatActivity() {
    companion object{
        const val EXTRA_MANGA = "extra_manga"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_manga)

        val dataManga= if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Manga>(EXTRA_MANGA, Manga::class.java)

        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Manga>(EXTRA_MANGA)
        }

        if (dataManga != null){
            var tvNama:TextView = findViewById(R.id.judulManga)
            var tvDesc:TextView = findViewById(R.id.textDesc)
            var tvStat:TextView = findViewById(R.id.textStatus)
            var tvRead:TextView = findViewById(R.id.lastRead)
            var tvGenre:TextView = findViewById(R.id.textGenre)
            val ivDetailPhoto : ImageView = findViewById(R.id.photoManga)

            tvNama.text = dataManga.name
            tvDesc.text = dataManga.description
            tvStat.text = dataManga.status
            tvRead.text = dataManga.read
            tvGenre.text = dataManga.genre
            ivDetailPhoto.setImageResource(dataManga.photo)

        }

    }
}