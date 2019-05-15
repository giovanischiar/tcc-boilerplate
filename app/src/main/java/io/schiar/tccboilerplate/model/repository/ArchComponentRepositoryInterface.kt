package io.schiar.tccboilerplate.model.repository

import io.schiar.tccboilerplate.model.ArchComponent

/**
 * Contrato de um fornecedor de dados para a aplicação.
 * O padrão repository proporciona uma abstração da camada de dados da aplicação.
 * Além disso, ele centraliza o uso dos objetos do domínio.
 * Através de um repository, outros componentes da aplicação conseguem
 * manejar os objetos do domínio de forma simples, sem precisar
 * conhecer de fato de onde esses objetos vêm e onde são armazenados (internet, banco de dados, caches, etc).
 * Isso permite que todos os componentes que usam o repository possuam um baixo
 * acomplamento com as camadas de serviço e persistência da aplicação.
 *
 * @property selectedCar carro atual selecionado.
 */
interface ArchComponentRepositoryInterface {
    /**
     * Busca a lista de componentes arquiteturais a ser exibida na View.
     * @param callback usado para receber a lista de carros buscada.
     */
    fun fetch(callback: (List<ArchComponent>) -> Unit )
}