package com.algebra.criminalintent

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algebra.criminalintent.model.Crime
import com.algebra.criminalintent.model.Data
import java.text.SimpleDateFormat

class CrimeListFragment : Fragment() {

    private lateinit var rView     : RecyclerView
    private lateinit var  mAdapter : CrimeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate( R.layout.fragment_crime_list, container, false )

        rView = v.findViewById( R.id.list_recycler_view )
        rView.layoutManager = LinearLayoutManager( activity )

        updateUI( )

        return v;
    }

    fun updateUI( ) {
        mAdapter = CrimeAdapter( this )
        rView.adapter = mAdapter
    }

}

class CrimeHolder( inflater: LayoutInflater, parent : ViewGroup?, val fragment : Fragment )
    : RecyclerView.ViewHolder( inflater.inflate( R.layout.crime, parent, false ) ), View.OnClickListener {

    private lateinit var tvName : TextView
    private lateinit var tvDate : TextView
    private lateinit var crime  : Crime

    init {
        tvName = itemView.findViewById( R.id.tvName )
        tvDate = itemView.findViewById( R.id.tvDate )
        itemView.setOnClickListener( this )
    }

    fun bind( crime:Crime ) {
        this.crime = crime
        tvName.text = crime.name
        tvDate.text = SimpleDateFormat( "dd.MM.yyyy." ).format( crime.date )
    }

    override fun onClick( v: View? ) {
        val startSecondActivity = Intent( fragment.context, CrimeActivity::class.java ).apply {
            putExtra( KEY_CRIME_ID, crime.id )
        }
        fragment.startActivity( startSecondActivity )
    }
}

class CrimeAdapter( val fragment : CrimeListFragment ) : RecyclerView.Adapter< CrimeHolder >( ) {

    val mCrimes = Data.crimes

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): CrimeHolder {
        return CrimeHolder( LayoutInflater.from( fragment.activity ), parent, fragment )
    }

    override fun onBindViewHolder( holder: CrimeHolder, position: Int ) {
        holder.bind( mCrimes[position] )
    }

    override fun getItemCount(): Int {
        return mCrimes.size
    }

}