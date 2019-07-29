package com.zkhaider.parsingkit

public typealias ParseFunction<T> = (StringBuffer) -> T?

public data class Parser<T>(val run: ParseFunction<T>) {
    companion object
}

public fun <T> Parser<T>.run(str: String): Pair<T?, StringBuffer> {
    val stringBuffer = StringBuffer(str)
    val match = this.run(stringBuffer)
    return Pair(match, stringBuffer)
}