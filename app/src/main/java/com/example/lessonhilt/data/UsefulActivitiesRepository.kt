package com.example.lessonhilt.data

import com.example.lessonhilt.domain.UsefulActivity
import javax.inject.Inject

class UsefulActivitiesRepository @Inject constructor() {

    suspend fun getUsefulActivity(): UsefulActivity {
        return RetrofitInstance.searchApi.getList()
    }

}