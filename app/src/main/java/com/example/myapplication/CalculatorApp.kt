@file:JvmName("CalculatorKt")

package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Calculator(){
    var displayValue by remember {
        mutableStateOf("0")
    }

    var operator by remember {
        mutableStateOf("")
    }

    var num1 by remember {
        mutableDoubleStateOf(0.0)
    }

    fun handleclick(value:String){
        if(displayValue != "0"){
            displayValue = displayValue + value
        }else{
            displayValue = value

        }


    }

    fun handledel(){
        if(displayValue.length > 1){
            displayValue = displayValue.substring(0,displayValue.length-1)
        }else{
            displayValue = "0"

        }
    }

    fun handleclear(){
        displayValue = "0"
        num1 = 0.0
        operator=""
    }

    fun handleoperator(type : String){
        operator = type
        var oper = operator
        if(num1 == 0.0){
            num1 = displayValue.toDouble()
            displayValue = "0"
        }else{
            var results = when(oper){
                "+" -> num1 + (displayValue.toDouble())
                "-" -> num1 - (displayValue.toDouble())
                "/" -> if(displayValue == "0") {num1} else{num1 / (displayValue.toDouble())}
                "x" -> num1 * (displayValue.toDouble())
                else -> displayValue.toDouble()
            }

            displayValue = results.toString()
        }

    }

    fun handlePercent(){
        displayValue = (displayValue.toDouble() / 100.0).toString()
    }

    fun handleequal(){
        var oper = operator
        var results = when(oper){
            "+" -> num1 + (displayValue.toDouble())
            "-" -> num1 - (displayValue.toDouble())
            "/" -> if(displayValue == "0") {num1} else{num1 / (displayValue.toDouble())}
            "x" -> num1 * (displayValue.toDouble())
            else -> displayValue.toDouble()
        }

        displayValue = results.toString()
        operator = ""
        num1 = 0.0

    }

    fun handleSing(){
        if(displayValue.toDouble() > 0){
            displayValue = (displayValue.toDouble() * -1).toString()
        }else{
            displayValue = (displayValue.toDouble() * -1).toString()
        }
    }

    fun handlepoint(){
        if(displayValue == "0"){
            displayValue = "0."
        }else{
            displayValue = displayValue + "."
        }
    }
    Card (
        modifier = Modifier.padding(16.dp).
        height(690.dp).offset(0.dp,80.dp)
    ){
        //add a column
        Column (
            modifier = Modifier.fillMaxSize().
            padding(16.dp)
        ){
            //add a displat
            Text(
                text = displayValue,
                modifier = Modifier.padding(vertical = 8.dp).
                padding(vertical = 22.dp).
                background(MaterialTheme.colorScheme.onSurface)
                    .padding(14.dp).
                    fillMaxWidth().
                    height(45.dp),
                textAlign = TextAlign.End,
                fontWeight = FontWeight.SemiBold,
                fontSize = 48.sp,
                color = Color.White

            )

            Spacer(Modifier.height(10.dp))
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth().padding(18.dp)
            ){

                Buttons(
                    "del",
                    isfunction = true,
                    onclick = { handledel() },
                    modifier = Modifier.weight(1f)
                )
                Buttons(
                    "C",
                    { handleclear() },
                    modifier = Modifier.weight(1f),
                    isfunction = true
                )
                Buttons(
                    "%",
                    { handlePercent() },
                    modifier = Modifier.weight(1f),
                    isfunction = true,
                )

                Buttons(
                    "/",
                    { handleoperator("/") },
                    modifier = Modifier.weight(1f),
                    isfunction = true,
                )

            }

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth().padding(18.dp)
            ){

                Buttons(
                    "7",
                    { handleclick("7") },
                    modifier = Modifier.weight(1f)
                )
                Buttons(
                    "8",
                    { handleclick("8") },
                    modifier = Modifier.weight(1f)
                )
                Buttons(
                    "9",
                    { handleclick("9") },
                    modifier = Modifier.weight(1f)
                )

                Buttons(
                    "x",
                    { handleoperator("x") },
                    modifier = Modifier.weight(1f),
                    isfunction = true
                )

            }

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth().padding(18.dp)
            ){

                Buttons(
                    "4",
                    { handleclick("4") },
                    modifier = Modifier.weight(1f)
                )
                Buttons(
                    "5",
                    { handleclick("5") },
                    modifier = Modifier.weight(1f)
                )
                Buttons(
                    "6",
                    { handleclick("6") },
                    modifier = Modifier.weight(1f)
                )

                Buttons(
                    "-",
                    { handleoperator("-") },
                    modifier = Modifier.weight(1f),
                    isfunction = true,
                )

            }

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth().padding(18.dp)
            ){

                Buttons(
                    "1",
                    { handleclick("1") },
                    modifier = Modifier.weight(1f)
                )
                Buttons(
                    "2",
                    { handleclick("2") },
                    modifier = Modifier.weight(1f)
                )
                Buttons(
                    "3",
                    { handleclick("3") },
                    modifier = Modifier.weight(1f)
                )

                Buttons(
                    "+",
                    { handleoperator("+") },
                    modifier = Modifier.weight(1f),
                    isfunction = true,
                )

            }

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth().padding(18.dp)
            ){

                Buttons(
                    "0",
                    { handleclick("0") },
                    modifier = Modifier.weight(1f)
                )
                Buttons(
                    ".",
                    { handlepoint() },
                    modifier = Modifier.weight(1f),
                    isfunction = true,
                )
                Buttons(
                    "-",
                    { handleSing() },
                    modifier = Modifier.weight(1f),
                    isfunction = true,
                )

                Buttons(
                    "=",
                    { handleequal() },
                    modifier = Modifier.weight(1f),
                    isfunction = true,
                )
            }
        }
    }
}

@Composable
fun Buttons(
    text : String,
    onclick : () -> Unit,
    modifier: Modifier = Modifier,
    isfunction : Boolean = false
){
    Button(

        onClick = onclick,
        colors = ButtonDefaults.buttonColors(if(isfunction){Color.Blue}else{Color.DarkGray}),
        modifier = Modifier.padding(4.dp),
        shape = RoundedCornerShape(10.dp),
        ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.background
        )


    }
}