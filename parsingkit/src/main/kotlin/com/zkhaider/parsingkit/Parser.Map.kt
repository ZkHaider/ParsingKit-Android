package com.zkhaider.parsingkit

public fun <T, A> Parser<T>.map(f: (T) -> A): Parser<A> {
    return Parser {
        this.run(it)?.let(f)
    }
}

public fun <T, A> Parser<T>.flatMap(f: (T) -> Parser<A>): Parser<A> {
    return Parser { aValue ->
        val original = StringBuffer(aValue.toString())
        var modifiable = aValue
        val matchT = this.run(modifiable)
        val parserA = matchT?.let(f)
        val matchA = parserA?.let { parser -> parser.run(modifiable) }
        if (matchA == null) {
            modifiable = original
            null
        } else {
            matchA
        }
    }
}