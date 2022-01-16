package Creature.Enemy

import Creature.Creatures

class Orc:Creatures() {
    open override var name: String = "Orc"
    override var health: Int = 8
    override var damage: Int = 3
    override var gold: Int = 25

}