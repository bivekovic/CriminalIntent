package com.algebra.criminalintent

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import com.algebra.criminalintent.model.Data
import java.text.SimpleDateFormat


class CrimeFragment : Fragment() {

    private lateinit var tvID     : TextView
    private lateinit var etName   : EditText
    private lateinit var bDate    : Button
    private lateinit var cbSolved : CheckBox
    private lateinit var bWeb     : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate( R.layout.fragment_crime, container, false )
        val crimeId = arguments?.getInt( KEY_CRIME_ID, 1 ) ?:1
        initWidgets( v )
        println( crimeId )
        fillWithCrime( crimeId )

        return v
    }

    fun initWidgets( v : View ) {
        tvID     = v.findViewById( R.id.tvID )
        etName   = v.findViewById( R.id.etName )
        bDate    = v.findViewById( R.id.bDate )
        cbSolved = v.findViewById( R.id.cbSolved )
        bWeb     = v.findViewById( R.id.posjetiWeb )
        bWeb.setOnClickListener {
            val startSecondActivity = Intent( activity, WebActivity::class.java ).apply {
                putExtra( KEY_PAGE, "https://www.net.hr" )
            }
            startActivity( startSecondActivity )
        }
    }

    fun fillWithCrime( id:Int ) {
        val sdf = SimpleDateFormat( "dd.MM.yyyy." )
        val crimeInAList = Data.crimes.filter { it.id==id }
        if( !crimeInAList.isEmpty( ) ) {
            val crime = crimeInAList[0]
            val solved = crime.solved
            tvID.text = "" + crime.id
            etName.setText(crime.name)
            bDate.setText(sdf.format(crime.date))
            if (solved != null)
                cbSolved.setChecked(solved)
        }
    }

}