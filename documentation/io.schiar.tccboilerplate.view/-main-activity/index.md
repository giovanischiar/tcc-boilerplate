[app](../../index.md) / [io.schiar.tccboilerplate.view](../index.md) / [MainActivity](./index.md)

# MainActivity

`class MainActivity : AppCompatActivity`

Atividade que controla toda a navegação dos fragmentos da aplicação.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MainActivity()`<br>Atividade que controla toda a navegação dos fragmentos da aplicação. |

### Functions

| Name | Summary |
|---|---|
| [onBackPressed](on-back-pressed.md) | `fun onBackPressed(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Utilizar o método do navigation para voltar ao fragmento anterior quando há um evento de botão físico de voltar. |
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Define qual o XML de view que a Atividade vai usar, define a toolbar criada no XML como a barra superior da aplicação, e passar o controle de navegação para ela, para assim poder integrar o navigation a aplicação |
| [onSupportNavigateUp](on-support-navigate-up.md) | `fun onSupportNavigateUp(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Utilizar o método do navigation para voltar ao fragmento anterior quando há um evento de botão da barra superior. de voltar |
