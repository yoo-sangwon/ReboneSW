package com.example.rebonesw.repository.local

import android.content.Context
import com.example.rebonesw.data.ScreeningTestAnswersData
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScreeningTestAnswersInfo @Inject constructor(
    @ApplicationContext context: Context
): RbData<ScreeningTestAnswersData>(context, ScreeningTestAnswersData::class.java, "screeningTestAnswersInfo")