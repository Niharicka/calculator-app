package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data: ArrayList<String> = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        var inflater: MenuInflater = getMenuInflater()
        inflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.history -> {
                var i: Intent = Intent(this, HistoryActivity::class.java)
                i.putStringArrayListExtra("data", data)
                startActivityForResult(i,0)
            }
            R.id.settings -> startActivity(Intent(this, SettingsActivity::class.java))
            R.id.aboutus -> startActivity(Intent(this, AboutUsActivity::class.java))

            else ->
                return false
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, d: Intent?) {
        super.onActivityResult(requestCode, resultCode, d)
        when(requestCode){
            0->{
                if(resultCode == 99) {
                    data.clear()
                }
            }
        }
    }

    fun textformatter(num: String) {

        //to clear first zero
        if (text2.text.length == 1 && text2.text == "0") {
            text2.text = ""
        }
        text2.text = "${text2.text}$num"
    }

    fun addition(a: Int, b: Int) {
        text1.text = text2.text.toString()
        text2.text = (a + b).toString()
    }

    fun multiply(a: Int, b: Int) {
        text1.text = text2.text.toString()
        text2.text = (a * b).toString()
    }


    fun division(a: Int, b: Int) {
        text1.text = text2.text.toString()
        text2.text = (a / b).toString()
    }

    fun subtraction(a: Int, b: Int) {
        text1.text = text2.text.toString()
        text2.text = (a - b).toString()
    }

    fun onClickBackspace(view: View) {
        val temp = text2.text.toString()
        if (temp.isNotEmpty())
            text2.text = temp.substring(0, temp.length - 1)
    }

    fun domath(eqn: String) {
        val eqnarray = eqn.split(Regex("[+*-/]"))
        var a = 0
        if(eqnarray[0].isNotEmpty()){
            a = eqnarray[0].toInt()
        }
        val b: Int = eqnarray[1].toInt()
        println("Equation Array ${eqnarray}")
        println("A = ${a} And B = ${b}")
        if (eqn.contains("+")) {
            addition(a, b)
        } else if (eqn.contains("*")) {
            multiply(a, b)
        } else if (eqn.contains("-")) {
            subtraction(a, b)
        } else if (eqn.contains("/")) {
            division(a, b)
        }
    }


    fun onClickAddition(view: View) {
        textformatter("+")
    }

    fun onClickSubtract(view: View) {
        textformatter("-")
    }

    fun onClickDivide(view: View) {
        textformatter("/")
    }

    fun onClickProduct(view: View) {
        textformatter("*")
    }

    //numbers function
    fun onClick1(view: View) {
        textformatter("1")
    }

    fun onClick2(view: View) {
        textformatter("2")
    }

    fun onClick3(view: View) {
        textformatter("3")
    }

    fun onClick4(view: View) {
        textformatter("4")
    }

    fun onClick5(view: View) {
        textformatter("5")
    }

    fun onClick6(view: View) {
        textformatter("6")
    }

    fun onClick7(view: View) {
        textformatter("7")
    }

    fun onClick8(view: View) {
        textformatter("8")
    }

    fun onClick9(view: View) {
        textformatter("9")
    }

    fun onClick0(view: View) {
        textformatter("0")
    }

    fun onClickPoint(view: View) {
        textformatter(".")
    }

    //extra functions

    fun onClickMod(view: View) {
        textformatter("%")
    }

    fun onClickSqrt(view: View) {
        textformatter("")
    }

    fun onClickClear(view: View) {
        text2.text = ""
    }

    fun onClickEqual(view: View) {
        val eqn = text2.text.toString()
        domath(eqn)
        val result: String = text2.text.toString()
        data.add("$eqn=$result")
    }
}
