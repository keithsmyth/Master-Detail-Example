package com.keithsmyth.example.masterdetailexample.data

import java.util.concurrent.Executor
import java.util.concurrent.Executors

object Threading {

    val ioExecutor: Executor = Executors.newSingleThreadExecutor()

}
