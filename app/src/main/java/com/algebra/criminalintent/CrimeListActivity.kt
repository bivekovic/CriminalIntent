package com.algebra.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class CrimeListActivity : SingleFragmentActivity( ) {

    override fun createFragment( ): Fragment {
        return CrimeListFragment( )
    }
}