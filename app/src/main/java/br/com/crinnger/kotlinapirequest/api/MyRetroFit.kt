package br.com.crinnger.kotlinapirequest.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetroFit {

    private val retrofit :Retrofit

    fun productApi():ProductApi{
        return retrofit.create(ProductApi::class.java)
    }

    companion object{
        private const val BASE_URL="https://uniqueandrocode.000webhostapp.com/hiren/androidtutorial/mycart/"

        var myRetroFit:MyRetroFit?=null


        @get:Synchronized
        val instance:MyRetroFit?
            get(){
                if(myRetroFit==null){
                    myRetroFit= MyRetroFit()
                }
                return myRetroFit
            }
    }

    init{
        this.retrofit=Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
    }
}