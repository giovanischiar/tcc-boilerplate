[app](../../../index.md) / [io.schiar.tccboilerplate.view](../../index.md) / [ArchComponentsListAdapter](../index.md) / [ViewHolder](./index.md)

# ViewHolder

`class ViewHolder : ViewHolder`

interna ao Adapter. Utilizada por ele para tratar o item gráfico da lista.

### Parameters

`binding` - o objeto do XML do item da lista.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ViewHolder(binding: AdapterArchComponentBinding)`<br>interna ao Adapter. Utilizada por ele para tratar o item gráfico da lista. |

### Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | `fun bind(archComponent: `[`ArchComponentViewData`](../../../io.schiar.tccboilerplate.view.viewdata/-arch-component-view-data/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>configura o item gráfico com o viewdata. |
