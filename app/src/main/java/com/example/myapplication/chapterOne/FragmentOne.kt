package com.example.myapplication.chapterOne

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R

class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_one, container, false)
        view.findViewById<ComposeView>(R.id.conpose_view).setContent {
            Column(
                modifier = Modifier
                    .border(
                        border = BorderStroke(
                            1.dp, Color.Black,
                        )
                    )
                    .padding(16.dp)
            ) {
                Text(text = "This is a composable view")
                Spacer(modifier = Modifier.padding(10.dp))
                CircularProgressIndicator()
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = "This is a composable view remix")
                Spacer(modifier = Modifier.padding(10.dp))
                val customView = HorizontalDottedProgress(requireContext())
                AndroidView(viewBlock = {customView})
                Spacer(modifier = Modifier.padding(10.dp))
                Button(onClick = {
                    findNavController().navigate(R.id.action_fragmentOne_to_fragmentTwo)
                }) {
                    Text(text = "Click me")
                }
            }
        }
        return view
    }
}