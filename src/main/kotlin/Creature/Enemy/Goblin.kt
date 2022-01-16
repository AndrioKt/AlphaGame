package Creature.Enemy

import Creature.Creatures

class Goblin:Creatures() {
    open override var name: String = "Goblin"
    override var health: Int = 2
    override var damage: Int = 2
    override var gold: Int = 15
}