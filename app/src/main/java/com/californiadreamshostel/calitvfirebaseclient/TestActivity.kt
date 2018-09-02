package com.californiadreamshostel.calitvfirebaseclient

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.californiadreamshostel.firebaseclient.DataSchema
import com.californiadreamshostel.firebaseclient.FirebaseController

import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        FirebaseController(DataSchema.ANCILLIARY_GROUP){data, type ->
            Log.i("TEST", "DATA: ${data.reference}")
        }.register()
    }

}
