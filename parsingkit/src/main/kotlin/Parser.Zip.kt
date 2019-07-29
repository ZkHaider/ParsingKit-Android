
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