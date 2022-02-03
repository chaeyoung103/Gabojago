package org.techtown.gabojago.randomPick.number

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.techtown.gabojago.R
import org.techtown.gabojago.databinding.ActivityNumberOptionBinding
import org.techtown.gabojago.randomPick.clock.ClockSelectActivity

class NumberOptionActivity : AppCompatActivity() {

    lateinit var binding: ActivityNumberOptionBinding
    var startNum: Int = 0
    var endNum: Int = 0
    var num: Int = 0
    var isOverlap: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setStoredNum()

        binding.numberStartTv.setOnClickListener {
            startActivityForResult(Intent(this, NumberSelectActivity::class.java), 100)
        }
        binding.numberEndTv.setOnClickListener {
            startActivityForResult(Intent(this, NumberSelectActivity::class.java), 101)
        }
        binding.numberNumberTv.setOnClickListener {
            startActivityForResult(Intent(this, NumberSelectNumActivity::class.java), 102)
        }
        binding.numberOptionCb.setOnCheckedChangeListener { button, isChecked ->
            isOverlap = !isChecked
        }

        binding.numberCompBtn.setOnClickListener {
            if(startNum > endNum){
                Toast.makeText(
                    this, "숫자 범위를 다시 설정해 주세요", Toast.LENGTH_SHORT
                ).show()
            }
            else if(((endNum - startNum) < num) && !isOverlap){
                Toast.makeText(
                    this, "숫자의 범위보다 뽑을 숫자의 개수가 더 많습니다", Toast.LENGTH_SHORT
                ).show()
            }
            else{
                var intent = Intent()
                intent.putExtra("start", startNum)
                intent.putExtra("end", endNum)
                intent.putExtra("num", num)
                intent.putExtra("overlap", isOverlap)
                setResult(RESULT_OK, intent)
                finish()
                overridePendingTransition(R.anim.anim_down, R.anim.anim_none)
            }
        }
    }

    private fun setStoredNum(){
        if(intent.hasExtra("start")){
            startNum = intent.getIntExtra("start", 0)
            binding.numberStartTv.text = startNum.toString()
        }
        else{
            binding.numberStartTv.text = "0"
        }
        if(intent.hasExtra("end")){
            endNum = intent.getIntExtra("end", 0)
            binding.numberEndTv.text = endNum.toString()
        }
        else{
            binding.numberEndTv.text = "0"
        }
        if(intent.hasExtra("num")){
            num = intent.getIntExtra("num", 0)
            binding.numberNumberTv.text = num.toString()
        }
        else{
            binding.numberNumberTv.text = "0"
        }
        if(intent.hasExtra("overlap")){
            isOverlap = intent.getBooleanExtra("overlap", true)
            binding.numberOptionCb.isChecked = !isOverlap
        }
        else{
            binding.numberOptionCb.isChecked = false
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 100){
            startNum = data?.getIntExtra("number", 0)!!
            binding.numberStartTv.text = startNum.toString()
        }
        else if(requestCode == 101){
            endNum = data?.getIntExtra("number", 0)!!
            binding.numberEndTv.text = endNum.toString()
        }
        else if(requestCode == 102){
            num = data?.getIntExtra("number", 0)!!
            binding.numberNumberTv.text = num.toString()
        }
    }
}