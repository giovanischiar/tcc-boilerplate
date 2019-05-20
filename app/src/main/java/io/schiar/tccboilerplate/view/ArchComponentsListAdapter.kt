package io.schiar.tccboilerplate.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.schiar.tccboilerplate.R
import io.schiar.tccboilerplate.view.viewdata.ArchComponentViewData
import io.schiar.tccboilerplate.databinding.AdapterArchComponentBinding

class ArchComponentsListAdapter(private val archComponents: List<ArchComponentViewData>):
    RecyclerView.Adapter<ArchComponentsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<AdapterArchComponentBinding>(inflater, R.layout.adapter_arch_component, parent,false);

        return ViewHolder(binding);
    }

    override fun getItemCount(): Int {
        return archComponents.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(archComponents[position]);
    }

    class ViewHolder(private val binding: AdapterArchComponentBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(archComponent: ArchComponentViewData) {
            binding.apply {
                this.archComponent = archComponent
                executePendingBindings()
            }
        }
    }
}