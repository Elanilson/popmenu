package br.com.apkdoandroid.option_menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var itens  : MutableList<Item> = mutableListOf()

        for ( i in 0..10){
            itens.add(Item("Titulo ${i}","Descricao ${i}"))
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MyAdapter( itens,this)
        recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
    }
}