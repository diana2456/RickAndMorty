@file:Suppress("ImplicitThis")

package com.example.rickandmorty.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.rickandmorty.R
import com.example.rickandmorty.data.RemoteRepository
import com.example.rickandmorty.databinding.FragmentListBinding
import com.example.rickandmorty.model.Characters


@Suppress("UseExpressionBody")
 class FragmentList : Fragment() {

    private var page =1
    private val repository = RemoteRepository()

    private lateinit var binding:FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(LayoutInflater.from(context), container, false)
        getCharacters()

        binding.swip.setOnRefreshListener {
            Toast.makeText(requireContext(), "Toast", Toast.LENGTH_SHORT).show()
            val newFragmen: Fragment = IdFragment()
            val transaction1: FragmentTransaction = requireFragmentManager().beginTransaction()

            val fragmentManager1: FragmentManager? = fragmentManager
            fragmentManager1?.beginTransaction()?.replace(R.id.container, newFragmen)?.commit()
            binding.swip.isRefreshing = false
        }
        return binding.root
    }

    private fun getCharacters() {
        repository.getCharacters(page,this::onSuccess,this::onFailure)
    }
    private fun onSuccess(characters: Characters){
        binding.recycclerview.adapter = CharacterAdapter(characters,this::onCLick)
    }

    private fun onFailure(message:String){
        Log.i("ololo", "onFailure:$message")
    }

    private fun onCLick(pos:Int){
        Toast.makeText(requireContext(), "Toast", Toast.LENGTH_SHORT).show()
        val newFragmen: Fragment = IdFragment()
        val transaction1: FragmentTransaction = requireFragmentManager().beginTransaction()

        val fragmentManager1: FragmentManager? = fragmentManager
        fragmentManager1?.beginTransaction()?.replace(R.id.container, newFragmen)?.commit()
    }
}