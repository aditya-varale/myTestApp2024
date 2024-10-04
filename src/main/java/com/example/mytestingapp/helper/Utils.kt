package com.example.mytestingapp.helper

class Utils {
    fun isPalindrome(str : String) : Boolean {
        var left = 0
        var right = str.length - 1

        while(left < right){
            if(str[left].lowercaseChar() != str[right].lowercaseChar())
                return false


            left++
            right--
        }

        return true
    }
}