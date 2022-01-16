import Creature.Enemy.*
import Creature.Player


fun main(args: Array<String>) {
    println("Enter your name:")
    var player=Player()

    println("Welcome ${player.name}.")
    println("You entered the ancient forest, which secrets does it hide?")
    println("Press Enter to move forward.")
    var ent = "h"
    while (ent!="")
        ent = readLine()!!
    repeat(15) {println("")}
    while (!player.isDead() && !player.hasWon())
    {
        val armons = arrayOf(Dragon(),Orc(),Slime(),Goblin(),Spider())
        fightMonster(player,armons);
    }
    if (player.isDead())
    {
        println("You died on level ${player.getLevel()} with ${player.getGd()} in your pocket.")
        println("Too bad you can't take it with you...")
    }
    else println("You won!!! For this adventure you gain ${player.getLevel()} gold.")
}
