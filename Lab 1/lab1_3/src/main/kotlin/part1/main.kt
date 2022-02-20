fun main(args: Array<String>) {
    println("Hello World...!")

    val num = 256656
    val a:IntArray = intArrayOf(1,3,5,8,6,4,9)//1+9+81+25
    println(firstDigit(num))
    println(lastDigit(num))
    println(SumOfOddsinArray(a))
    println(weightOnPlanentsFunction(180.00, "Mars"))

}

fun firstDigit(n: Int): Int {

    var n = n
    while (n >= 10) n /= 10

    return n
}

fun lastDigit(n: Int): Int {

    return n % 10
}

fun SumOfOddsinArray(a: IntArray): Int {
    var oddSum = 0
    val length=a.size
    var i= 0
    while (i < length) {
        if (a[i] % 2 != 0) {
            oddSum += a[i]*a[i]
        }
        i++
    }
    return oddSum
}


fun weightOnPlanentsFunction(input: Double, planet: String): Double {

    var gravity: Double? = 0.0
    gravity = when (planet) {
        "Venus" -> 0.78
        "Mars" -> 0.39
        "Jupiter" -> 2.65
        "Saturn" -> 1.17
        "Uranus" -> 1.05
        "Neptune" -> 1.23
        else -> { return 0.0}

    }

    return input * gravity
}

fun dollarsToChange


