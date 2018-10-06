package io.luiscarino.design.patterns.kotlin.model.behavioral

import java.text.SimpleDateFormat
import java.util.*

/**
 * Used to create an interchangeable family of algorithms from which the required process is chosen
 * at run-time.
 *
 * This example showcases how to create an strategy to format dates.
 * **/
class Formatter(private val formatterStrategy: (Date) -> String) {
    fun printDate(date: Date) = println(formatterStrategy.invoke(date))
}

val uiFormatStrategy: (Date) -> String = {
    SimpleDateFormat("MMM d, yyyy", Locale.getDefault()).format(it)
}
val serverFormatStrategy = { it: Date ->
    SimpleDateFormat("EEEEE dd MMMMM yyyy HH:mm:ss.SSSZ", Locale.getDefault()).format(it)
}

fun main(args: Array<String>) {
    val uiFormatter = Formatter(uiFormatStrategy)
    println(uiFormatter.printDate(Calendar.getInstance().time))

    val serverFormatter = Formatter(serverFormatStrategy)
    println(serverFormatter.printDate(Calendar.getInstance().time))

}