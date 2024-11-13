package com.aditya.popupmenu

import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener { showPopupMenu(btn) }
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        val inflater: MenuInflater = popupMenu.menuInflater
        inflater.inflate(R.menu.popup_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.add -> {
                    Toast.makeText(this, "Added", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.delete -> {
                    Toast.makeText(this, "Deleted", Toast.LENGTH_LONG).show()
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
}
