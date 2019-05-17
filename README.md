# Boilerplate para construção de aplicações Android

# Arquitetura
A arquitetura desse boilerplate foi feita para ser nos moldes do MVVM.

# Android Jetpack
Este boilerplate utiliza uma boa parte dos componentes arquiteturais:
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* [Navigation](https://developer.android.com/guide/navigation/navigation-getting-started)
* [DataBinding](https://developer.android.com/topic/libraries/data-binding?hl=pt-br)

# Aplicação amostra
Com esse boilerplate, é implementado para fins de consulta e a fim de exemplificar o uso da arquiterura, um aplicativo que mostra os componentes arquiteturais contidos nesse boilerplate, é mostrado como integrar o DataBinding, e exemplifica o uso do Navigation, contém também um fragmento simples e um viewmodel prontos para a aplicação ser implementada.

# Testes
É apresentado o [Mockito](https://site.mockito.org/) para o mock de LiveData e outras coisas necessárias para realização de testes unitários.

# [Documentação](https://github.com/giovanischiar/tcc-boilerplate/blob/master/documentation/index.md)
Todo código do boilerplate está documentado, e é utilizado o [Dokka](https://github.com/Kotlin/dokka) para a geração de páginas de markdown.

# Estrutura de diretório

## Pasta main

```bash
.
├── AndroidManifest.xml
├── java
│   └── io
│       └── schiar
│           └── tccboilerplate
│               ├── model
│               │   ├── ArchComponent.kt
│               │   ├── Library.kt
│               │   └── repository
│               │       ├── ArchComponentRepository.kt
│               │       └── ArchComponentRepositoryInterface.kt
│               ├── view
│               │   ├── BindAdapters.kt
│               │   ├── BoilerplateFragment.kt
│               │   ├── MainActivity.kt
│               │   ├── OtherFragment.kt
│               │   └── viewdata
│               │       ├── ArchComponentViewData.kt
│               │       └── LibraryViewData.kt
│               └── viewmodel
│                   ├── BoilerplateViewModel.kt
│                   └── OtherViewModel.kt
└── res
    ├── drawable-*
    │   └── ic_launcher_background.xml
    ├── layout
    │   ├── activity_main.xml
    │   ├── fragment_boilerplate.xml
    │   ├── fragment_other.xml
    │   └── view_arch_component.xml
    ├── mipmap-*
    │   ├── ic_launcher.xml
    │   └── ic_launcher_round.xml
    ├── navigation
    │   └── navigation.xml
    └── values
        ├── colors.xml
        ├── dimens.xml
        ├── strings.xml
        └── styles.xml
```

Esta pasta contém todos os arquivos de código e xmls necessários para a construção da aplicação. 

### [`/java`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/main/java/)
Apesar do nome dentro dela está todo o código da aplicação e é feita 100% em Kotlin. Os pacotes estão dividos segundo o padrão da arquitetura MVVM. Segue esquemático de uma  arquitetura genérica MVVM:

![](readme-res/mvvm.svg)

#### [`/java/io/schiar/tccboilerplate/model`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/main/java/io/schiar/tccboilerplate/model)
Onde são implementadas as regras de negócio da apliacação. Dentro desse pacote também estão os repositórios, responsáveis pela requisição de dados. Segue o esquemático de um model genérico:

![](readme-res/model.svg)

#### [`/java/io/schiar/tccboilerplate/view`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/main/java/io/schiar/tccboilerplate/view)
Responsável pelas classes que representam as telas da aplicação, também estão os ViewDatas, utilizados para a formatação de filtragem de objetos do modelo. Com ViewData, a view conhece estritamente o que necessário para a exibição dos dados. Segue o esquemático de um view genérico:

![](readme-res/view.svg)

#### [`/java/io/schiar/tccboilerplate/view-model`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/main/java/io/schiar/tccboilerplate/viewmodel)
Responsável pela implementação dos LiveData. Esses LiveData irão ser utilizados pelo XMLs da view para a exibição graças ao DataBinding e os [Bind Adapters](https://developer.android.com/topic/libraries/data-binding/binding-adapters), observação e atualização dos dados. Cada mudança de dados encapsulados com LiveData automaticamente notifica todos os lugares em que são observados. É recomendado os LiveData serem encapsulados ViewData. Segue esquemático detalhado:

![](readme-res/view-model.svg)

### [`/res`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/main/res)
Na pasta res estão os xmls se apoio da aplicação. 

#### `/res/drawable-*` e `/res/mipmap-*`
Carregam todo os ícones (ou eventuais imagens) da aplicação nos mais diversos tamanhos de tela (existe uma pasta pra cada tamanho de `Drawable` e `Mipmap` ocultadas nesse exemplo para simplificação). 

#### [`/res/layout`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/main/res/layout)
Contém os XML que representam os componentes de visão da aplicação. Cada fragmento está aqui representado. No método `onCreateView(...)` de cada fragmento da pasta `/java/io/schiar/tccboilerplate/view` é carregado o seu arquivo XML localizado nessa pasta. Os XML dessas pastas possuem acesso a métodos e LiveData de ViewModels graças ao DataBinding. O fragmento carrega o XML através do Navigation e passa a referência do ViewModel para ele.

#### [`/res/navigation`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/main/res/navigation)
Contém um único XML que serve para descrever todas as transições que devem ocorrer entre os fragmentos da aplicação.

#### [`/res/values`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/main/res/values)
Contém constantes diversas do programa: cores, dimensões, strings, e estilos. Todos cada um em seu próprio XML e podendo ser utlizados em fragmentos e XMLs.

## Pasta test
```bash
.
└── java
    └── io
        └── schiar
            └── tccboilerplate
                ├── BoilerplateViewModelUnitTest.kt
                └── mock
                    ├── GenericMockFactory.kt
                    └── MockArchComponentRepository.kt
```

### [`/java/io/schiar/tccboilerplate/`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/test/java/io/schiar/tccboilerplate)
Aqui conterá os [testes unitários](https://en.wikipedia.org/wiki/Unit_testing) da aplicação.

### [`/java/io/schiar/tccboilerplate/mock`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/test/java/io/schiar/tccboilerplate/mock)
Muitas vezes é necessária geração de objetos "falsos" para a execução de testes unitários, esses objetos são chamados de mock. Irão servir de suporte aos seus testes.

# [Gradle](https://en.wikipedia.org/wiki/Gradle)
É o gerenciador de pacotes acoplado ao Android. É com ele que é gerenciado as bibliotecas utilizadas em aplicações android. A seguir mostrarei as configurações do Gradle  personalizadas para esse boileplate.

## Plugins
```groovy
apply plugin: 'com.android.application' /* Módulo padrão de aplicações Android. */

apply plugin: 'kotlin-android' /* Habilita a utilização da linguagem Kotlin. */

apply plugin: 'kotlin-android-extensions' /* Usado para recursos adicionais para suplantar o código Kotlin. */

apply plugin: 'kotlin-kapt' /* Necessário para o DataBinding */

apply plugin: 'org.jetbrains.dokka-android' /* Geração de HTML para documentação */
```

## Dependências
```groovy
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar']) /* Se existir qualquer biblioteca adicionada manualmente esse comando detecta e inclui na compilação */
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version" /* Biblioteca oficial Kotlin */
    implementation 'androidx.appcompat:appcompat:1.0.2' /* Habilita codificar para versões antigas do Android */
    implementation 'androidx.core:core-ktx:1.0.2' /* Habilita importantes adicionais ao Kotlin como um modo simplificado de acesso ao XML pelo fragment */
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3' /* Layout avançado utilizado em layouts */
    implementation 'androidx.lifecycle:lifecycle-extensions:2.0.0' /* Biblioteca adicional para utilização de componentes arquiteturais do Jetpack */
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.0.0' /* Permite a utilização de ViewModel */
    implementation 'androidx.legacy:legacy-support-v4:1.0.0' /* Suporte do androidx a versões antigas */
    testImplementation 'junit:junit:4.12' /* Criação de testes unitários */
    testImplementation 'org.mockito:mockito-core:2.27.0' /* Criação de mocks para suporte de testes unitários */
    testImplementation 'android.arch.core:core-testing:1.1.1' /* Criação de mocks de componentes do Android para serem utilizados em testes unitários */
    androidTestImplementation 'androidx.test:runner:1.1.1' /* Teste instrumentado Android */
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.1' /* Teste instrumentado Android */
    kapt "com.android.databinding:compiler:3.3.2" /* Permite a utilização de DataBinding à aplicação */
    implementation 'android.arch.navigation:navigation-fragment:1.0.0' /* Permite a utilização de Navigation à aplicação */
    implementation 'android.arch.navigation:navigation-ui:1.0.0' /* Permite a utilização de Navigation à aplicação */
}
```

Há também um código adicional para a utilização do DataBinding:

```groovy
dataBinding {
    enabled = true
}
```

# Orientações Gerais
Esse boilerplate foi desenvido visando as melhores práticas de engenharia de software para desenvolvimento de aplicações Android. Aqui vão algumas orientações para a melhor utilização desse boilerplate.
* ViewModels não podem carregar referências vindas de View;
* ViewModels foram pensados para funcionar como a janela do modelo para a view. Em um fluxo recomendado o ViewModel, com sua referência ao Repository busca dados do modelo, monta objetos de visão (ViewDatas) e deixa disponível para o XML ter acesso;
* Esse boilerplate incentiva o desenvolvimento de aplicativos de atividade única (single activity). Assim podemos tirar o máximo de proveito do componente Navigation e a [Google também recomenda que aplicações funcionem dessa maneira](https://www.youtube.com/watch?v=2k8x8V77CrU);
* Recomenda-se a utilização de classes de modelo para executar a lógica da aplicação;
* A utilização de DataBinding junto com [BindAdapters](https://developer.android.com/topic/libraries/data-binding/binding-adapters) é encorajada. Utilize sempre que possível;
* Utilize sempre que possível os arquivos de constantes localizados em `/res` para colocar as constantes de sua aplicação;

# Como começo?
Clone esse repositório, e abra-o no Android Studio. Utilize como exemplo as classes pré implementadas, [Aqui possui outro exemplo que utiliza as melhores práticas](https://github.com/giovanischiar/tcc) Edite as classes para formar sua própria aplicação. [Mude o package id e o nome dos pacotes para ser o da sua própria aplicação](https://abhiandroid.com/androidstudio/how-to-change-package-name-android-studio.html).

