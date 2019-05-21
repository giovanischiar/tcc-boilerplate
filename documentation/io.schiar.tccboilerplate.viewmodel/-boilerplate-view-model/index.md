[app](../../index.md) / [io.schiar.tccboilerplate.viewmodel](../index.md) / [BoilerplateViewModel](./index.md)

# BoilerplateViewModel

`class BoilerplateViewModel : ViewModel`

Recebe mensagens da visão solicitando dados.
Formata esses dados e os disponibiliza para a visão através dos objetos LiveData.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BoilerplateViewModel(archComponentRepository: `[`ArchComponentRepositoryInterface`](../../io.schiar.tccboilerplate.model.repository/-arch-component-repository-interface/index.md)` = ArchComponentRepository())`<br>Recebe mensagens da visão solicitando dados. Formata esses dados e os disponibiliza para a visão através dos objetos LiveData. |

### Properties

| Name | Summary |
|---|---|
| [archComponents](arch-components.md) | `val archComponents: MutableLiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ArchComponentViewData`](../../io.schiar.tccboilerplate.view.viewdata/-arch-component-view-data/index.md)`>>`<br>lista atual de componentes arquiteturais. |
| [buttonContent](button-content.md) | `val buttonContent: MutableLiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>conteúdo do botão da tela. |

### Functions

| Name | Summary |
|---|---|
| [fetch](fetch.md) | `fun fetch(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Busca os dados de componentes arquiteturais e atualiza o LiveData de [archComponents](arch-components.md). |
