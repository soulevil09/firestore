package br.edu.fatecpg.produtos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.produtos.databinding.ProdutoItemBinding
import br.edu.fatecpg.produtos.model.Produtos

class ProdutosListAdapter(
    private val context: Context,
    private val produtos: List<Produtos>
) : RecyclerView.Adapter<ProdutosListAdapter.ViewHolder>() {

    class ViewHolder(private val produtoItemBinding: ProdutoItemBinding) :
        RecyclerView.ViewHolder(produtoItemBinding.root) {

        fun bind(produto: Produtos) {
            produtoItemBinding.title.text = produto.nome
            produtoItemBinding.category.text = produto.categoria
            produtoItemBinding.price.text = produto.preco.toString()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoItemBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int = produtos.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.bind(produto)
    }
}
