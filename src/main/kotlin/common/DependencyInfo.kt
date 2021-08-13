package common

import org.gradle.api.artifacts.dsl.DependencyHandler

data class DependencyInfo(val name: String, val version: String, val method: Method) {
    private val fullName: String
        get() = "$name:$version"

    private val methodName: String
        get() = method.methodString

    fun implement(dependencyHandler: DependencyHandler) {
        dependencyHandler.add(this.methodName, this.fullName)
    }
}