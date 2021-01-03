package com.devtech.customspinnerimage

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var languageList: List<Language>
    lateinit var languageAdapter: LanguageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        languageList = loadLanguageSpinner()
        languageAdapter = LanguageAdapter(this, R.layout.custom_spinner_item, languageList)

        spinnerLl.setBackgroundResource(R.drawable.spinner_border_bg)
        languageSpinner.setPopupBackgroundResource(R.drawable.spinner_popup_bg)

        languageSpinner.adapter = languageAdapter

        languageSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity,
                        "Selected Language: ${languageList.get(position).locale}",
                        Toast.LENGTH_LONG).show()

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinnerLl.setBackgroundResource(R.drawable.spinner_border_bg)
            }
        }
    }

    private fun loadLanguageSpinner(): List<Language>{
        var lanList = ArrayList<Language>()
        lanList.add(Language("En", R.drawable.ic_en))
        lanList.add(Language("Ar", R.drawable.ic_ar))
        return lanList
    }
}