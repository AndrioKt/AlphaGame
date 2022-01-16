import Creature.Creatures
import Creature.Player
import events.Event


fun showMonsterInfo(monst: Creatures ){
    println("${monst.name} have ${monst.getHP()} hp, \t ${monst.getDmg()} damage, \t ${monst.getGd()} gold.")}
fun showPlayerInfo(player: Player ){
    println("${player.name} have ${player.getHP()} hp, \t ${player.getDmg()} damage, \t ${player.getGd()} gold, \t and ${player.getLevel()} level.")}

fun getRandomMonster(monst: Array<Creatures>): Creatures {
    return monst[((Math.random() * monst.size).toInt())]// умножаем на индекс последнего элемента в массиве
}

fun attackMonster(player: Player, monst: Creatures ){
    if (player.isDead())
        return
    println("${player.name} hit ${monst.name} for ${player.getDmg()} damage.")
    monst.reduceHealth(player.getDmg())
    println("The ${monst.name} have ${monst.getHP()} health.")
    if (monst.isDead())
    {
        player.addGold(monst.getGd())
        player.levelUp()
        println("You killed the monster, you gained ${monst.getGd()} gold, and reach ${player.getLevel()}  level.")
        return
    }
}

fun attackPlayer(player: Player, monst: Creatures ){
    if (monst.isDead())
        return
    println("${monst.name} hit you for ${monst.getDmg()} damage.")
    player.reduceHealth(monst.getDmg())
    println("You have ${player.getHP()} health.")
    if (player.isDead())
    {
        return
    }
}

fun fightMonster(player: Player,armons:Array<Creatures>){
    println("--------------------------------------------------------")
    Event(player)
    val monst = getRandomMonster(armons)
    var design:String
    repeat(15) {println("")}//не нашел функцию очистки терминала, потому заполняю его пустыми строками
    println("--------------------------------------------------------")
    println("You have encountered ${monst.name}")
    do {
    println("(You can enter \"m\" for information about enemy, or \"p\" to see your parameters.)\n You want to fight(\"f\") or run(\"r\"):")
        do{
        design = readLine()!!
        if(design != "r" && design != "f" && design!="m" && design!="p") println("Error! Wrong command!")
        } while (design != "r" && design != "f" && design!="m" && design!="p")
        when{
            (design == "r") -> { if ( ((0..1).random()) == 1) {
                println("You successfully fled")
                break
              }
                else {
                    attackPlayer(player,monst)
                if(player.isDead()) {return}
                }
            }
            (design == "f") -> {
                attackMonster(player, monst)
                attackPlayer(player, monst)
            }
            (design == "m") -> {
                showMonsterInfo(monst)
                continue
            }
            (design == "p") -> {
                showPlayerInfo(player)
                continue
            }
        }
    } while (!player.isDead() && !monst.isDead())
    println("Press Enter to move forward.")
    var ent = "h"
    while (ent!="")
        ent = readLine()!!
    }
