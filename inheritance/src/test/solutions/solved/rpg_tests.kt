package solved

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import java.util.*

class RpgTest {

    @Test
    fun `can use health potions`() {
        val potion = HealthPotion("Brew of Fevers", health = 20)

        val updatedStats = potion.useItem(CharacterStats(currentHealth = 1, currentMana = 1))

        assertThat(updatedStats, equalTo(CharacterStats(currentHealth = 21, currentMana = 1)))
    }

    @Test
    fun `can use mana potion potions`() {
        val potion = ManaPotion("Vial of Hidden Talents", mana = 10)

        val updatedStats = potion.useItem(CharacterStats(currentHealth = 1, currentMana = 1))

        assertThat(updatedStats, equalTo(CharacterStats(currentHealth = 1, currentMana = 11)))
    }

    @Test
    fun `can apply random potion`() {
        val potions = Inventory(listOf(
            HealthPotion("Brew of Fevers", health = 20),
            ManaPotion("Vial of Hidden Talents", mana = 10),
            HealthPotion("Draught of Vitality", health = 50),
            HealthPotion("Potion of Healing", health = 10),
            HealthPotion("Tonic of Focus", health = 20)
        ))

        val useItem = useRandomItem(potions, CharacterStats())

        assertThat(useItem, equalTo(CharacterStats(currentHealth = 120, currentMana = 100)))
    }

    private fun pickRandomly(potions: List<InventoryItem>, random: Random = Random()): InventoryItem =
        potions[random.nextInt(potions.size)]

    private fun useRandomItem(potions: List<InventoryItem>, characterStats: CharacterStats): CharacterStats =
        pickRandomly(potions, Random(1)).useItem(characterStats)
}