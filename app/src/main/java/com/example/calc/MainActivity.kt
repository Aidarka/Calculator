package com.example.calc
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity()
{
    var op: Char = ' '
    lateinit var a: Calculator
    lateinit var b: Calculator

    private fun evaluateExpression(string: String, clear: Boolean) = if(clear) {
        res.text = ""
        exp.append(string)
    } else {
        exp.append(res.text)
        exp.append(string)
        res.text = ""
    }

    private fun opr(c:Char, a:Calculator, b:Calculator):Double {
        return when (c) {
            '+' -> a + b
            '-' -> a - b
            '*' -> a * b
            '/' -> a / b
            else -> 0.0
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn1.setOnClickListener {
            evaluateExpression("1", clear = true)
        }

        btn2.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        btn3.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        btn4.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        btn5.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        btn6.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        btn7.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        btn8.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        btn9.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        btn0.setOnClickListener {
            evaluateExpression("0", clear = true)
        }


        P.setOnClickListener {
//            evaluateExpression("+", clear = true)
            when {
                op == ' ' -> {
                    a = Calculator(exp.text.toString().toDouble())
                    op = '+'
                    exp.text=""
                }
                exp.text != null -> {
                    b = Calculator(exp.text.toString().toDouble())
                    res.text = opr(op,a,b).toString()
                    a = Calculator(opr(op,a,b))
                    op = '+'
                    exp.text=""
                }
                else -> op = '+'
            }
        }

        M.setOnClickListener {
//            evaluateExpression("-", clear = true)
            when {
                op == ' ' -> {
                    a = Calculator(exp.text.toString().toDouble())
                    op = '-'
                    exp.text=""
                }
                exp.text != null -> {
                    b = Calculator(exp.text.toString().toDouble())
                    res.text = opr(op,a,b).toString()
                    a = Calculator(opr(op,a,b))
                    op = '-'
                    exp.text=""
                }
                else -> op = '-'
            }
        }

        mult.setOnClickListener {
//            evaluateExpression("*", clear = true)
            when {
                op == ' ' -> {
                    a = Calculator(exp.text.toString().toDouble())
                    op = '*'
                    exp.text=""
                }
                exp.text != null -> {
                    b = Calculator(exp.text.toString().toDouble())
                    res.text = opr(op,a,b).toString()
                    a = Calculator(opr(op,a,b))
                    op = '*'
                    exp.text=""
                }
                else -> op = '*'
            }
        }

        div.setOnClickListener {
//            evaluateExpression("/", clear = true)
            when {
                op == ' ' -> {
                    a = Calculator(exp.text.toString().toDouble())
                    op = '/'
                    exp.text=""
                }
                exp.text != null -> {
                    b = Calculator(exp.text.toString().toDouble())
                    res.text = opr(op,a,b).toString()
                    a = Calculator(opr(op,a,b))
                    op = '/'
                    exp.text=""
                }
                else -> op = '/'
            }
        }

        btnt.setOnClickListener {
            evaluateExpression(".", clear = true)
        }

        CE.setOnClickListener {
            exp.text = ""
            res.text = ""
        }

        SQRT.setOnClickListener {

            if(exp.text == null) {
                a = Calculator(res.text.toString().toDouble())
                res.text = a.sqrt().toString()
            }
            else if(op != ' '){
                b = Calculator(exp.text.toString().toDouble())
                val d = Calculator(b.sqrt())
                res.text = opr(op, a, d).toString()
                op = ' '
            }
            else {
                a = Calculator(exp.text.toString().toDouble())
                res.text = a.sqrt().toString()
            }
        }

        PM.setOnClickListener {
            if(exp.text == null) {
                val d = Calculator(exp.text.toString().toDouble())
                exp.text = d.unary().toString()
            }
        }

        equal.setOnClickListener {
            if(op != ' ') {
                b = Calculator(exp.text.toString().toDouble())
                res.text = opr(op, a, b).toString()
                exp.text = ""
                op = ' '
            }
        }

        back.setOnClickListener {
            val text = exp.text.toString()
            if(text.isNotEmpty()) {
                exp.text = text.drop(1)
            }
            res.text = ""
        }
    }
}