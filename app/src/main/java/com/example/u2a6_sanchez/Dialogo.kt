package com.example.u2a6_sanchez

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class Dialogo : DialogFragment() {

    fun showMaterial(activity: FragmentActivity): Dialog {
        return MaterialAlertDialogBuilder(activity)
            .setTitle(R.string.mnPregunta) //Pregunta puesta en title y no en message porque si no el setItems no se reflejaba
            //.setMessage(R.string.mnPregunta)
            .setItems(R.array.listaOpciones){ dialog, which ->
            //which es para saber el que se ha elegido, ya que almacena su índice
                val arrayOpciones = activity.resources.getStringArray(R.array.listaOpciones)
                Toast.makeText(activity, "You have chosen " + arrayOpciones[which], Toast.LENGTH_LONG).show()


            }
            .show()
    }
}