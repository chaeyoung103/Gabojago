package org.techtown.gabojago.menu.randomPick.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.techtown.gabojago.MainActivity
import org.techtown.gabojago.R
import org.techtown.gabojago.databinding.FragmentHomeMenuBinding
import org.techtown.gabojago.menu.randomPick.clock.ClockFragment
import org.techtown.gabojago.menu.randomPick.color.ColorFragment
import org.techtown.gabojago.menu.randomPick.number.NumberFragment
import org.techtown.gabojago.menu.randomPick.wheel.WheelFragment

class HomeMenuFragment : Fragment() {
    lateinit var binding: FragmentHomeMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeMenuBinding.inflate(inflater, container, false)


        binding.homeMenuWheelView.setOnClickListener{
            (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, WheelFragment())
                    .commitAllowingStateLoss()
        }
        binding.homeMenuClockView.setOnClickListener{
            (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, ClockFragment())
                    .commitAllowingStateLoss()
        }
        binding.homeMenuColorView.setOnClickListener{
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, ColorFragment())
                .commitAllowingStateLoss()
        }
        binding.homeMenuNumberView.setOnClickListener{
            (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, NumberFragment())
                    .commitAllowingStateLoss()
        }

        return binding.root
    }
}