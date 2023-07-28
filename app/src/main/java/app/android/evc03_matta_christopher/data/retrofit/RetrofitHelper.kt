package app.android.evc03_matta_christopher.data.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {
    private val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.escuelajs.co/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val storeInstance = retrofitInstance.create(RetrofitInstance::class.java)
    // https://api.escuelajs.co/api/v1/products

}