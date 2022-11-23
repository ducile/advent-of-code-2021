import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class Tests {

    @Test
    fun `Day 4 Test`() {
        var player = mutableListOf(
                mutableListOf("74","x","x","x","3"),
                mutableListOf("x", "x", "3", "4", "x"),
                mutableListOf("80","x","72","26","91"),
                mutableListOf("30","x","7","162","4"),
                mutableListOf("20","x","48","5","13"),
                emptyList<String>().toMutableList()
            )

        isBingo(player) shouldBe true

        calculateBingo(player, 72) shouldBe 46224
    }
}