package com.devtech.customspinnerimage
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.Nullable
import kotlinx.android.synthetic.main.custom_spinner_item.view.*
import java.lang.Exception

class LanguageAdapter(context: Context,
                      val resourceId: Int,
                      val languageList: List<Language>)
    : ArrayAdapter<Language>(context, resourceId, languageList){

    override fun getCount(): Int {
        return languageList.size
    }

    override fun getItem(position: Int): Language? {
        return languageList.get(position)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view =  convertView

        try {
            if (view == null){
                val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                view = layoutInflater.inflate(resourceId, parent, false)
                var language = languageList.get(position)
                view.flagIv.setImageResource(language.flagImage)
                view.languageTv.text = language.locale

            }
        } catch (e: Exception){
            e.printStackTrace()
        }

        return view!!
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view =  convertView

        try {
            if (view == null){
                val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                view = layoutInflater.inflate(resourceId, parent, false)
                var language = languageList.get(position)
                view.flagIv.setImageResource(language.flagImage)
                view.languageTv.text = language.locale

            }
        } catch (e: Exception){
            e.printStackTrace()
        }

        return view!!
    }


}




/*
class LanguageAdapter(context: Context, countryList: ArrayList<Language?>?) :
    ArrayAdapter<Language?>(context, 0, countryList!!) {


    */
/*override fun getView(position: Int, @Nullable convertView: View, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }*//*


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)
    }

    override fun getDropDownView(
        position: Int,
        @Nullable convertView: View,
        parent: ViewGroup
    ): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View, parent: ViewGroup): View {
        var convertView: View = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                R.layout.custom_spinner_item, parent, false
            )
        }
        val imageViewFlag: ImageView = convertView.findViewById(R.id.image_view_flag)
        val textViewName: TextView = convertView.findViewById(R.id.text_view_name)
        val currentItem: Language? = getItem(position)
        if (currentItem != null) {
            imageViewFlag.setImageResource(currentItem.flagImage)
            textViewName.setText(currentItem.locale)
        }
        return convertView
    }
}*/
