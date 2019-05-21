package io.schiar.tccboilerplate.view

import android.widget.TextView
import androidx.databinding.BindingAdapter
import io.schiar.tccboilerplate.R

/**
 * Utilizado para tratamento de dados do ViewModel para serem apresentados na View através de data binding.
 */
object BindingAdapters {
    /**
     * É adicionado o valor a um label no [TextView]
     */
    @BindingAdapter("value")
    @JvmStatic
    fun setValue(textView: TextView, value: String) {
        val viewText = textView.text
        val labelValue = textView.context.getString(R.string.label_value)
        textView.text = String.format(labelValue, viewText, value)
    }

}