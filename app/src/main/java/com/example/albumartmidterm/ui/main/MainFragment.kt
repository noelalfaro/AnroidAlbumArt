package com.example.albumartmidterm.ui.main

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.albumartmidterm.R
import com.example.albumartmidterm.databinding.MainFragmentBinding
import kotlin.random.Random


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
        private const val TAG = "MainFragment"
    }


    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!



    private val albums = arrayOf(
        R.drawable.gkmcalbum,
        R.drawable.butterfly3album,
        R.drawable.ununalbum,
        R.drawable.damnalbum
    )


    private lateinit var music: MediaPlayer
    private var roll = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //return inflater.inflate(R.layout.main_fragment, container, false)
        _binding = MainFragmentBinding.inflate(inflater, container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
        music = MediaPlayer.create(context, R.raw.gkmcsnippet)

        binding.switchAlbumButton.setOnClickListener {
            roll = Random.nextInt(4)
            binding.albumContainerView1.setImageResource(albums[roll])
            if (roll == 0){
                binding.albumContainerView1.tag = "gkmc"
            }
            if (roll == 1){
                binding.albumContainerView1.tag = "butterfly"
            }
            if (roll == 2){
                binding.albumContainerView1.tag = "unum"
            }
            if (roll == 3){
                binding.albumContainerView1.tag = "damn"
            }

        }


        binding.releaseButton.setOnClickListener {

            var title = "Title"
            var year = 0
            if (binding.albumContainerView1.tag == "gkmc" ){
                title = "Good Kid Mad City"
                year = 2013
            }

            if (binding.albumContainerView1.tag == "butterfly"){
                title = "To Pimp a Butterfly"
                year = 2015
            }


            if (binding.albumContainerView1.tag == "unum"){
                title = "Untitled Unmastered"
                year = 2016
            }

            if (binding.albumContainerView1.tag == "damn"){
                title = "Damn."
                year = 2017
            }
            val text = "$title: Released in $year"
            val duration = Toast.LENGTH_SHORT


            val toast = Toast.makeText(context, text, duration)
            toast.show()

        }

        binding.soundButton.setOnClickListener {
                music.start()
        }

    }



}