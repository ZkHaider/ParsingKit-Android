
public fun Parser.Companion.double(): Parser<Double> {
    return Parser {
        val prefix = it.takeWhile { it.isDigit() || it == '.' }
        val doubleValue = prefix.toString().toDoubleOrNull()
        doubleValue?.let { double ->
            it.delete(0, prefix.length)
            return@Parser double
        }
        return@Parser null
    }
}