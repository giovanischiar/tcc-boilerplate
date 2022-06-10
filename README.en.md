Read this page in [English](https://github.com/giovanischiar/tcc-boilerplate/blob/master/README.en.md)

# Boilerplate to implement Android Applications

## Architecture
The architecture of this boilerplate follows MVVM directives, and it uses the most recent Android architectural components at the same time.

### Android Jetpack
This boilerplate uses most of the Jetpack Android architectural components: 
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* [Navigation](https://developer.android.com/guide/navigation/navigation-getting-started)
* [DataBinding](https://developer.android.com/topic/libraries/data-binding)

## Sample code
Using this boilerplate, it's implemented an app that shows the architectural components included in the boilerplate, with the objective of consulting and exemplify its architeture use. This code contains at least an examplo of each component of the presented architecture. It's shown how integrate the DataBinding, how to use Navigation, as well as contains a simple Fragment and a ViewModel ready to develop an application.

## Tests
It's presented [Mockito](https://site.mockito.org/) to mock the components of the architecture, in order to allow the most unit tests of the Model and ViewModel layers, like the LiveData objects.

## [Documentation](https://github.com/giovanischiar/tcc-boilerplate/blob/master/documentation/index.md)
All code was documented (in Portuguese, but planned to translate to English shortly) and it's utilized [Dokka](https://github.com/Kotlin/dokka) to generate the markdown pages;

## Directory structure

### Main folder

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

This folder contains all code and XML files needed in order to implement the application.

#### [`/java`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/main/java/)
Though the name, All application code it's inside of this folder, 100% kotlin coded. The packages are modeled following the MMVM architecture. Find the scheme of a generic MVVM architecture below: 
![](readme-res/mvvm.en-us.dark.svg#gh-dark-mode-only)
![](readme-res/mvvm.en-us.light.svg#gh-light-mode-only)

##### [`/java/io/schiar/tccboilerplate/model`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/main/java/io/schiar/tccboilerplate/model)
Where the business logic of the application are implemented. Inside this package there are also the repositories, responsable to data requests. Find the scheme of a generic model below: 
![](readme-res/model.en-us.dark.svg#gh-dark-mode-only)
![](readme-res/model.en-us.light.svg#gh-light-mode-only)

##### [`/java/io/schiar/tccboilerplate/view`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/main/java/io/schiar/tccboilerplate/view)
Responsible for the classes that represent the application screens. It also includes the ViewDatas, utilized to formatation and filtering the Model objects. With LiveData objects, the View is strictly aware what it's needed to show the data. Find the scheme of a generic View below:
![](readme-res/view.en-us.dark.svg#gh-dark-mode-only)
![](readme-res/view.en-us.light.svg#gh-light-mode-only)

##### [`/java/io/schiar/tccboilerplate/view-model`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/main/java/io/schiar/tccboilerplate/viewmodel)
Responsible for the LiveData implementation. These LiveData turn avaiable the data needed for the view show on the screen. To do that, the view can retrieve information of these LiveData or observe any changes that may occur, updating the screen in a reactive way. These LiveData can also be referenced directly on the XML files of the View to show the data, it is possible because of the DataBinding and the [Bind Adapters](https://developer.android.com/topic/libraries/data-binding/binding-adapters). Each encapsulated data change with LiveData automatically notify in all observed places. It's recommended that the LiveData objects be encapsulated into ViewData objects. Find the scheme of a generic ViewModel:
![](readme-res/view-model.en-us.dark.svg#gh-dark-mode-only)
![](readme-res/view-model.en-us.light.svg#gh-light-mode-only)

#### [`/res`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/main/res)
In the res folder there are the XML files.

##### `/res/drawable-*` e `/res/mipmap-*`
Load all icons (or images) of the application in all screen sizes (there is a folder for each size of `Drawable` and `Mipmap` hidden in this example to simplify)

##### [`/res/layout`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/main/res/layout)
It contains the XML that represent the View components of the application. Each Fragment is represented here. On the `onCreateView(...)` method of each Fragment of the folder `/java/io/schiar/tccboilerplate/view` it's loaded its XML file located in this folder. The XML of these folders has access to methods and ViewModels's LiveData thanks to DataBinding. The fragment loads the XML through Navigation and pass the ViewModel's reference to it.

##### [`/res/navigation`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/main/res/navigation)
It Contains a single XML that describes all transitions that should occur between the fragments in the application.

##### [`/res/values`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/main/res/values)
It contains some programs's constants: colors, dimentions, strings and styles. Each one in its own XML file, and all of them can be used in fragments and XML files.

### test folder
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

#### [`/java/io/schiar/tccboilerplate/`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/test/java/io/schiar/tccboilerplate)
Here goes the application's [unit tests](https://en.wikipedia.org/wiki/Unit_testing).

##### [`/java/io/schiar/tccboilerplate/mock`](https://github.com/giovanischiar/tcc-boilerplate/tree/master/app/src/test/java/io/schiar/tccboilerplate/mock)
Many times it's necessary the generation of "fake" objects when executing unit tests. These objects are called mock. That would be used when testing.

## [Gradle](https://en.wikipedia.org/wiki/Gradle)
It's the Android's package manager. It manages the libraries used in Android applications. Here it will be show the personalized Gradle settings for this boilerplate.

### Plugins
```groovy
apply plugin: 'com.android.application' /* Default module of Android applications. */

apply plugin: 'kotlin-android' /* It enables the Kotlin language utilization. */

apply plugin: 'kotlin-android-extensions' /* Additional resources of the Kotlin language. */

apply plugin: 'kotlin-kapt' /* Databinding related plugin.*/

apply plugin: 'org.jetbrains.dokka-android' /* HTML documentation generation. */
```

### Dependencies
```groovy
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar']) /* If theres any library added manually, this command detects and includes in the compilation */
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version" /* Kotlin official library. */
    implementation 'androidx.appcompat:appcompat:1.0.2' /* It enables older Android version coding. */
    implementation 'androidx.core:core-ktx:1.0.2' /* It enables important kotlin addons like a simplified way to access the XML of the fragment. */
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3' /* Advanced Layout used in layouts. */
    implementation 'androidx.lifecycle:lifecycle-extensions:2.0.0' /* Additional library to using the Jetpack Architectural components. */
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.0.0' /* It permits the ViewModel utilization. */
    implementation 'androidx.legacy:legacy-support-v4:1.0.0' /* Legacy older versions androidx support. */
    testImplementation 'junit:junit:4.12' /* Unit testing creation. */
    testImplementation 'org.mockito:mockito-core:2.27.0' /* Mocking creation to use in unit testing */
    testImplementation 'android.arch.core:core-testing:1.1.1' /* Android component mocking creation to use in unit testing. */
    androidTestImplementation 'androidx.test:runner:1.1.1' /* Android instrumented testing. */
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.1' /* Android instrumented testing. */
    kapt "com.android.databinding:compiler:3.3.2" /* It allows the DataBinding utilization */
    implementation 'android.arch.navigation:navigation-fragment:1.0.0' /* It allows the Navigation utilization */
    implementation 'android.arch.navigation:navigation-ui:1.0.0' /* It allows the Navigation utilization */
}
```

There's also a aditional code to BataBinding utilization:
```groovy
dataBinding {
    enabled = true
}
```

## General Orientations
This boilerplate was developed having the best Android application software engeneering development practices in mind. Here are some orientations to better utilization of this boilerplate:
* ViewModels cannot hold references to View Clasess, specially the Android Framework ones;
* ViewModels was thinking to work as a Model window to the View. In a recommended flow, the ViewModel, with its Repository reference, fetches the model data, create ViewDatas and let it available to the View access;
* This boilerplace encourages a single activity application development. That way you can fully use the Navigation component and [Google also recommends that application works in that way](https://www.youtube.com/watch?v=2k8x8V77CrU);
* It recommended that model classes executes the application logic;
* The DataBinding utilization together with [BindAdapters](https://developer.android.com/topic/libraries/data-binding/binding-adapters) it's encouraged. It's recommendes using whenever possible;
* It recommended whenever possible using the constant files located in `/res` to put the application's constants;

## How do I get started?
* Clone this repository;
* Open it on Android Studio;
* Utilize as an example the pre implemented classes [There is another example that utilize the best practices here](https://github.com/giovanischiar/reservation-picker).
* Edit the classes to form your own application. [Change the package id and the name of the packages to be your own application Mude o package id](https://abhiandroid.com/androidstudio/how-to-change-package-name-android-studio.html).

