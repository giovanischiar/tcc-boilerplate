package io.schiar.tccboilerplate.view

import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import io.schiar.tccboilerplate.R
import io.schiar.tccboilerplate.view.viewdata.ArchComponentViewData
import io.schiar.tccboilerplate.view.viewdata.canonicalName
import kotlinx.android.synthetic.main.view_arch_component.view.*

object BindAdapters {

    @BindingAdapter("archComponents")
    @JvmStatic
    fun configureArchComponents(layout: LinearLayout, archComponents: List<ArchComponentViewData>?) {
        layout.removeAllViews()
        for (archComponent in archComponents ?: return) {
            val inflater = LayoutInflater.from(layout.context)
            val archComponentView= inflater.inflate(R.layout.view_arch_component, layout, false)
            archComponentView.name.text = archComponent.name
            archComponentView.description.text = archComponent.description
            archComponentView.library.text = archComponent.library.canonicalName()
            layout.addView(archComponentView)
        }
    }

}