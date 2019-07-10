package com.example.androidtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val COFFEE_COUNT = "coffee_count"
    val DEFAULT_COFFEE_PRICE = 5.0f

    private lateinit var mOrder : CoffeeOrder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mOrder = CoffeeOrder(DEFAULT_COFFEE_PRICE)

        coffee_price.text = String.format(getString(R.string.coffee_price),DEFAULT_COFFEE_PRICE)
        total_price.text = String.format(getString(R.string.total_price),0.0f)

        coffee_increment.setOnClickListener {
            mOrder.incrementCoffeeCount()
            updateCoffeeCount()
            updateTotalPrice()
        }

        coffee_decrement.setOnClickListener {
            mOrder.decrementCoffeeCount()
            updateCoffeeCount()
            updateTotalPrice()
        }
    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putInt(COFFEE_COUNT,mOrder.mCoffeeCount)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            mOrder.mCoffeeCount = savedInstanceState.getInt(COFFEE_COUNT)
            updateCoffeeCount()
            updateTotalPrice()
        }
    }

    private fun updateCoffeeCount(){
        coffee_count.text = ""+mOrder.mCoffeeCount

    }

    private fun updateTotalPrice(){
        total_price.text = String.format(getString(R.string.total_price),mOrder.mTotalPrice)
    }
}
