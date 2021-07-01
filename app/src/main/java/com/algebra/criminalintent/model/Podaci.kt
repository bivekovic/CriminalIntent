package com.algebra.criminalintent.model

import java.text.SimpleDateFormat
import java.util.*

object Data {
    var crimes = mutableListOf< Crime >( )
    init {
        val sdf = SimpleDateFormat( "dd.MM.yyyy." )
        crimes.add( Crime( 1, "Oteti premijer",      sdf.parse( "25.02.1990." ), false ) )
        crimes.add( Crime( 2, "Smrt na Nilu",        sdf.parse( "12.04.2004." ), true ) )
        crimes.add( Crime( 3, "Ubojstva po abecedi", sdf.parse( "05.01.1992." ), false ) )
        crimes.add( Crime( 4, "Tiha voda",           sdf.parse( "24.01.1993." ), false ) )
    }
}

class Crime( var id:Int?, var name:String?, var date: Date?, var solved:Boolean? ) {
    constructor( ) : this( null, null, null, null )
}