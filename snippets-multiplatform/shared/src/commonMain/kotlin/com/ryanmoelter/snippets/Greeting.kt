package com.ryanmoelter.snippets

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}