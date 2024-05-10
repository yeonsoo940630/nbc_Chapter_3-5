package com.spartabasic.nbc_test

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.spartabasic.nbc_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private lateinit var searchFragment: SearchFragment
    private lateinit var dropboxFragment: DropboxFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        searchFragment = SearchFragment()
        dropboxFragment = DropboxFragment()

        //첫화면 설정(이미지 검색 프래그먼트가 먼저 보이도록)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, searchFragment)
            .commit()


        binding.apply {
            btnSearch.setOnClickListener { //이미지 검색버튼을 눌렀을 때
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, searchFragment)
                    .commit()

            }

            btnDropbox.setOnClickListener { //내 보관함을 눌렀을 때
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, dropboxFragment)
                    .commit()

            }
        }
    }
}