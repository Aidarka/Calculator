package com.example.calc


public class Calculator( _a:Double) {

     var a: Double = _a
    operator fun plus(b: Calculator) : Double = this.a + b.a
    operator fun minus(b:Calculator) : Double = this.a - b.a
    operator fun times(b:Calculator) : Double = this.a * b.a
    operator fun div(b:Calculator) : Double = this.a / b.a
    fun sqrt() : Double = kotlin.math.sqrt(a)
    fun unary() : Double = -a
}