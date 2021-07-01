package com.algebra.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

const val KEY_CRIME_ID = "CRIME_ID"

class CrimeActivity : SingleFragmentActivity( ) {

    override fun createFragment( ): Fragment {
        return CrimeFragment( )
    }
}