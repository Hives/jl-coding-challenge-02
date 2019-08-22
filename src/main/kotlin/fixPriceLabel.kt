fun fixPriceLabel(label: String): String =
    label.getPrices()
        .pairWithFloatRepresentation()
        .filterPrices()
        .formatToString()

private fun String.getPrices() =
    this.split(",")
        .map { it.split("£").last() }

private fun List<String>.pairWithFloatRepresentation() =
    this.map { Price(it, it.toFloat()) }

private tailrec fun List<Price>.filterPrices(index: Int = 1): List<Price> {
    if (index == this.size) return this

    if (this[index].floatValue > this[index - 1].floatValue) {
        return this.filterIndexed { i, _ -> i != index }.filterPrices(index)
    } else {
        return this.filterPrices(index + 1)
    }
}

private fun List<Price>.formatToString(): String =
    this.mapIndexed { index, price ->
        when (index) {
            0 -> "Was £${price.stringValue}"
            this.size - 1 -> "now £${price.stringValue}"
            else -> "then £${price.stringValue}"
        }
    }
        .joinToString()

data class Price(val stringValue: String, val floatValue: Float)
