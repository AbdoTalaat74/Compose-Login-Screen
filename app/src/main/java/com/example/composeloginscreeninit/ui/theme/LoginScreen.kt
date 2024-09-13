package com.example.composeloginscreeninit.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeloginscreeninit.LoginTextField
import com.example.composeloginscreeninit.R
import com.example.composeloginscreeninit.SocialMediaLogin


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            TopSection()
            Spacer(modifier = Modifier.height(36.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp)
            ) {
                LoginSection()
                Spacer(modifier = Modifier.height(30.dp))
                SocialMediaSection()
                val uiColor = if (isSystemInDarkTheme()) Color.White else Black

                Box(
                    modifier = Modifier
                        .fillMaxHeight(fraction = 0.8f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xFF94A388),
                                fontSize = 14.sp,
                                fontFamily = Roboto,
                                fontWeight = FontWeight.Normal
                            )
                        ){
                            append("Don't have an Account?")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = uiColor,
                                fontSize = 14.sp,
                                fontFamily = Roboto,
                                fontWeight = FontWeight.Medium
                            )
                        ){
                            append(" Create now")
                        }
                    })
                }

            }

        }
    }
}

@Composable
private fun SocialMediaSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Or continue with",
            style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFF647488))
        )
        Spacer(Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            SocialMediaLogin(
                icon = R.drawable.google,
                text = "Google",
                modifier = Modifier.weight(1f)

            ) { }
            Spacer(modifier = Modifier.width(20.dp))
            SocialMediaLogin(
                modifier = Modifier.weight(1f),
                icon = R.drawable.facebook,
                text = "Facebook"

            ) { }

        }
    }
}

@Composable
private fun LoginSection() {
    LoginTextField(label = "Email", trailing = "", modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(15.dp))
    LoginTextField(
        label = "Password",
        trailing = "Forgot?",
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(20.dp))

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp), onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) BlueGray else Black,
            contentColor = Color.White,
        ),
        shape = RoundedCornerShape(size = 4.dp)
    )
    {
        Text(
            text = "Log in",
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium)
        )
    }
}

@Composable
private fun TopSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black
    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxWidth(fraction = 0.46f),
            painter = painterResource(R.drawable.shape),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Row(
            modifier = Modifier.padding(top = 80.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(42.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = stringResource(R.string.app_name),
                tint = uiColor
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = stringResource(R.string.the_tolet),
                    style = MaterialTheme.typography.headlineMedium,
                    color = uiColor
                )

                Text(
                    text = stringResource(R.string.find_house),
                    style = MaterialTheme.typography.titleMedium,
                    color = uiColor
                )


            }

        }
        Text(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.BottomCenter),
            text = stringResource(R.string.login),
            style = MaterialTheme.typography.headlineLarge,
            color = uiColor,
        )
    }
}