import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import org.gradle.api.Plugin
import org.gradle.api.Project

class GreetingPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        val task = target.task("greeting")
        task.group = "greeting"
        runBlocking {
            (0..5)
                .map { index -> async { index } }
                .awaitAll()
        }
    }
}
