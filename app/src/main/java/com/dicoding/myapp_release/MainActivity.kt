package com.dicoding.myapp_release

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvManga: RecyclerView
    private var list = ArrayList<Manga>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvManga = requireViewById(R.id.rv_manga)
        rvManga.setHasFixedSize(true)
        val btnOpenIdentity : ImageView = findViewById(R.id.btn_identity)
        btnOpenIdentity.setOnClickListener{
            val intentIdentity = Intent(this, IdentityMain::class.java)
            startActivity(intentIdentity)
        }

        list.addAll(getListmangas())
        showRecylerList()

    }

    private fun showRecylerList() {
        rvManga.layoutManager = LinearLayoutManager(this)
        val listMangaAdapter = ListMangaAdapter(list)
        rvManga.adapter = listMangaAdapter

        listMangaAdapter.setOnItemClickCallback(object : ListMangaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Manga) {
                showSelectedHero(data)
            }
        })
    }
    private fun getListmangas(): ArrayList<Manga> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_deskripsi)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataStatus =resources.getStringArray(R.array.data_status)
        val dataGenres = resources.getStringArray(R.array.data_genre)
        val dataRead = resources.getStringArray(R.array.data_read)
        val listManga = ArrayList<Manga>()
        for(i in dataName.indices){
            val manga = Manga(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1),dataStatus[i],dataGenres[i],dataRead[i])
            listManga.add(manga)
        }
        return listManga
    }

    private fun showSelectedHero(manga : Manga) {
        Toast.makeText(this, "Kamu memilih " + manga.name, Toast.LENGTH_SHORT).show()
    }
}