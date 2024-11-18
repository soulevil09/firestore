package br.edu.fatecpg.produtos.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.fatecpg.produtos.adapter.ProdutosListAdapter
import br.edu.fatecpg.produtos.dao.ProdutosDaoImpl
import br.edu.fatecpg.produtos.databinding.ActivityListaProdutosBinding
import br.edu.fatecpg.produtos.model.Produtos

class ListaProdutos : AppCompatActivity() {
    private lateinit var binding: ActivityListaProdutosBinding
    private val dao = ProdutosDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        dao.obterProdutos().addOnSuccessListener { result ->
            val produtos = result.map { doc ->
                doc.toObject(Produtos::class.java)
            }
            binding.recyclerView.adapter = ProdutosListAdapter(this, produtos)
        }.addOnFailureListener {
            // Handle failure (e.g., show a toast)
        }
    }
}
