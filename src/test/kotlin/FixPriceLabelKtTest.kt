import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FixPriceLabelKtTest {
    @Test
    fun `a valid label is unchanged`() {
        val label = "Was £11, then £9, now £6"
        assertThat(fixPriceLabel(label)).isEqualTo(label)
    }

    @Test
    fun `three prices, the middle one invalid`() {
        val label = "Was £11, then £12, now £6"
        assertThat(fixPriceLabel(label)).isEqualTo("Was £11, now £6")
    }

//    @Test
//    fun `acceptance test 1`() {
//        val label = "Was £10, then £8, then £11, now £6"
//        assertThat(fixPriceLabel(label)).isEqualTo("was £11, now £6")
//    }

}

//“Was £10, then £8, then £8, now £6”. This should be “Was £10, then £8, now £6”
//
//“Was £10, then £6, then £4, now £8”. This should be “Was £10, now £8”.
