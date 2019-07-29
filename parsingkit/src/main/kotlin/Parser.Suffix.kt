
public fun Parser.Companion.suffix(predicate: (Char) -> Boolean): Parser<StringBuffer> {
    return Parser {
        val lastIndex = it.indexOfLast(predicate)
        if (lastIndex >= 0) {
            val charSequence = it.substring(lastIndex, it.length)
            it.delete(lastIndex, it.length)
            val suffix = StringBuffer(charSequence)
            suffix
        } else {
            it
        }
    }
}