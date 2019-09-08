package com.keithsmyth.example.masterdetailexample.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader

class PlantProvider(application: Application) {

    private val _plants = MutableLiveData<List<Plant>>()

    val plants: LiveData<List<Plant>> = _plants

    init {
        Threading.ioExecutor.execute {
            application.assets.open("plants.json").use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val plantType = object : TypeToken<List<Plant>>() {}.type
                    val plantList: List<Plant> = Gson().fromJson(jsonReader, plantType)
                    _plants.postValue(plantList)
                }
            }
        }
    }

}
