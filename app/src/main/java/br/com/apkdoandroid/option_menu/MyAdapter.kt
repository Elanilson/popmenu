package br.com.apkdoandroid.option_menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var lista : List<Item>,var context : Context) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {





    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var titulo  = itemView.findViewById<TextView>(R.id.textViewtitulo)
         var descricao  = itemView.findViewById<TextView>(R.id.textVieDescricao)
         var menu  = itemView.findViewById<ImageView>(R.id.imageViewMenu)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val inflater  = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyViewHolder(inflater)
    }

    override fun getItemCount(): Int {
       return lista.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item : Item = lista[position]
        holder.titulo.setText(item.titulo)
        holder.descricao.setText(item.descricao)
        holder.menu.setOnClickListener {
            val popMenu = PopupMenu(context,it)
            popMenu.inflate(R.menu.option_menu)
            popMenu.setOnMenuItemClickListener {

                if(it.itemId == R.id.item_save){

                    Toast.makeText(context,"Salvar", Toast.LENGTH_SHORT).show()

                }else if (it.itemId == R.id.item_load){
                    Toast.makeText(context,"Carregar", Toast.LENGTH_SHORT).show()
                }

                false
            }

            popMenu.show()
        }

    }
}