[app](../../index.md) / [io.schiar.tccboilerplate.view](../index.md) / [ArchComponentsListAdapter](./index.md)

# ArchComponentsListAdapter

`class ArchComponentsListAdapter : Adapter<`[`ViewHolder`](-view-holder/index.md)`>`

Trata a lista de ViewDatas para ser exibida pelo componente [RecyclerView](#).

### Parameters

`archComponents` - lista de ViewDatas.

### Types

| Name | Summary |
|---|---|
| [ViewHolder](-view-holder/index.md) | `class ViewHolder : ViewHolder`<br>interna ao Adapter. Utilizada por ele para tratar o item gráfico da lista. |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ArchComponentsListAdapter(archComponents: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ArchComponentViewData`](../../io.schiar.tccboilerplate.view.viewdata/-arch-component-view-data/index.md)`>)`<br>Trata a lista de ViewDatas para ser exibida pelo componente [RecyclerView](#). |

### Functions

| Name | Summary |
|---|---|
| [getItemCount](get-item-count.md) | `fun getItemCount(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Quantidade de itens. |
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: `[`ViewHolder`](-view-holder/index.md)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Usado no momento em que o item da lista é exibido. |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ViewHolder`](-view-holder/index.md)<br>Usado para carregar o XML do layout adapter_arch_component com DataBinding que representa um item da lista. |
