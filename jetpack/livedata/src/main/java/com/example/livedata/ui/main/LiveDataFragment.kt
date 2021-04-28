package com.example.livedata.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.livedata.R

class LiveDataFragment : Fragment() {

    companion object {
        fun newInstance() = LiveDataFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var add : Button
    private lateinit var counter : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        add = view.findViewById(R.id.add)
        counter = view.findViewById(R.id.counter)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        add.setOnClickListener{
            viewModel.add()
        }

        val counterObserver = Observer<String> { c ->
            counter.text = c
        }
        viewModel.counter.observe(this, counterObserver)
    }

}