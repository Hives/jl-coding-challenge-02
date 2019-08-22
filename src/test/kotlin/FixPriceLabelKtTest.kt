import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FixPriceLabelKtTest {
    @Test
    fun `11, 9, 6`() {
        val label = "Was £11, then £9, now £6"
        assertThat(fixPriceLabel(label)).isEqualTo(label)
    }

    @Test
    fun `11, 12, 6`() {
        val label = "Was £11, then £12, now £6"
        assertThat(fixPriceLabel(label)).isEqualTo("Was £12, now £6")
    }

    @Test
    fun `1, 2`() {
        val label = "Was £1, now £2"
        assertThat(fixPriceLabel(label)).isEqualTo("Now £2")
    }

    @Test
    fun `acceptance test 1`() {
        val label = "Was £10, then £8, then £11, now £6"
        assertThat(fixPriceLabel(label)).isEqualTo("Was £11, now £6")
    }

    @Test
    fun `acceptance test 2`() {
        val label = "Was £10, then £8, then £8, now £6"
        assertThat(fixPriceLabel(label)).isEqualTo("Was £10, then £8, now £6")
    }

    @Test
    fun `acceptance test 3`() {
        val label = "Was £10, then £6, then £4, now £8"
        assertThat(fixPriceLabel(label)).isEqualTo("Was £10, now £8")
    }

    @Test
    fun `prices with decimals are preserved`() {
        val label = "Was £10.50, then £11.50, now £10"
        assertThat(fixPriceLabel(label)).isEqualTo("Was £11.50, now £10")
    }

    @Test
    fun `weird example from the clarifications`() {
        val label = "Was £18, then £17, then £18.00, now £11.50"
        assertThat(fixPriceLabel(label)).isEqualTo("Was £18.00, now £11.50")
    }
}
