package io.luiscarino.design.patterns.kotlin.model.behavioral

/**
 * The Command Processor design pattern separates the request for a service from its execution.
 *
 ***/
interface CheckOutCommand {
    fun execute()
}

class AddCommand(val id: Long) : CheckOutCommand {
    override fun execute() {
        println("Adding order with id: $id")
    }
}

class PayCommand(val id: Long) : CheckOutCommand {
    override fun execute() {
        println("Paying for order with id: $id")
    }
}

class CommandProcessor {
    private val commandQueue: ArrayList<CheckOutCommand> = ArrayList()

    fun addToQueue(command: CheckOutCommand): CommandProcessor = apply { commandQueue.add(command) }

    fun executeCommands() {
        commandQueue.forEach { it.execute() }
        commandQueue.clear()
    }

}


fun main(args: Array<String>) {
    CommandProcessor().addToQueue(AddCommand(1L))
            .addToQueue(PayCommand(2L))
            .addToQueue(AddCommand(3L))
            .addToQueue(PayCommand(4L))
            .executeCommands()

}