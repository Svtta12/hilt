package com.example.lessonhilt.domain

import com.example.lessonhilt.data.UsefulActivitiesRepository
import javax.inject.Inject

class GetUsefulActivityUseCase @Inject constructor(private val repository: UsefulActivitiesRepository) {
    suspend fun execute(): UsefulActivity {
        return repository.getUsefulActivity()
    }
}