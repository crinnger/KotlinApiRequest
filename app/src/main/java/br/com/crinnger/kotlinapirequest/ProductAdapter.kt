package br.com.crinnger.kotlinapirequest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.crinnger.kotlinapirequest.model.Product
import com.bumptech.glide.Glide

class ProductAdapter(private val context: Context, private val productList:List<Product>)
    :RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val productImage=itemView.findViewById<ImageView>(R.id.product_image)
        val productName:TextView=itemView.findViewById(R.id.product_name)
        val productPrice=itemView.findViewById(R.id.product_price) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item,parent,false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item=productList[position]
        holder.productName.text=item.prName
        holder.productPrice.text=item.prPrice
// carrega a imagem em background
        Glide.with(context).load(item.prImage).into(holder.productImage)
    }

    override fun getItemCount(): Int= productList.size
}