package com.example.mytestingapp.helper

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class UtilsTest {

    lateinit var utils: Utils

    @Before
    fun setUp(){
        println("Before SetUp")
        //ARRANGE
        utils = Utils()
    }

    @After
    fun tearDown(){
        println("Before Tear Down")
    }


    @Test
    fun isPalindrome_input_hello_expectedFalse() {

        //ACT
        var result = utils.isPalindrome("hello")
        //ASSERT
        Assert.assertFalse(result)
    }

    @Test
    fun isPalindrome_input__case_upper_Hello_expectedFalse() {

        //ACT
        var result = utils.isPalindrome("Hello")
        //ASSERT
        Assert.assertFalse(result)
    }

    @Test
    fun isPalindrome_input_madam_expectedTrue() {

        //ACT
        var result = utils.isPalindrome("madam")
        //ASSERT
        Assert.assertTrue(result)
    }

    @Test
    fun isPalindrome_input_case_upper_madam_expectedTrue() {

        //ACT
        var result = utils.isPalindrome("Madam")
        //ASSERT
        Assert.assertTrue(result)
    }


}