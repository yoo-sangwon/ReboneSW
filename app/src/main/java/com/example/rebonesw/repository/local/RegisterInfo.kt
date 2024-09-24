package com.example.rebonesw.repository.local

import android.content.Context
import com.example.rebonesw.data.RegisterData
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RegisterInfo @Inject constructor(
    @ApplicationContext context: Context
): RbData<RegisterData>(context, RegisterData::class.java, "registerInfo")