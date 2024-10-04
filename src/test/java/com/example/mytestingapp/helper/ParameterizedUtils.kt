package com.example.mytestingapp.helper

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters


@RunWith(value = Parameterized::class)
class ParameterizedUtils(val input:String, val expected:Boolean) {



    @Test
    fun test_is_palindrome(){
        val utils = Utils()
        var result = utils.isPalindrome(input)
        Assert.assertEquals(result, expected)
    }

    companion object{
        @JvmStatic
        @Parameters(name = "{index} : {0} is palindrome - {1}")
        fun data():List<Array<Any>>{
            return listOf(
                arrayOf("hello", false),
                arrayOf("madam", true),
                arrayOf("hello1", false)

            )
        }
    }
}