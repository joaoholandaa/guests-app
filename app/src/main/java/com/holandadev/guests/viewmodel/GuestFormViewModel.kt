package com.holandadev.guests.viewmodel

import androidx.lifecycle.ViewModel
import com.holandadev.guests.repository.GuestRepository

class GuestFormViewModel : ViewModel() {

    private val repository = GuestRepository.getInstance()

    fun abc() {
    }

}