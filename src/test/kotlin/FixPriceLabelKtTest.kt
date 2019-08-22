import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FixPriceLabelKtTest {
    @Test
    fun `a valid label is unchanged`() {
        val label = "Was £11, now £6”."
        assertThat(fixPriceLabel(label)).isEqualTo(label)
    }
}
