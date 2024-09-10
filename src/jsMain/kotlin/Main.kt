import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
fun main() {
	GlobalScope.launch {
		kotlin.runCatching {
			HttpClient().get("https://httpbin.org/get").bodyAsText()
		}.fold(
			onSuccess = {
				println("Success")
				println(it)
			},
			onFailure = {
				println("Error")
				println(it)
				process.exit(123)
			}
		)
	}
}

external val process: Process
external interface Process {
	fun exit(code: Int): Nothing
}