package com.bruno.spotifyclone.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.spotifyclone.databinding.FragmentBuscarBinding
import com.app.spotifyclone.databinding.SecaoItemBinding

import com.bruno.spotifyclone.R
import com.bruno.spotifyclone.model.Secao
import com.bruno.spotifyclone.model.dados

class Buscar : Fragment() {

    private lateinit var secaoAdapter: SecaoAdapter

    companion object{
        fun newInstance(): Buscar{
            val fragmentBuscar = Buscar()
            val argumentos = Bundle()
            fragmentBuscar.arguments = argumentos
            return fragmentBuscar

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buscar, container, false)
    }

    //ViewBinding do Fragment Buscar
    private var fragmentBuscar: FragmentBuscarBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val bindingBuscar = FragmentBuscarBinding.bind(view)
        fragmentBuscar = bindingBuscar
        val recycler_view_secao = bindingBuscar.recyclerViewSecao

        secaoAdapter = SecaoAdapter(dados())
        recycler_view_secao.adapter = secaoAdapter
        recycler_view_secao.layoutManager = GridLayoutManager(context,2)


    }

    private inner class SecaoAdapter(private val secoes: MutableList<Secao>): RecyclerView.Adapter<SecaoHolder>() {

        private lateinit var binding: SecaoItemBinding

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecaoHolder {
            binding = SecaoItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return SecaoHolder(binding)
        }

        override fun getItemCount(): Int = secoes.size



        override fun onBindViewHolder(holder: SecaoHolder, position: Int) {
          val secao = secoes[position]
          holder.bind(secao)
        }
    }

    private inner class SecaoHolder(binding: SecaoItemBinding): RecyclerView.ViewHolder(binding.root){

        private val image_secao = binding.imageSecao
        private val nome_secao = binding.nomeSecao

        fun bind(secao: Secao){
            image_secao.setImageResource(secao.secao)
            nome_secao.text = secao.nomeSecao
        }
    }

}
