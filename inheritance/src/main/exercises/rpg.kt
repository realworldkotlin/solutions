import java.util.Random

class Potion(val name: String, val health: Int = 0, val mana: Int = 0) {
    fun useItem(stats: CharacterStats): CharacterStats =
        stats.copy(
            currentHealth = stats.currentHealth + health,
            currentMana = stats.currentMana + mana
        )
}

data class CharacterStats(val currentHealth: Int = 100, val currentMana: Int = 100)

fun useRandomItem(potions: List<Potion>, characterStats: CharacterStats): CharacterStats =
    pickRandomly(potions, Random(1)).useItem(characterStats)

private fun pickRandomly(potions: List<Potion>, random: Random = Random()): Potion =
    potions[random.nextInt(potions.size)]
