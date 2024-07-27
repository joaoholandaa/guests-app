package com.holandadev.guests

class GuestRepository private constructor() {

    // Singleton
    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository()
            }
            return repository
        }
    }
}