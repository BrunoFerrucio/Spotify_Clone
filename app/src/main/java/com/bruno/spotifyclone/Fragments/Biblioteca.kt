package com.bruno.spotifyclone.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.spotifyclone.databinding.FragmentBibliotecaBinding
import com.bruno.spotifyclone.FragmentsTab.Albuns
import com.bruno.spotifyclone.FragmentsTab.Artistas
import com.bruno.spotifyclone.FragmentsTab.Playlists

import com.bruno.spotifyclone.R
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems


class Biblioteca : Fragment() {

    companion object{
        fun newInstance(): Biblioteca{
            val fragmentBiblioteca = Biblioteca()
            val argumentos = Bundle()
            fragmentBiblioteca.arguments = argumentos
            return fragmentBiblioteca

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_biblioteca, container, false)
    }

    private lateinit var fragmentBiblioteca: FragmentBibliotecaBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val bindingBiblioteca = FragmentBibliotecaBinding.bind(view)
        fragmentBiblioteca = bindingBiblioteca

        val viewpager = bindingBiblioteca.viewpager
        val viewpagertab = bindingBiblioteca.viewpagertab

        var adapter = FragmentPagerItemAdapter(fragmentManager, FragmentPagerItems.with(context)

            .add("Playlists",Playlists::class.java)
            .add("Artistas",Artistas::class.java)
            .add("Álbuns", Albuns::class.java)
            .create())

           viewpager.adapter = adapter
           viewpagertab.setViewPager(viewpager)
    }

}
