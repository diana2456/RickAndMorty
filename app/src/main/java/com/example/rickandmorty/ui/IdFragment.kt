@file:Suppress("UNREACHABLE_CODE")

package com.example.rickandmorty.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.rickandmorty.R
import com.example.rickandmorty.data.RemoteRepository
import com.example.rickandmorty.databinding.FragmentIdBinding
import com.example.rickandmorty.model.Characters


@Suppress("DEPRECATION")
class IdFragment : Fragment() {

    private val repository = RemoteRepository()
    private var page =1

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    private lateinit var binding: FragmentIdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentIdBinding.inflate(inflater, container, false)
        getCharacters()

        return binding.root
    }

    private fun getCharacters() {
       repository.getCharacters(page,this::onSuccess,this::onFailure)
    }
    private fun onSuccess(characters:Characters){
       binding.recycclerview.adapter = AdapterId(characters)
    }
    private fun onFailure(message:String){
        Log.i("ololo", "onFailure:$message")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.back,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    @SuppressLint("CommitTransaction")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.back->{
                Toast.makeText(requireContext(), "Toast", Toast.LENGTH_SHORT).show()
                val newFragmen: Fragment = FragmentList()
                val transaction1: FragmentTransaction = requireFragmentManager().beginTransaction()
                val fragmentManager1: FragmentManager? = fragmentManager
                fragmentManager1?.beginTransaction()?.replace(R.id.container, newFragmen)?.commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    }