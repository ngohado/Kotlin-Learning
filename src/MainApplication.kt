/**
 * Created by Admin on 6/6/2017.
 */


fun main(args: Array<String>) {
    printSomeThing("Hello world")

    //higher-order function
    val result = addTwoNumber(::processComplexMath) //use lambda

    addTwoNumber(fun(num1: Int, num2: Int): Int { //standard
        return num1 + num2
    })

    printSomeThing("Result is $result")

    //extension and test infix
    val result2 = 2.addSub(3, 4)
    val result3 = 2 addSub 3
    printSomeThing("$result2")
    printSomeThing("$result3")

    //null safety
    var stringNullable: String?
    stringNullable = null

    val sizeOfString: Boolean? = stringNullable?.isNullOrEmpty()

    if (sizeOfString != null) {
        println("sizeOfString is null")
    } else {
        println("sizeOfString is not null")
    }

    val defaultIfNull: Boolean = sizeOfString ?: true

    if (defaultIfNull) {
        println("sizeOfString is null, thus the default is true")
    }

    //check and auto casting
    println(checkString("Hello World"))

    //loop operator
    //use list of to create array
    val fruits = listOf("Banana", "Orange", "Jack fruit") //list is read only collection
    val fruits2: List<String> = listOf("Banana", "Orange", "Jack fruit") //list is read only collection
    val fruits3: ArrayList<String> = arrayListOf("Banana", "Orange", "Jack fruit") //array list is mutable collection

    //filter collections
    val scores = listOf(2, 3, 4, -1, -2, 4, -6)
    val positiveScore = scores.filter { i -> i > 0 }
    //alternative
//    val positiveScore = scores.filter { it > 0 }

    for (score in positiveScore) {
        print("$score  ")
    }

    //test inlet
    println(1.let(::testInlet))

    //lazy property
    println("lazy property")
    val lazyString: String by lazy {
        if (true) {
            "hello"
            "hello2"
            "hello3"
            //conclude: lay string cuoi cung -> hello3
        } else {
            "done"
        }
    }
    println(lazyString)

    //create int array with size
    println("create int array with 3 element -1")
    val tenten = arrayOfMinusOnes(3)
    for (ten in tenten) {
        println(ten)
    }

    //string
    var text = """
    for (c in "foo")
        print(c)
    """
    println(text)

    text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()
    println(text)

    //control-flow when
    println(if (hasPrefix("prefixstringstring")) "have prefix in string" else "don't have prefix in string")

    //test label
    println("test label")
    testLabel()
}

fun processComplexMath(num1: Int, num2: Int): Int {
    var result: Int?
    result = num1 * 10 + num2 * 2
    return result
}

fun testInlet(number: Int): String {
    return "It's the string of $number"
}

fun printSomeThing(message: String) {
    println(message)
}

fun addTwoNumber(add: (Int, Int) -> Int): Int {
    val number1 = 9
    val number2 = 10

    return add(number1, number2)
}

fun checkString(value: Any): String {
    if (value is String) {
        return "The param is a String and the size of string is ${value.length}"
    }
    return "The param is not a String"
}

fun Int.addSub(n1: Int, n2: Int): Int {
    var rootInt = this //this: means value of Int
    return n2 + n1 + rootInt
}

infix fun Int.addSub(n1: Int): Int {
    var rootInt = this
    return n1 + rootInt
}

fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}

fun hasPrefix(obj: Any) = when (obj) {
    is String -> obj.startsWith("prefix")
    else -> false
}

fun testLabel() {
    loop@ for (i in 1..10) {
        for (j in 1..10) {
            if (j == 2) {
                println("$i - $j")
                continue@loop
            }
        }
    }
}

data class User(val name: String){
    private var age: Int = 13
    get() = age

}
