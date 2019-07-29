package com.zkhaider.parsingkit

public fun Parser.Companion.prefix(predicate: (Char) -> Boolean): Parser<StringBuffer> {
    return Parser {
        val charSequence = it.takeWhile(predicate)
        val prefix = StringBuffer(charSequence)
        it.delete(0, prefix.length)
        prefix
    }
}

public fun Parser.Companion.removePrefix(from: (Char) -> Boolean): Parser<StringBuffer> {
    return Parser {
        val lastIndex = it.indexOfLast(from)
        if (lastIndex >= 0) {
            val charSequence = it.removeRange(0, lastIndex)
            StringBuffer(charSequence)
        } else {
            it
        }
    }
}