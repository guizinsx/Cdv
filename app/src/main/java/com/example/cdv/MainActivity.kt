package com.example.cdv

import android.app.ActionBar.LayoutParams
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.example.cdv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private companion object{
        const val CICLO_PDM = "CLICO_PDM"
        const val CONTEUDO = "CONTEUDO"
    }

    private lateinit var dinamicoEt: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        Log.v(CICLO_PDM, "onCreate: Iniciando ciclo COMPLETO")

        val parametrosView = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        parametrosView.setMargins(0, 10, 0, 0)
        dinamicoEt = EditText(this)
        dinamicoEt.hint = "EditText dinamico"
        dinamicoEt.layoutParams = parametrosView
        amb.root.addView(dinamicoEt)

        savedInstanceState?.getString(CONTEUDO)?.let {
            Toast.makeText(this, "Restaurando dados na onCreate", Toast.LENGTH_SHORT).show()
            dinamicoEt.setText(it)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.v(CICLO_PDM, "onStart: Iniciando ciclo VISIVEL")

    }

    override fun onResume() {
        super.onResume()
        Log.v(CICLO_PDM, "onResume: Iniciando ciclo EM PRIMEIRO PLANO")

    }

    override fun onPause() {
        super.onPause()
        Log.v(CICLO_PDM, "onPause: Finalizando ciclo EM PRIMEIRO PLANO")
    }

    override fun onStop() {
        super.onStop()
        Log.v(CICLO_PDM, "onStop: Finalizando ciclo em VISIVEL")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(CICLO_PDM, "onDestroy: Finalizando ciclo em COMPLETO")
    }

    //OPCIONAL
    override fun onRestart() {
        super.onRestart()
        Log.v(CICLO_PDM, "onRestart: Preparando execucao do onStart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.v(CICLO_PDM, "Salvando dados de instancia!!!!")
        outState.putString(CONTEUDO, dinamicoEt.text.toString())
    }

//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        Log.v(CICLO_PDM, "Restaurando dados de instancia")
//        savedInstanceState.getString(CONTEUDO)?.let {
//            dinamicoEt.setText(it)
//        }
//    }
}