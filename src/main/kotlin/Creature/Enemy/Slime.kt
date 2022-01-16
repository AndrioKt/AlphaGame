package Creature.Enemy

import Creature.Creatures

class Slime:Creatures() {
    open override var name: String = "Slime"
    override var health: Int = 1
    override var damage: Int = 1
    override var gold: Int = 5
}