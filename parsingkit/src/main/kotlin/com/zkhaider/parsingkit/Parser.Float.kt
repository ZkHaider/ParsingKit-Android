package com.zkhaider.parsingkit

public fun Parser.Companion.float(): Parser<Float> {
    return Parser {
        val prefix = it.takeWhile { it.isDigit() || it == '.' }
        val floatValue = prefix.toString().toFloatOrNull()
        floatValue?.let { float ->
            it.delete(0, prefix.length)
            return@Parser float
        }
        return@Parser null
    }
}