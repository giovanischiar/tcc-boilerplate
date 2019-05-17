[app](../index.md) / [io.schiar.tccboilerplate.model.repository](./index.md)

## Package io.schiar.tccboilerplate.model.repository

### Types

| Name | Summary |
|---|---|
| [ArchComponentRepository](-arch-component-repository/index.md) | `class ArchComponentRepository : `[`ArchComponentRepositoryInterface`](-arch-component-repository-interface/index.md)<br>Implementação de um repository de componentes arquiteturais. Fornece os dados a respeito dos componentes arquiteturais. |
| [ArchComponentRepositoryInterface](-arch-component-repository-interface/index.md) | `interface ArchComponentRepositoryInterface`<br>Contrato de um fornecedor de dados para a aplicação. O padrão repository proporciona uma abstração da camada de dados da aplicação. Além disso, ele centraliza o uso dos objetos do domínio. Através de um repository, outros componentes da aplicação conseguem manejar os objetos do domínio de forma simples, sem precisar conhecer de fato de onde esses objetos vêm e onde são armazenados (internet, banco de dados, caches, etc). Isso permite que todos os componentes que usam o repository possuam um baixo acomplamento com as camadas de serviço e persistência da aplicação. |
