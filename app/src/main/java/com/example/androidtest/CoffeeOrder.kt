package com.example.androidtest

class CoffeeOrder(coffeePrice : Float) {
    var mCoffeePrice = coffeePrice
    var mCoffeeCount =  0
        get() = if(field < 0) 0 else field

    var mTotalPrice = 0f

    fun initCoffeeCount(coffeeCount : Int){
        if(coffeeCount >= 0){
            mCoffeeCount = coffeeCount
        }
            calculateTotalPrice()
    }

    fun incrementCoffeeCount(){
        mCoffeeCount++
        calculateTotalPrice()
    }

    fun decrementCoffeeCount(){
        if( mCoffeeCount > 0){
            mCoffeeCount--
            calculateTotalPrice()
        }
    }

    fun calculateTotalPrice(){
        mTotalPrice = mCoffeePrice * mCoffeeCount
    }
}