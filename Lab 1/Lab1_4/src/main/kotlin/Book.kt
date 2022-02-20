package book

open class Book(
    title: String?=null,
    author: String?=null,
    price: Double

) {

    fun read(){
        println("I am reading")
    }


}
fun main(args: Array<String>) {
    val b1 = Book("Joe", "Eunice", 10.23)
    println("reading $b1 ")
    // val b1= Book("Joe","Eunice",10.23)
    //readFunction()
    b1.read()

}

