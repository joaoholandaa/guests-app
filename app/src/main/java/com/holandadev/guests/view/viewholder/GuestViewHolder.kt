package com.holandadev.guests.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.holandadev.guests.databinding.RowGuestBinding
import com.holandadev.guests.model.GuestModel

class GuestViewHolder(private val bind: RowGuestBinding) : RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestModel) {
        bind.textName.text = guest.name
    }

}