package br.edu.fatecpg.produtos.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.produtos.R
import br.edu.fatecpg.produtos.dao.ProdutosDaoImpl
import br.edu.fatecpg.produtos.model.Produtos
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val dao = ProdutosDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtCategoria = findViewById<EditText>(R.id.edt_categoria)
        val edtPreco = findViewById<EditText>(R.id.edt_preco)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        btnSalvar.setOnClickListener {
            val nome = edtNome.text.toString()
            val categoria = edtCategoria.text.toString()
            val preco = edtPreco.text.toString().toIntOrNull() ?: 0

            if (nome.isNotEmpty() && categoria.isNotEmpty()) {
                val produto = Produtos(nome, categoria, preco)
                dao.adicionarProduto(produto).addOnSuccessListener {
                    Toast.makeText(this, "Produto salvo com sucesso!", Toast.LENGTH_SHORT).show()
                    edtNome.text.clear()
                    edtCategoria.text.clear()
                    edtPreco.text.clear()
                }.addOnFailureListener {
                    Toast.makeText(this, "Erro ao salvar produto!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }

        floatingActionButton.setOnClickListener {
            startActivity(Intent(this, ListaProdutos::class.java))
        }
    }
}
