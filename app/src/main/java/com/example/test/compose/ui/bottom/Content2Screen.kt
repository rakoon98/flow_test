package com.example.test.compose.ui.bottom

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun Content2Screen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (col, row) = createRefs()

        /** Column 을 사용 */
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .constrainAs(col) {}
        ){
            Text(text = "this is Column")
            DropDownTest()
        }

        /** Row 를 사용 */
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .constrainAs(row) {
                    top.linkTo(col.bottom)
                }
        ){
            Text(text = "this is Row")
        }


    }
}

@Composable
fun DropDownTest() {
    var expanded by remember { mutableStateOf(false) }

    Button(
        onClick = { expanded = !expanded }
    ) {
        Text(text = "Show DropDownMenu")
    }

    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
        DropdownMenuItem(text = { Text(text = "첫번째 아이템") }, onClick = { expanded = false })
        DropdownMenuItem(text = { Text(text = "두번째 아이템") }, onClick = { expanded = false })
        DropdownMenuItem(text = { Text(text = "세번째 아이템") }, onClick = { expanded = false })
    }
}