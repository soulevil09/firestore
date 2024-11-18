package br.edu.fatecpg.produtos.dao

import br.edu.fatecpg.produtos.model.Produtos
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot

interface ProdutosDao {
    fun adicionarProduto(produto: Produtos): Task<Void>
    fun obterProdutos(): Task<QuerySnapshot>
}