package com.example.androidfakeuser

import com.example.androiduserexcercise.model.ResponseData

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfakeuser.databinding.ActivityMainBinding
import com.example.androiduserexcercise.adapter.AdapterData
import com.example.androiduserexcercise.util.Utildata
import retrofit2.Response
import retrofit2.Call

import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    //variables
    val ITEM_COUNT = 21
    var total_item = 0
    var last_visible_item = 0


    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { AdapterData(this) }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id ==R.id.refresh){

        }

        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvProduct.adapter = adapter

        Utildata.service.getAllProduct().enqueue(object : Callback<ResponseData>{
            override fun onResponse(
                call: Call<ResponseData>,
                response: Response<ResponseData>

            ){
                if (response.isSuccessful){
                    response.body()?.let { adapter.setData(it.data) }
                    Toast.makeText(this@MainActivity, "berhasil", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(this@MainActivity, "gagal rekl", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                t.printStackTrace()

                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}