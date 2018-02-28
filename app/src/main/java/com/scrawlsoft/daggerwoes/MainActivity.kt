package com.scrawlsoft.daggerwoes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {
    @set:Inject
    @set:Named("someStringOrNull")
    var someStringOrNull: String? = null

    @field:Inject
    @field:Named("someStringWithAName")
    lateinit var someStringWithName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as DaggerWoesApp).appComponent.inject(this)
        setContentView(R.layout.activity_main)

        Log.d("FOOBAR", someStringWithName)
        Log.d("FOOBAR", someStringOrNull)
    }
}
