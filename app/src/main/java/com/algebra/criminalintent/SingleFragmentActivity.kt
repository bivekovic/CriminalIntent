package com.algebra.criminalintent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class SingleFragmentActivity : AppCompatActivity( ) {

    abstract fun createFragment( ) : Fragment

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_single_fragment )

        supportFragmentManager
            ?.beginTransaction()
            ?.replace( R.id.fragment_container, createFragment( ) )
            ?.commit( )
    }

}