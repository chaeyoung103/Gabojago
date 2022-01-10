package org.techtown.gabojago.randomPick

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import org.techtown.gabojago.databinding.ActivityWheelBinding

class WheelActivity : AppCompatActivity() {
    lateinit var binding: ActivityWheelBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = ActivityWheelBinding.inflate(inflater, container, false)

        return binding.root
    }
}