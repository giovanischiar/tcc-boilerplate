[app](../../index.md) / [io.schiar.tccboilerplate.view](../index.md) / [OtherFragment](index.md) / [onCreateView](./on-create-view.md)

# onCreateView

`fun onCreateView(inflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`, container: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`View`](https://developer.android.com/reference/android/view/View.html)`?`

É carregado o [OtherViewModel](../../io.schiar.tccboilerplate.viewmodel/-other-view-model/index.md) para passar ao databinding do XML, assim o XML tem acesso aos atributos e
métodos do ViewModel.

### Parameters

`inflater` - usado para carregar o XML do fragmento.

`container` - o componente pai do fragmento.

`savedInstanceState` - dados do estado anterior do fragmento.

**Return**
view correspondente ao fragmento.

