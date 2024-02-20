package com.cinar.contextalert

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.cinar.contextalert.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var  binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        


        binding.textView.text = "save job"

       //Uyarı mesajı çeşitleri
    //1) Toast  2) AlertDioalog 3)Snackbar

        //Context çeşitleri
        //Activity context -> this  yada this@MainActivity şeklinde gözükür
        //Application context

        //1 Toast
        Toast.makeText(this,"Welcome",Toast.LENGTH_LONG).show()

        /*
        binding.save.setOnClickListener {
            println(it)
        }

        //Interface classlara durumu belirlemesi yapar ne yapacağını söyler
        binding.save.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                TODO("Not yet implemented")
               // burada  this interfaceye götürür
                // this@MainActivity  yazmalı burda o zaman mainActivitye gider kod.

            }

        })*/
    }

    fun save(view:View){
        //2 Alert Diaolog
        val alert = AlertDialog.Builder(this@MainActivity)
        alert.setTitle("Save")
        alert.setMessage("Are you sure ?")

        alert.setPositiveButton("Yes",object :DialogInterface.OnClickListener{
            override fun onClick(p0: DialogInterface?, p1: Int) {
                Toast.makeText(this@MainActivity,"Saved !",Toast.LENGTH_LONG).show()
                binding.textView.text = " Save using"
            }
        })

        // Lamda negative button
        alert.setNegativeButton("No"){
            p0,p1 ->
            Toast.makeText(this@MainActivity,"Not saved !",Toast.LENGTH_LONG).show()
            binding.textView.text = "Not save used"
        }
        alert.show()


    }
}
