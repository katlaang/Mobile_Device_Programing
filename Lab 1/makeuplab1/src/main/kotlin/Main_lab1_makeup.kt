import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")
    val a= arrayOf("horse", "dog", "cat", "horse","dog")

    dollarsToChange()

    println((removeDups(a).contentToString()))
}

fun dollarsToChange() {
    val scanner = Scanner(System.`in`)
    println("Enter an amount, For example 11.56")

    val num = scanner.nextDouble()
    val coins= num*100 //num.toInt()*100 doesn't work
    val intCoins=coins.toInt()
    val dollars = intCoins / 100
    var remainder =intCoins % 100


    val quarters = remainder / 25
    remainder %= 25

    val dimes = remainder / 10
    remainder %= 10

    //we find number of nickels next
    val nickels = remainder / 5
    remainder %= 5

    val pennies = remainder

  println("Your amount $num consists of: ")
    println(" $dollars dollars")
    println(" $quarters quarters")
    println(" $dimes dimes")
    println(" $nickels nickels")
    println(" $pennies pennies")

}

fun removeDups(arr: Array<String>): Array<String> {
    val arrList = ArrayList<String>()

    for (i in arr.indices) {
        if (!arrList.contains(arr[i])) {
            arrList.add(arr[i])
        }
    }
    //simpler method:  return listOf(*arr).toSet().toTypedArray()
    return arrList.toTypedArray()

}