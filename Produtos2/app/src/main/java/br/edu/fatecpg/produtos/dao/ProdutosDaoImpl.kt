package br.edu.fatecpg.produtos.dao

import br.edu.fatecpg.produtos.model.Produtos
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class ProdutosDaoImpl : ProdutosDao {
    private val db = FirebaseFirestore.getInstance()
    private val produtosCollection = db.collection("produtos")

    override fun adicionarProduto(produto: Produtos): Task<Void> {
        return produtosCollection.document().set(produto)
    }

    override fun obterProdutos(): Task<QuerySnapshot> {
        return produtosCollection.get()
    }
}
