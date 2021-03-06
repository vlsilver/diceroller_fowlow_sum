package com.example.vlsilverkotlin.trivia

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.vlsilverkotlin.R
import com.example.vlsilverkotlin.trivia.TriviaFragmentAbout
import com.example.vlsilverkotlin.databinding.TriviaFragmentAboutBinding

class TriviaFragmentAbout : Fragment() {
    private var numQuestion = 5
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<TriviaFragmentAboutBinding>(
            inflater,
            R.layout.trivia_fragment_about,
            container,
            false
        )
        binding.playButton.setOnClickListener {
            hideKeyboard()
            if(binding.editTextNumQuestions.text.isNotEmpty()){
                numQuestion = binding.editTextNumQuestions.text.toString().toInt()
            }
            it.findNavController().navigate(
                TriviaFragmentAboutDirections.actionTriviaFragmentAboutToTriviaFragmentGame(
                    0,
                    0,
                    numQuestion
                )
            )
        }
        binding.editTextNumQuestions.requestFocus()
        (activity as AppCompatActivity).supportActionBar?.title = "Trivia"
        return binding.root
    }

    private fun hideKeyboard(){
        val inputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}