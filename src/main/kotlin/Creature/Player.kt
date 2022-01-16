package Creature

class Player:Creatures() {
    override var name : String= readLine()?.ifBlank {"Player"}.toString()//проверка пустого ввода имени. Если пусто то выведет по умолчанию Player
    override var health: Int = 10
    override var damage: Int = 1
    override var gold: Int = 0
    private var level = 0

    fun levelUp(){level++;damage++}
    fun hasWon():Boolean{return level>=20}
    fun getLevel():Int{return level}
}