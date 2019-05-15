package io.schiar.tccboilerplate.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import io.schiar.tccboilerplate.R
import io.schiar.tccboilerplate.viewmodel.BoilerplateViewModel
import io.schiar.tccboilerplate.databinding.FragmentBoilerplateBinding
import kotlinx.android.synthetic.main.fragment_boilerplate.view.*

class BoilerplateFragment : Fragment() {

    private lateinit var viewModel: BoilerplateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProviders.of(this).get(BoilerplateViewModel::class.java)
        val binding = FragmentBoilerplateBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@BoilerplateFragment
            viewModel = this@BoilerplateFragment.viewModel
            executePendingBindings()
        }
        viewModel.fetch()
        val view = binding.root
        view.navigation_example_btn.setOnClickListener(::onNavigationButtonPressed)
        return view
    }

    private fun onNavigationButtonPressed(view: View) {
        val navId = R.id.boilerplate_to_other
        Navigation.findNavController(view).navigate(navId)
    }

}
