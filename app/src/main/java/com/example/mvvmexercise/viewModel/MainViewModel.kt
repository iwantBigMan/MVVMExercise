package com.example.mvvmexercise.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexercise.module.Database
import kotlin.random.Random

class MainViewModel: ViewModel() {
    private val database: Database = Database()
    private var rand = Random

    var nowNum = -1

    companion object{
        var MaxNum = 101
    }

    var text: MutableLiveData<String> = MutableLiveData()

    init {
        text.value = ""
    }

    fun getNum(){
        nowNum = rand.nextInt(MaxNum) + 1
        database.saveNumber(nowNum)
        text.value = nowNum.toString()
    }

    fun setMaxNum(int: Int?){
        println(int)
        MaxNum = int!!
    }

    fun showAllNum() {
        if (nowNum == -1)
            return

        text.value = ""
        var array: ArrayList<Int> = ArrayList()

        array = database.getAllNumber()

        for (i in 0 until array.size) {
            text.value += array[i].toString() + " "
        }
        println(text)
    }
}