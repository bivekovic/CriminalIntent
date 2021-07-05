package com.algebra.criminalintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment

class CrimeListActivity : SingleFragmentActivity( ) {

    override fun createFragment( ): Fragment {
        return CrimeListFragment( )
    }

    override fun getBundle(): Bundle { return Bundle( ) }

    override fun onCreateOptionsMenu( menu: Menu? ): Boolean {
        menuInflater.inflate( R.menu.main, menu )
        return super.onCreateOptionsMenu( menu )
    }

    override fun onOptionsItemSelected( item: MenuItem ): Boolean {
        when( item.itemId ) {
            R.id.novi_film -> {
                // Toast.makeText( this, "Tu treba pokazati sučelje za unos novog filma", Toast.LENGTH_SHORT ).show( )
                val startSecondActivity = Intent( this, CrimeActivity::class.java )
                startActivity( startSecondActivity )
            }
            R.id.statistika -> {
                Toast.makeText( this, "Tu treba pokazati statistiku riješenih slučajeva", Toast.LENGTH_SHORT ).show( )
            }
        }
        return super.onOptionsItemSelected(item)
    }
}