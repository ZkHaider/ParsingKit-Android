package com.zkhaider.parsingkit

public fun Parser.Companion.never(): Parser<Unit> {
    return Parser { Unit }
}

public fun <A> Parser.Companion.always(a: A): Parser<A> {
    return Parser { a }
}

