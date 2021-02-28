package br.com.crinnger.kotlinapirequest.api

import br.com.crinnger.kotlinapirequest.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi{
    @GET("getdata.php")
    fun getProductApi():Call<List<Product>>
}
