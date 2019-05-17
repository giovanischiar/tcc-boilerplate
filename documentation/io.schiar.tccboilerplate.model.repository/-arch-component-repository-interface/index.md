[app](../../index.md) / [io.schiar.tccboilerplate.model.repository](../index.md) / [ArchComponentRepositoryInterface](./index.md)

# ArchComponentRepositoryInterface

`interface ArchComponentRepositoryInterface`

Contrato de um fornecedor de dados para a aplicação.
O padrão repository proporciona uma abstração da camada de dados da aplicação.
Além disso, ele centraliza o uso dos objetos do domínio.
Através de um repository, outros componentes da aplicação conseguem
manejar os objetos do domínio de forma simples, sem precisar
conhecer de fato de onde esses objetos vêm e onde são armazenados (internet, banco de dados, caches, etc).
Isso permite que todos os componentes que usam o repository possuam um baixo
acomplamento com as camadas de serviço e persistência da aplicação.

### Functions

| Name | Summary |
|---|---|
| [fetch](fetch.md) | `abstract fun fetch(callback: (`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ArchComponent`](../../io.schiar.tccboilerplate.model/-arch-component/index.md)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Busca a lista de componentes arquiteturais a ser exibida na View. |

### Inheritors

| Name | Summary |
|---|---|
| [ArchComponentRepository](../-arch-component-repository/index.md) | `class ArchComponentRepository : `[`ArchComponentRepositoryInterface`](./index.md)<br>Implementação de um repository de componentes arquiteturais. Fornece os dados a respeito dos componentes arquiteturais. |
