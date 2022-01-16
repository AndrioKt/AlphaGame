package Creature

import Creature.Enemy.Dragon

open class Creatures() {
    open var name: String = ""
    protected open var health: Int = 1
    protected open var damage: Int = 1
    protected open var gold: Int = 1
    open fun reduceHealth(ReduceHP: Int) {
        health -= ReduceHP
    }
    open fun isDead(): Boolean {
        return health <= 0
    }
    open fun addDamage(addDMG: Int) {
        damage += addDMG
    }
    open fun addHealth(heal: Int) {
        health += heal
    }
    open fun addGold(addGd: Int) {
        gold += addGd
    }
    fun getDmg(): Int {
        return damage
    }
    fun getHP(): Int {
        return health
    }
    fun getGd(): Int {
        return gold
    }

}