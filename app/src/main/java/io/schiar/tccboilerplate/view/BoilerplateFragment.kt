package io.schiar.tccboilerplate.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.schiar.tccboilerplate.viewmodel.BoilerplateViewModel
import io.schiar.tccboilerplate.databinding.BoilerplateFragmentBinding

class BoilerplateFragment : Fragment() {

    private lateinit var viewModel: BoilerplateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProviders.of(this).get(BoilerplateViewModel::class.java)
        val binding = BoilerplateFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@BoilerplateFragment
            viewModel = this@BoilerplateFragment.viewModel
            executePendingBindings()
        }
        viewModel.fetch()
        return binding.root
    }

}
