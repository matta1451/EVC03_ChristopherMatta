package app.android.evc03_matta_christopher.UI.fragments

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.android.evc03_matta_christopher.R
import app.android.evc03_matta_christopher.databinding.ItemProductBinding
import app.android.evc03_matta_christopher.model.Product
import coil.load

class RVProductAdapter(var products: List<Product>): RecyclerView.Adapter<ProductVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {

        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductVH(binding)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductVH, position: Int) {
        holder.bind(products[position])
    }
}

class ProductVH(private val binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(product: Product) {
        binding.txtIdProducto.text = "${product.id}"
        binding.txtProductTitle.text = product.title
        binding.txtProductPrice.text = "${product.price}"
        if(product.images.isNotEmpty()){
            binding.imgProduct.load(product.images[0])
        }else{
            binding.imgProduct.setImageResource(R.drawable.sin_imagen)
        }
    }

}