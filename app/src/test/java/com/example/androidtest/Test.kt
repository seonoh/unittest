package com.example.androidtest

import junit.framework.Assert.assertEquals
import org.junit.Test

class Test{

    fun plus(a : Int, b : Int) : Int { return a+b }

    @Test
    fun plusOperationTest() {
        assertEquals(5,plus(2,3))
    }



}