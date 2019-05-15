package io.schiar.tccboilerplate.view

import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import io.schiar.tccboilerplate.R
import io.schiar.tccboilerplate.view.viewdata.ArchComponentViewData
import io.schiar.tccboilerplate.view.viewdata.canonicalName
import kotlinx.android.synthetic.main.view_arch_component.view.*

/**
 * Utilizado para tratamento de dados do ViewModel para serem apresentados na View através de data binding.
 */
object BindAdapters {

    /**
     * É criado para cada componente arquiterual um componente de visão e adicionado ao layout dentro do XML.
     * @param layout onde carregar os componentes de visão.
     * @param archComponents os componentes de visão, a lista de componentes arquiteturais.
     */
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