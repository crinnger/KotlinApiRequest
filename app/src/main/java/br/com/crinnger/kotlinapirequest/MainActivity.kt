package br.com.crinnger.kotlinapirequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.crinnger.kotlinapirequest.api.MyRetroFit
import br.com.crinnger.kotlinapirequest.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclreProducts : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclreProducts=findViewById(R.id.recyclerProducts)
        recyclreProducts.layoutManager=LinearLayoutManager(this)
        getData()
    }

    private fun getData(){
        val call: Call<List<Product>> = MyRetroFit.instance?.productApi()?.getProductApi() as Call<List<Product>>

        call.enqueue(object : Callback<List<Product>>{
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                val adapter = ProductAdapter(this@MainActivity,response.body()?.toList() as List<Product>)
                recyclreProducts.adapter=adapter
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
}