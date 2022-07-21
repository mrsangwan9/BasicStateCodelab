package com.example.basicstatecodelab

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier=Modifier) {
    var count by rememberSaveable{mutableStateOf(0)}
//*** While remember helps you retain state across recompositions, it's not retained across configuration
    //for This we have to use rememberSaveable instead of remember
    //rememberSaveable automatically save any value that can be saved in a Bundle. 
        Column(modifier.padding(16.dp)) {
      if(count>0){

          Text(
            text = "You've had $count of glasses",
        )}
            
            
            Row(){  Button(onClick = { ++count}) {
            Text("Add one")

        }
            Spacer(modifier = Modifier.width(10.dp))
    //clear water count button
            Button(onClick = { count=0 }) {

                Text("Clear water count")
            }
        }


}
}

@Preview(showBackground = true)
@Composable
fun Water_Counter_Preview(){
    WaterCounter(modifier=Modifier.fillMaxSize())
}
