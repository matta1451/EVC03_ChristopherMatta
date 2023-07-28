package app.android.evc03_matta_christopher.data.retrofit

import app.android.evc03_matta_christopher.model.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitInstance {

    @GET("products")
    fun getAllProducts(): Call<List<Product>>

    @GET("products/{id}")
    fun getProduct(@Path("id") idProducto: Int): Call<Product>
    
}