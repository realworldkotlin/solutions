
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class RpgTest {

    @Test
    fun `can use health potions`() {
        val potion = Potion("Brew of Fevers", health = 20)

        val updatedStats = potion.useItem(CharacterStats(currentHealth = 1, currentMana = 1))

        assertThat(updatedStats, equalTo(CharacterStats(currentHealth = 21, currentMana = 1)))
    }

    @Test
    fun `can use mana potion potions`() {
        val potion = Potion("Vial of Hidden Talents", mana = 10)

        val updatedStats = potion.useItem(CharacterStats(currentHealth = 1, currentMana = 1))

        assertThat(updatedStats, equalTo(CharacterStats(currentHealth = 1, currentMana = 11)))
    }

    @Test
    fun `can apply random potion`() {
        val potions = listOf(
            Potion("Brew of Fevers", health = 20),
            Potion("Vial of Hidden Talents", mana = 10),
            Potion("Draught of Vitality", health = 50),
            Potion("Potion of Healing", health = 10),
            Potion("Tonic of Focus", health = 20)
        )

        val useItem = useRandomItem(potions, CharacterStats())

        assertThat(useItem, equalTo(CharacterStats(currentHealth = 120, currentMana = 100)))
    }
}