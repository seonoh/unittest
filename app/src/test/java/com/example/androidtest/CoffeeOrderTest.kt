package com.example.androidtest

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class CoffeeOrderTest {
    private val PRICE_TEST = 5.0f
    private lateinit var mOrder : CoffeeOrder

    @Before
    fun setUp(){
        mOrder = CoffeeOrder(PRICE_TEST)
    }

    @Test
    fun orderIsNotNull(){
        assertNotNull(mOrder)
    }
    @Test
    fun orderDecrement(){
        mOrder.decrementCoffeeCount()
        assertEquals(0, mOrder.mCoffeeCount)

        mOrder.mCoffeeCount = 25
        mOrder.decrementCoffeeCount()
        assertEquals(24,mOrder.mCoffeeCount)
    }


    @Test
    fun orderIncrement(){
        mOrder.incrementCoffeeCount()
        assertEquals(1,mOrder.mCoffeeCount)

        mOrder.initCoffeeCount(25)
        mOrder.incrementCoffeeCount()
        assertEquals(26,mOrder.mCoffeeCount)

    }

    @Test
    fun orderTotalPrice(){
        assertEquals(0.0f, mOrder.mTotalPrice)

        mOrder.initCoffeeCount(25)
        assertEquals(PRICE_TEST*25, mOrder.mTotalPrice)
    }

    @Test
    fun orderSetCoffeeCount(){
        mOrder.initCoffeeCount(-1)
        assertEquals(-1, mOrder.mCoffeeCount)

        mOrder.initCoffeeCount(25)
        assertEquals(25, mOrder.mCoffeeCount)
    }
}