package com.example.navigationpractice

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.navigationpractice.ui.theme.billaBong

@Composable
fun MainScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(horizontal = 16.dp), verticalArrangement = Arrangement.Center
    ){
        Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Text("Instagram", fontFamily = billaBong, fontSize = 50.sp)
            }
            Spacer(modifier = Modifier.height(30.dp))
            TextInput(placeholder = "Phone number,email or username" )
            Spacer(modifier = Modifier.height(15.dp))
            PasswordInput(placeholder = "Password")
            Spacer(modifier = Modifier.height(18.dp))
            CustomButton(title = "Log In")
            Spacer(modifier = Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth(),) {
                Text(text = "Forget your login details?", color = Color.LightGray, fontSize = 10.sp)
                Spacer(modifier = Modifier.width(2.dp))
                Text(text = "Get help logging in",color = Color.DarkGray, fontWeight = FontWeight.SemiBold, fontSize = 10.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth(),) {
                Divider(thickness = 1.dp, color = Color(0xFFE5E5E5), modifier = Modifier.width(145.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "OR", color = Color.LightGray, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.width(4.dp))
                Divider(thickness = 1.dp, color =Color(0xFFE5E5E5), modifier = Modifier.width(145.dp))
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth(),) {
                Text(text = "Log in with Facebook", color = Color(0xFF3897F0), fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            }
        }
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
            Text(text = "Don't have an account?", color = Color.LightGray, fontSize = 10.sp)
            Spacer(modifier = Modifier.width(2.dp))
            Text(text = "Sign up",color = Color.DarkGray, fontWeight = FontWeight.SemiBold, fontSize = 10.sp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(placeholder:String){
    var email by remember {
        mutableStateOf(TextFieldValue(""))
    }

    val interactionSource = remember {
        MutableInteractionSource()
    }

    val isFocused by interactionSource.collectIsFocusedAsState()
    TextField(
        value=email,
        onValueChange = {text->email=text},
        placeholder={ Text(text = placeholder) },
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = if (isFocused) Color.LightGray else Color(0xFFE5E5E5),
                shape = RoundedCornerShape(5.dp)
            ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            containerColor =  Color(0xFFF5F5F5),
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            placeholderColor = Color.Gray,

        ),
        shape = RoundedCornerShape(10.dp),
        interactionSource = interactionSource

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput(placeholder:String){

    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }


    val interactionSource = remember {
        MutableInteractionSource()
    }

    val isFocused by interactionSource.collectIsFocusedAsState()
    TextField(
        value=password,
        onValueChange = {text->password=text},
        placeholder={ Text(text = placeholder) },
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = if (isFocused) Color.LightGray else Color(0xFFE5E5E5),
                shape = RoundedCornerShape(5.dp)
            ),

        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            containerColor =  Color(0xFFF5F5F5),
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            placeholderColor = Color.Gray,

            ),
        trailingIcon = {
                       IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                           Icon(imageVector = if(!passwordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff, contentDescription = "show password")
                       }
        },
        shape = RoundedCornerShape(10.dp),
        keyboardOptions= KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        interactionSource = interactionSource ,
        singleLine = true,
        visualTransformation = if(passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()
    )
}


@Composable
fun CustomButton(title:String){
    val context = LocalContext.current
    Button(
        onClick = {
                  Toast.makeText(context,title,Toast.LENGTH_SHORT).show()
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF3897F0)),
    ) {
        Text(text = title)
    }
}