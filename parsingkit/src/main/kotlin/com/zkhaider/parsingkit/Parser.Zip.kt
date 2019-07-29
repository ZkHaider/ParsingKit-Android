package com.zkhaider.parsingkit

public fun <A, B> zip(a: Parser<A>,
                      b: Parser<B>): Parser<Pair<A, B>> {
    return Parser {
        val original = StringBuffer(it.toString())
        var modifiable = it
        a.run(modifiable)?.also { matchA ->
            b.run(modifiable)?.also { matchB ->
                return@Parser Pair(matchA, matchB)
            }
            modifiable = original
        }
        return@Parser null
    }
}

public fun <A, B, C> zip(a: Parser<A>,
                         b: Parser<B>,
                         c: Parser<C>): Parser<Triple<A, B, C>> {
    return zip(a, zip(b, c)).map { (a, bc) ->
        Triple(a, bc.first, bc.second)
    }
}