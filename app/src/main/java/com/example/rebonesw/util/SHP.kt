package com.example.rebonesw.util

import android.content.Context
import com.google.gson.GsonBuilder
import timber.log.Timber

object SHP {
    private val gson = GsonBuilder()
        .setLenient() //JSON 해석을 관대하게 설정
        .create()

    fun write(context: Context, key: String, data:Any) {
        Timber.i(gson.toJson(data))
        context.getSharedPreferences(context.packageName + ".rb", Context.MODE_PRIVATE).edit()
            .putString(key, gson.toJson(data))
            .apply()
    } //write

    fun remove(context:Context, key: String){
        Timber.i(key)
        context.getSharedPreferences(context.packageName + ".rb", Context.MODE_PRIVATE).edit()
            .remove(key)
            .apply()
    } //remove

    fun <T : Any> read( context: Context, key: String, clazz: Class<T>): T? {
        var shp = context.getSharedPreferences(context.packageName + ".rb" , Context.MODE_PRIVATE)

        return if(shp.contains(key)){
            Timber.d("${gson.fromJson(shp.getString(key, "{}"), clazz)}")
            gson.fromJson(shp.getString(key, "{}"), clazz)
        } else {
            null
        }
    } //read


} //SHP