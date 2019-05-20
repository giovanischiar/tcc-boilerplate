package io.schiar.tccboilerplate.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.schiar.tccboilerplate.R
import io.schiar.tccboilerplate.view.viewdata.ArchComponentViewData
import io.schiar.tccboilerplate.databinding.AdapterArchComponentBinding

/**
 * Trata a lista de ViewDatas para ser exibida pelo componente [RecyclerView].
 * @param archComponents lista de ViewDatas.
 **/
class ArchComponentsListAdapter(private val archComponents: List<ArchComponentViewData>):
    RecyclerView.Adapter<ArchComponentsListAdapter.ViewHolder>() {

    /**
     * Usado para carregar o XML do layout adapter_arch_component com DataBinding que representa um item da lista.
     * @param parent componente pai do item
     * @param viewType o id do tipo da View. Aqui ignorado e utilizado o adapter_arch_component.
     * @return o objeto ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<AdapterArchComponentBinding>(inflater, R.layout.adapter_arch_component, parent,false);

        return ViewHolder(binding);
    }

    /**
     * Quantidade de itens.
     * @return a quantintidade de items.
     */
    override fun getItemCount(): Int {
        return archComponents.size
    }

    /**
     * Usado no momento em que o item da lista é exibido.
     * @param holder o objeto que trata o item gráfico da lista.
     * @param position a posição do item na lista.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(archComponents[position]);
    }

    /**
     * interna ao Adapter. Utilizada por ele para tratar o item gráfico da lista.
     * @param binding o objeto do XML do item da lista.
     */
    class ViewHolder(private val binding: AdapterArchComponentBinding): RecyclerView.ViewHolder(binding.root) {
        /**
         * configura o item gráfico com o viewdata.
         */
        fun bind(archComponent: ArchComponentViewData) {
            binding.apply {
                this.archComponent = archComponent
                executePendingBindings()
            }
        }
    }
}