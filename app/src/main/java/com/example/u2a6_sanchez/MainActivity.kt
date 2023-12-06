package com.example.u2a6_sanchez

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {

    val currentUsername : String? = null
    lateinit var customToolBar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customToolBar = findViewById(R.id.customTool)
        setSupportActionBar(customToolBar)
        //customToolBar.setBackgroundColor(Color.TRANSPARENT)

        contextMenu()
        start()
    }

    fun start(){

        val btnStart : Button = findViewById(R.id.btnStart)
        btnStart.setOnClickListener{view ->
            mostrarDialogo(view)
        }
        //customToolBar.title = "AppMental"
        customToolBar.setTitleTextColor(Color.TRANSPARENT)

    }

    //menú contextual
    fun contextMenu(){
        val middleImage : ImageView = findViewById(R.id.imageMiddle)
        registerForContextMenu(middleImage) //Asociar menú contextual al componente appTitle
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater : MenuInflater = menuInflater //rellenamos este menú con el fichero .xml siguiente...
        inflater.inflate(R.menu.contextmenu, menu) //contextmenu.xml
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {
        //val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        return when (item.itemId) {
            R.id.mnContext1 -> {
                Toast.makeText(this, showUsername(), Toast.LENGTH_LONG).show()
                true
            }

            R.id.mnContext2-> {
                Toast.makeText(this, showCurrentDate(), Toast.LENGTH_LONG).show()
                true
            }

            R.id.mnContext3 -> {
                val toast = Toast.makeText(this, showDevInfo(), Toast.LENGTH_LONG)
                toast.show()
                true
            }

            else -> super.onContextItemSelected(item)

        }
    }

    fun showCurrentDate() : String{
        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate : String = resources.getString(R.string.context2Info) + " " + sdf.format(Date()).toString()

        return currentDate
    }

    fun showDevInfo(): String{
        val devInfo : String
        devInfo = resources.getString(R.string.context3Info)
        return devInfo
    }

    fun showUsername() : String{
        val username : String
        if (currentUsername != null){
            username = resources.getString(R.string.context1Info)
        }else{
            username = resources.getString(R.string.context1InfoNoUser)
        }
        return username
    }

    //opt menu
    override fun onCreateOptionsMenu(menu : Menu): Boolean{ //"3 puntitos", onCreateOptionsMenu
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menuajustes, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.mnAjustesOp1 -> {
                Toast.makeText(this, "Change function not implemented yet", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.mnAjustesOp2 -> {
                Toast.makeText(this, "Advices not implemented yet", Toast.LENGTH_SHORT).show()
                true

            }

            R.id.mnAjustesOp3 -> {
                Toast.makeText(this, "Information not implemented yet", Toast.LENGTH_SHORT).show()
                true

            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun mostrarDialogo(view : View){
        val dialog = Dialogo()
        dialog.showMaterial(this)
    }
}