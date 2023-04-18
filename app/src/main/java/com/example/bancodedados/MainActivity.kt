package com.example.bancodedados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.DEBUG_PROPERTY_VALUE_AUTO

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {

            //Criar Banco de Dados
            val dataBase = openOrCreateDatabase( "DB_SUPPLIERS", MODE_PRIVATE, null)

            //Criar uma Tabela
            dataBase.execSQL("CREATE TABLE IF NOT EXISTS supplierS(name VARCHAR, telephone INT(4) )")

            //Inserir Dados em uma Tabela
            dataBase.execSQL("INSERT INTO suppliers(name, telephone) VALUES ('GOURMET SNACKS', 3697)")

            val query = "SELECT name, telephone FROM suppliers"

            val cursor = dataBase.rawQuery( query, null)

            //Recuperar os Indices da Nossa Tabela
            val indiceName = cursor.getColumnIndex("name")
            val indiceTelephone = cursor.getColumnIndex("telephone")
            cursor.moveToFirst()

            while (cursor != null){

                val name = cursor.getString(indiceName)
                val telephone = cursor.getString(indiceTelephone)
                Log.i("RESULT", "/name: $name / telephone: $telephone")
                cursor.moveToNext()
            }

        }catch (e: Exception){
            e.printStackTrace()
        }

    }
}