package io.schiar.tccboilerplate.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import io.schiar.tccboilerplate.databinding.FragmentOtherBinding
import io.schiar.tccboilerplate.viewmodel.OtherViewModel

/**
 * Mostra uma string pré criada do ViewModel para fins de demonstração do DataBinding
 * @property viewModel ViewModel necessário para mostrar os dados necessários do modelo na View.
 */
class OtherFragment : Fragment() {

    private lateinit var viewModel: OtherViewModel

    /**
     * É carregado o [OtherViewModel] para passar ao databinding do XML, assim o XML tem acesso aos atributos e
     * métodos do ViewModel.
     * @param inflater usado para carregar o XML do fragmento.
     * @param container o componente pai do fragmento.
     * @param savedInstanceState dados do estado anterior do fragmento.
     * @return view correspondente ao fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(OtherViewModel::class.java)
        val binding = FragmentOtherBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@OtherFragment
            viewModel = this@OtherFragment.viewModel
            executePendingBindings()
        }
        return binding.root
    }

}
