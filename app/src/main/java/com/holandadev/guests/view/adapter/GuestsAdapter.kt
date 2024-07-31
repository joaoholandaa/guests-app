package com.holandadev.guests.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.holandadev.guests.databinding.RowGuestBinding
import com.holandadev.guests.model.GuestModel
import com.holandadev.guests.view.listener.OnGuestListener
import com.holandadev.guests.view.viewholder.GuestViewHolder

class GuestsAdapter : RecyclerView.Adapter<GuestViewHolder>() {

    private var guestList: List<GuestModel> = listOf()
    private lateinit var listener: OnGuestListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val item = RowGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestViewHolder(item, listener)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(guestList[position])
    }

    override fun getItemCount(): Int {
        return guestList.count()
    }

    fun updateGuests(list: List<GuestModel>) {
        guestList = list
        notifyDataSetChanged()
    }

    fun attackListener(guestListener: OnGuestListener) {
        listener = guestListener
    }
}