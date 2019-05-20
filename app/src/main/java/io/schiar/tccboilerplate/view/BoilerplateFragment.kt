package io.schiar.tccboilerplate.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.schiar.tccboilerplate.R
import io.schiar.tccboilerplate.viewmodel.BoilerplateViewModel
import io.schiar.tccboilerplate.databinding.FragmentBoilerplateBinding
import io.schiar.tccboilerplate.view.viewdata.ArchComponentViewData
import kotlinx.android.synthetic.main.fragment_boilerplate.view.*

/**
 * Mostra a lista de componentes arquiteturais utilizados neste boilerplate
 * @property viewModel ViewModel necessário para mostrar os dados necessários do modelo na View.
 */
class BoilerplateFragment : Fragment() {

    private lateinit var viewModel: BoilerplateViewModel

    /**
     * É carregado o [BoilerplateViewModel] para passar ao databinding do XML, assim o XML tem acesso aos atributos e
     * métodos do ViewModel.
     * @param inflater usado para carregar o XML do fragmento.
     * @param container o componente pai do fragmento.
     * @param savedInstanceState dados do estado anterior do fragmento.
     * @return view correspondente ao fragmento.
     */
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
        viewModel.archComponents.observe(this, Observer {
            binding.adapter = ArchComponentsListAdapter(it)
        })
        return view
    }

    /**
     * Evento disparado quando o botão de exemplo de navegação é clicado. Ele navega para [OtherFragment].
     * @param view componente de visão do botão.
     */
    private fun onNavigationButtonPressed(view: View) {
        val navId = R.id.boilerplate_to_other
        Navigation.findNavController(view).navigate(navId)
    }

}
