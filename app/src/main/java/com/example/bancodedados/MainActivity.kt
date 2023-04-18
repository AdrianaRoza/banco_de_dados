package com.example.bancodedados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            
            //Criar Banco de Dados
            val daraBase = openOrCreateDatabase( "DB_SUPPLIERS", MODE_PRIVATE, null)

        }catch (e: Exception){
            e.printStackTrace()
        }

    }
}