package app.android.evc03_matta_christopher.UI.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.android.evc03_matta_christopher.data.repository.ProductRepository
import app.android.evc03_matta_christopher.model.Product

class ViewModel: ViewModel() {
    private val repository = ProductRepository()

    fun listarProductos(): LiveData<List<Product>> {
        return repository.getProducts()
    }

    fun ObtenerProducto(idProducto: Int): LiveData<Product> {
        return repository.getProduct(idProducto)
    }
}