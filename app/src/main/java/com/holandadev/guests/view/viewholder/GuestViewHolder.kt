package com.holandadev.guests.view.viewholder

import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.holandadev.guests.databinding.RowGuestBinding
import com.holandadev.guests.model.GuestModel
import com.holandadev.guests.view.listener.OnGuestListener

class GuestViewHolder(private val bind: RowGuestBinding, private val listener: OnGuestListener) : RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestModel) {
        bind.textName.text = guest.name

        bind.textName.setOnClickListener {
            listener.onClick(guest.id)
        }

        bind.textName.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle("Guest Removal")
                .setMessage("Are you sure you want to remove?")
                .setPositiveButton("Yes"
                ) { dialog, which ->
                    listener.onDelete(guest.id)
                }
                .setNegativeButton("No", null)
                .create()
                .show()
            true
        }

    }

}