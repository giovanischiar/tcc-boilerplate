[app](../../index.md) / [io.schiar.tccboilerplate.model.repository](../index.md) / [ArchComponentRepository](./index.md)

# ArchComponentRepository

`class ArchComponentRepository : `[`ArchComponentRepositoryInterface`](../-arch-component-repository-interface/index.md)

Implementação de um repository de componentes arquiteturais. Fornece os dados a respeito dos
componentes arquiteturais.

Por motivos de simplificação, essa classe gera dados de componentes arquiteturais para a aplicação
e os mantém em memória durante a execução. Numa aplicação real, essa classe se comunicaria
com as diferentes camadas de dados da aplicação, como por exemplo serviços e persistência.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ArchComponentRepository()`<br>Implementação de um repository de componentes arquiteturais. Fornece os dados a respeito dos componentes arquiteturais. |

### Functions

| Name | Summary |
|---|---|
| [fetch](fetch.md) | `fun fetch(callback: (`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ArchComponent`](../../io.schiar.tccboilerplate.model/-arch-component/index.md)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Busca a lista de componentes arquiteturais a ser exibida na View. |
