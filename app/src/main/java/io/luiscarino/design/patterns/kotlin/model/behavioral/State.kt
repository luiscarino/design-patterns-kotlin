package io.luiscarino.design.patterns.kotlin.model.behavioral

/**
 * The State design pattern is used to alter the behavior of an object as its internal state changes.
 *
 ***/
sealed class ResponseState

object SuccessfulState : ResponseState()
object ErrorState : ResponseState()
object UnknownState : ResponseState()

class ApiClient {
    private var state: ResponseState = UnknownState

    fun makeRequest(s: Boolean) {
        state = if (s) SuccessfulState else ErrorState
    }

    val requestState: String
        get() = when (state) {
            is ErrorState -> "Error state"
            is SuccessfulState -> "Successful state"
            else -> "UnknownState state"
        }
}

fun main(args: Array<String>) {
    val client = ApiClient()
    client.makeRequest(true)
    println(client.requestState)
    client.makeRequest(false)
    println(client.requestState)

}