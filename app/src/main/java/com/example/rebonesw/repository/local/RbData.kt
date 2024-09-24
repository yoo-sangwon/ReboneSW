package com.example.rebonesw.repository.local

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rebonesw.util.SHP

abstract class RbData<T: Any>(
    private val context: Context,
    private val dataClass: Class<T>,
    private val dataKey: String
) {
    private val mData: MutableLiveData<T?> = MutableLiveData<T?>()
    val data : LiveData<T?> = mData

    init {
        mData.value = SHP.read(context, dataKey, dataClass)
    }

    fun update(newData: T){
        SHP.write(context, dataKey, newData)
        mData.value = newData
    } //update

    fun postUpdate(newData: T){
        SHP.write(context, dataKey, newData)
        mData.postValue(newData)
    } //postUpdate

    fun remove(){
        SHP.remove(context, dataKey)
        mData.value = null
    } //remove

    fun postRemove(){
        SHP.remove(context, dataKey)
        mData.postValue(null)
    } //postRemove

    fun refresh() {
        mData.value = SHP.read(context, dataKey, dataClass)
    } //refresh

} //RbData