package com.example.bancodedados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {

            //Criar Banco de Dados
            val dataBase = openOrCreateDatabase( "DB_SUPPLIERS", MODE_PRIVATE, null)

            //Criar uma Tabela
            dataBase.execSQL("CREATE TABLE IF NOT EXISTS supplierS(name VARCHAR, telephone INT(4) )")

        }catch (e: Exception){
            e.printStackTrace()
        }

    }
}