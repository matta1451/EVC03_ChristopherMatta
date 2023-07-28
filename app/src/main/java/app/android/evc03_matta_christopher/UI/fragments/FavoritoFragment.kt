package app.android.evc03_matta_christopher.UI.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.android.evc03_matta_christopher.databinding.FragmentFavoriteBinding
import coil.load

class FavoritoFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.ObtenerProducto(28).observe(viewLifecycleOwner, Observer {
            if(it.images.isNotEmpty()) {
                binding.imgProduct.load(it.images[0])
            }
            binding.valorCodProd.text = "0000${it.id}"
            binding.valorTitleProd.text = it.title
            binding.valorPriceProd.text = "$ ${it.price.toString()}"
        })
    }

}