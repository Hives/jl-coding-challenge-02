fun fixPriceLabel(label: String): String =
    label.getPrices()
        .removeInvalidPrices()
        .formatToString()

private fun String.getPrices() =
    this.split(",")
        .map { it.split("£").last() }
        .pairWithFloatRepresentations()

private fun List<String>.pairWithFloatRepresentations() =
    this.map { Price(it, it.toFloat()) }

private tailrec fun List<Price>.removeInvalidPrices(index: Int = 0): List<Price> {
    if (index == this.size) return this

    val maxSubsequentPrice = this.filterIndexed { i, _ -> i > index }
        .map { it.floatValue }
        .max()

    if (maxSubsequentPrice != null && this[index].floatValue <= maxSubsequentPrice) {
        return this.filterIndexed { i, _ -> i != index }.removeInvalidPrices(index)
    } else {
        return this.removeInvalidPrices(index + 1)
    }

}

private fun List<Price>.formatToString(): String =
    if (this.size == 1) {
        "Now £${this.single().stringValue}"
    } else {
        this.mapIndexed { index, price ->
            when (index) {
                0 -> "Was £${price.stringValue}"
                this.size - 1 -> "now £${price.stringValue}"
                else -> "then £${price.stringValue}"
            }
        }.joinToString()
    }

data class Price(val stringValue: String, val floatValue: Float)
