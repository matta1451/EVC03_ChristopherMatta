package app.android.evc03_matta_christopher.data.repository

import androidx.lifecycle.MutableLiveData
import app.android.evc03_matta_christopher.data.retrofit.RetrofitHelper
import app.android.evc03_matta_christopher.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository {

    var responseProducts = MutableLiveData<List<Product>>()
    var responseProduct = MutableLiveData<Product>()

    fun getProducts(): MutableLiveData<List<Product>> {

        val call:Call<List<Product>> = RetrofitHelper.storeInstance.getAllProducts()
        call.enqueue(object :Callback<List<Product>>{
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                responseProducts.value=response.body()
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {

            }
        })

        return responseProducts;
    }

    fun getProduct(idProducto: Int): MutableLiveData<Product> {
        val call:Call<Product> = RetrofitHelper.storeInstance.getProduct(idProducto)
        call.enqueue(object :Callback<Product>{
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                responseProduct.value= response.body()
            }
            override fun onFailure(call: Call<Product>, t: Throwable) {
            }
        })
        return responseProduct;
    }
}