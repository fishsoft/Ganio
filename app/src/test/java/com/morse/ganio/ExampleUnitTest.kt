package com.morse.ganio

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test() {
        val user = User("Kotlin", 1, "1111111")

//        val withResult = with(user) {
//            println("my name is $name, I am $age years old, my phone number is $phoneNum")
//            1000
//        }
//        println("result: $withResult")
//
//        var runResult = user.run {
//            println("my name is $name, I am $age years old, my phone number is $phoneNum")
//            1001
//        }
//        print("result: $runResult")

//        var list: List<String>? = null
//        var letResult = list?.let {
//            print("let $list")
//            1002
//        }
//
//        with(list){
//            print("with $list")
//        }
//        list.run {
//            print("run $list")
//        }

//        print("result:$letResult")

    }
}

data class User(var name: String?, var age: Int, var phoneNum: String)
