package com.example.tugasrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugasrecyclerview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var adapterFruit = FruitAdapter(generateFruitsData()){
                fruit ->  Toast.makeText(this@MainActivity, "you choose on ${fruit.name}",
            Toast.LENGTH_SHORT).show()

        }
        with(binding){
            rvFruit.apply {
                adapter = adapterFruit
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun generateFruitsData() : List<Fruit>{
        return listOf(
            Fruit(name = "Apple", harga = "8 juta", lokasi = "amerika", R.drawable.apel1 ),
            Fruit(name = "Jeruk", harga = "8 ribu", lokasi = "indonesia", R.drawable.jeruk1),
            Fruit(name = "Sawo", harga = "8 ratus rupiah", lokasi = "jawa", R.drawable.sawo1),
            Fruit(name = "cherry", harga = "8 ratus ribu", lokasi = "belanda", R.drawable.cherry1),

        )
    }
}