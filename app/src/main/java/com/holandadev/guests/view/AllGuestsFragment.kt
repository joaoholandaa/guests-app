package com.holandadev.guests.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.holandadev.guests.databinding.FragmentAllGuestsBinding
import com.holandadev.guests.view.adapter.GuestsAdapter
import com.holandadev.guests.view.listener.OnGuestListener
import com.holandadev.guests.viewmodel.AllGuestsViewModel

class AllGuestsFragment : Fragment() {

    private var _binding: FragmentAllGuestsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModel: AllGuestsViewModel
    private val adapter = GuestsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        b: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(AllGuestsViewModel::class.java)
        _binding = FragmentAllGuestsBinding.inflate(inflater, container, false)

        // Layout
        binding.recyclerAllGuests.layoutManager = LinearLayoutManager(context)

        // Adapter
        binding.recyclerAllGuests.adapter = adapter

        val listener = object: OnGuestListener {
            override fun onClick(id: Int) {
                Toast.makeText(context, "Hello!", Toast.LENGTH_SHORT).show()
            }

            override fun onDelete(id: Int) {
                viewModel.delete(id)
                viewModel.getAll()
            }
        }

        adapter.attackListener(listener)

        viewModel.getAll()

        observe()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe() {
        viewModel.guests.observe(viewLifecycleOwner) {
            adapter.updateGuests(it)
        }
    }
}