package Creature.Enemy

import Creature.Creatures

class Spider:Creatures() {
    open override var name: String = "Spider"
    override var health: Int = 2
    override var damage: Int = 1
    override var gold: Int = 10
}