package events
import Creature.Player
import kotlin.system.exitProcess


fun Event(player: Player){
    val randNum = (1..5).random()
    when{
        (randNum==1)-> Event_nothing()
        (randNum==2)-> Event_RustySword(player)
        (randNum==3)-> Event_Stump(player)
        (randNum==4)-> Event_Spring(player)
        (randNum==5)-> Event_Merchant(player)
    }
        println("Press Enter to move forward.")
        var ent = "h"
        while (ent!="")
        ent = readLine()!!
    }
/*fun RandomEvent(player: Player){
    val EventsArr = arrayOf(Event_nothing(player),Event_RustySword(player))
    EventsArr[(Math.random()*EventsArr.size).toInt()]
}*/

fun Event_nothing(){
    println("It's a calm and warm day, you are walk forward, and it's seems like nothing couldn't disturb you, but... ")
}
fun Event_RustySword(player: Player){
    var choice = ""
    println("You found old and rusty sword, do you want to take it?(y/n)")
    while (choice!="y" && choice!="n"){
        choice= readLine()!!
        when{
            (choice=="y")->{
                println("You increased your damage by 1")
                player.addDamage(1)
                break
            }
            (choice=="n")->{
                println("You are going forward")
                break
            }
            else -> println("Error! Entered wrong key.")
        }
    }
}
fun Event_Stump(player: Player){
    var choice = ""
    val randNum = (1..3).random()
    println("You see a stump with a hole. Do you want to look inside? (y/n)")
    while (choice!="y" && choice!="n"){
        choice= readLine()!!
        when{
            (choice=="y")->{
                if(randNum==1) {
                    val randStash = (1..5).random()
                    println("You found hiden stash with $randStash gold coins.")
                    player.addGold(randStash)
                    break
                }
                else if (randNum==2){
                    println("There were termites inside a stump, you have gained 1 damage")
                    player.reduceHealth(1)
                    break
                    if (player.isDead()){
                        println("You are dead! What a pity to die this way...")
                        println("You died on level ${player.getLevel()} with ${player.getGd()} in your pocket.")
                        exitProcess(-1)//команда выхода из программы
                    }
                }
                else {
                    println("It's just a stump, you didn't find anything. You can continue your journey.")
                    break
                }
            }
            (choice=="n")->{
                println("You are going forward")
                break
            }
            else -> println("Error! Entered wrong key.")
        }
    }
}
fun Event_Spring(player: Player){
    println("You found a spring of youth, that heal you by 2 hp")
    player.addHealth(2)
        }
fun Event_Merchant(player: Player){
    println("You met a merchant. You can buy: \n \"Apple\" (heal 1 hp) cost 5 gold; \n \"Healing potion\" (heal 5 hp) cost 15 gold; \n \"Legendary magic sword\", that cost 50 gold;\n \"Potion of experience\" (gain 1 level up) - cost 20 gold.")
    println("If you want to buy something, enter the name, or press \"n\" to exit the store.")
    var trade=""
    while (trade != "Apple" && trade != "Healing potion" && trade != "Legendary magic sword" && trade != "Potion of experience" && trade != "n"){
        trade= readLine()!!
        when{
            (trade == "n") ->{
                println("You are leaving the merchant.")
                break
            }
            (trade == "Apple") ->{
                if(player.getGd()<5) {
                    println("You haven't enough money, and the merchant throws you out of the store.")
                    break
                }
                else {
                    println("You are buying Apple, and restoring 1 hp.")
                    player.addGold(-5)
                    player.addHealth(1)
                    break
                 }
            }
            (trade == "Healing potion") ->{
                if(player.getGd()<15) {
                    println("You haven't enough money, and the merchant throws you out of the store.")
                    break
                }
                else {
                    println("You are buying Healing potion, and restoring 5 hp.")
                    player.addGold(-15)
                    player.addHealth(5)
                    break
                }
            }
            (trade == "Legendary magic sword") ->{
                if(player.getGd()<50) {
                    println("You haven't enough money, and the merchant throws you out of the store.")
                    break
                }
                else {
                    println("You are buying Legendary magic sword, and gain 3 damage.")
                    player.addGold(-50)
                    player.addDamage(3)
                    break
                }
            }
            (trade == "Potion of experience") ->{
                if(player.getGd()<20) {
                    println("You haven't enough money, and the merchant throws you out of the store.")
                    break
                }
                else {
                    println("You are buying Potion of experience, and increased your level by 1.")
                    player.addGold(-20)
                    player.levelUp()
                    break
                }
            }
            else -> println("Error! Entered wrong key.")
        }
    }
}
