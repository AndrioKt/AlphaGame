package Creature.Enemy

import Creature.Creatures

class Dragon:Creatures() {
   open override var name: String = "Dragon"
    override var health: Int = 20
    override var damage: Int = 4
    override var gold: Int = 100

}