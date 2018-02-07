package com.ynatechnologies.ankoanddialogs

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_custom.*
import kotlinx.android.synthetic.main.dialog_custom.view.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Alert Dialog Using Kotlin's Anko Library....
        anko_alert_dialog.setOnClickListener({
            val alertDialog = alert("Did you just triggered anko alert Dialog?", "Hey, Listen!")
            alertDialog.isCancelable = false
            alertDialog.positiveButton("Yes", {
                toast("Yes, I did!")
            })
            alertDialog.negativeButton("No", {
                toast("No, I didn't!")
            })
            alertDialog.show()
        })


        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialogLayout: View = inflater.inflate(R.layout.dialog_custom, dialog_sign_in)
        builder.setView(dialogLayout)
        builder.setCancelable(false)
        builder.setTitle("Sign In")
        val loginDialog: AlertDialog = builder.create()

        // Custom Dialog
        custom_dialog.setOnClickListener({
            loginDialog.show()
        })

        dialogLayout.cancel_button.setOnClickListener({
            toast("Cancel Button Pressed!")
            if(loginDialog.isShowing) loginDialog.dismiss()
        })

        dialogLayout.sign_in_button.setOnClickListener({
            toast("Sign In button is clicked!")
            if(loginDialog.isShowing) loginDialog.dismiss()
        })


    }
}
