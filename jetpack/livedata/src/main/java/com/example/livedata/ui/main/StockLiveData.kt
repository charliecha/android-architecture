package com.example.livedata.ui.main

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import java.math.BigDecimal

class StockManager(val symbol: String) {
    fun requestPriceUpdates(listener: (BigDecimal) -> Unit) {
    }

    fun removeUpdates(listener: (BigDecimal) -> Unit) {
    }
}

class StockLiveData(symbol: String) : LiveData<BigDecimal>() {
    private val stockManager: StockManager = StockManager(symbol)

    private val listener = { price: BigDecimal ->
        value = price
    }

    override fun onActive() {
        stockManager.requestPriceUpdates(listener)
    }

    override fun onInactive() {
        stockManager.removeUpdates(listener)
    }

    companion object {
        private lateinit var sInstance: StockLiveData

        @MainThread
        fun get(symbol: String): StockLiveData {
            sInstance = if (::sInstance.isInitialized) sInstance else StockLiveData(symbol)
            return sInstance
        }
    }
}