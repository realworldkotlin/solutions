package solved

abstract class InventoryItem(val name: String) {
    abstract fun useItem(stats: CharacterStats): CharacterStats
}

class HealthPotion(name: String, val health: Int) : InventoryItem(name) {
    override fun useItem(stats: CharacterStats): CharacterStats =
        stats.copy(currentHealth = stats.currentHealth + health)

}

class ManaPotion(name: String, val mana: Int) : InventoryItem(name) {
    override fun useItem(stats: CharacterStats): CharacterStats =
        stats.copy(currentMana = stats.currentMana + mana)
}

data class CharacterStats(val currentHealth: Int = 100, val currentMana: Int = 100)

class Inventory(private val potions: List<InventoryItem>) : List<InventoryItem> by potions
