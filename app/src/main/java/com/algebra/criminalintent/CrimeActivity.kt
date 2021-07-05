package com.algebra.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import java.util.*

const val KEY_CRIME_ID = "CRIME_ID"

class CrimeActivity : SingleFragmentActivity( ) {

    private var crimeId : Int = -1

    override fun createFragment( ): Fragment {
        return CrimeFragment( )
    }

    override fun getBundle( ): Bundle {
        return Bundle( ).apply {
            putInt( KEY_CRIME_ID, crimeId )
        }
    }

    override fun onCreate( savedInstanceState: Bundle? ) {
        crimeId = intent?.getIntExtra( KEY_CRIME_ID, -1 ) ?: -1
        super.onCreate( savedInstanceState )

    }
}