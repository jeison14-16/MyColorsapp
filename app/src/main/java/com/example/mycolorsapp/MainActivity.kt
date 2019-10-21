package com.example.mycolorsapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import android.widget.Toolbar

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private var sbrRed: SeekBar? = null
    private var sbrGreen: SeekBar? = null
    private var sbrBlue: SeekBar? = null
    private var sbrAlpha: SeekBar? = null
    private var vieColors: View? = null

    private val toolbar: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        igualarIds()

        sbrGreen!!.setOnSeekBarChangeListener(this)
        sbrBlue!!.setOnSeekBarChangeListener(this)
        sbrRed!!.setOnSeekBarChangeListener(this)
        sbrAlpha!!.setOnSeekBarChangeListener(this)



        registerForContextMenu(vieColors)

        registerForContextMenu(vieColors)


        //toolbar= findViewById(R.id.toolbarSeekbar);
        //setActionBar(toolbar);
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menubar, menu)
        inflater.inflate(R.menu.colors, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        switchecase(item)
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.colors, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        //
        switchecase(item)
        return super.onContextItemSelected(item)
    }

    fun switchecase(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemBlue -> {
                cambiarColorsito(0, 0, 255, 200, "blue")
                return true
            }
            R.id.itemRed -> {
                cambiarColorsito(255, 0, 0, 200, "red")
                return true
            }
            R.id.itemTransparent -> {
                cambiarColorsito(0, 0, 0, 0, "transparent")
                return true
            }
            R.id.itemSemitransparent -> {
                cambiarColorsito(0, 0, 0, 125, "semi transparent")
                return true
            }
            R.id.itemGreen -> {
                cambiarColorsito(35, 150, 35, 200, "green")
                return true
            }
            R.id.itemBrown -> {
                cambiarColorsito(99, 63, 33, 200, "brown")
                return true
            }
            R.id.itemBlack -> {
                cambiarColorsito(0, 0, 0, 200, "black")
                return true
            }
            R.id.itemPink -> {
                cambiarColorsito(200, 50, 130, 200, "pink")
                return true
            }
            R.id.itemPurple -> {
                cambiarColorsito(160, 30, 160, 200, "purple")
                return true
            }
            R.id.itemWhite -> {
                cambiarColorsito(255, 255, 255, 200, "white")
                return true
            }
            R.id.itemGray -> {
                cambiarColorsito(120, 120, 120, 200, "gray")
                return true
            }
            R.id.restoreColors -> {
                cambiarColorsito(0, 0, 0, 0, "null")
                return true
            }
            else -> return super.onContextItemSelected(item)
        }
    }

    override fun onProgressChanged(seekBar: SeekBar, i: Int, v: Boolean) {

        val r = sbrRed!!.progress
        val g = sbrGreen!!.progress
        val b = sbrBlue!!.progress
        val a = sbrAlpha!!.progress

        val color = Color.argb(a, r, g, b)
        vieColors!!.setBackgroundColor(color)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar) {

    }

    //eventos creados a mano
    fun cambiarColorsito(r: Int, g: Int, b: Int, a: Int, nameColor: String) {

        val color = Color.argb(a, r, g, b)
        igualarIds()
        vieColors!!.setBackgroundColor(color)
        Toast.makeText(this, "you have selected the $nameColor option", Toast.LENGTH_SHORT).show()
        sbrRed!!.progress = r
        sbrBlue!!.progress = b
        sbrGreen!!.progress = g
        sbrAlpha!!.progress = a

    }

    fun igualarIds() {
        sbrRed = findViewById(R.id.sbrRed)
        sbrGreen = findViewById(R.id.sbrGreen)
        sbrBlue = findViewById(R.id.sbrBlue)
        sbrAlpha = findViewById(R.id.sbrAlpha)
        vieColors = findViewById(R.id.vieColors)

    }

}
