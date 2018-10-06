package io.luiscarino.design.patterns.kotlin.model.behavioral

import kotlin.properties.Delegates

interface OnTextChangeListener {
    fun onTextChanged(newText: String)
}

class OnTextChangeListenerImpl : OnTextChangeListener {
    override fun onTextChanged(newText: String) = println("Text has changed to $newText")
}

class TextView {
    var listener: OnTextChangeListener? = null
    var text: String by Delegates.observable("") { property, oldValue, newValue ->
        listener?.onTextChanged(newValue)
    }
}

fun main(args: Array<String>) {
    val textView = TextView()
    textView.listener = OnTextChangeListenerImpl()
    textView.text = "Sed ut perspiciatis unde"
    textView.text = "Nemo enim ipsam voluptatem "
}