

val a = 10
val b = 15
var result = if (a > b) a else b
var resultString = if (a > b)
        "(a > b)"
    else
        "Hello a"

val op = "+"
result = when(op) {
    "+" -> a + b
    "-" -> a - b
    "*" -> a * b
    "?" -> a / b
    else -> 123
}

var rangeResult = when(a) {
    1 -> a + b
    in 2..5 -> a - b
    in a..b -> a * b
    !in -10..15 -> a / b
    else -> 123
}

fun isEven(num: Int): String {
    return when(num%2) {
        0 -> "Even"
        else -> "Odd"
    }
}

fun isEvenSimple(num: Int): String = when(num%2) {
    0 -> "Even"
    else -> "Odd"
}

fun isEvenMoreSimple(num: Int) = when(num%2) {
    0 -> "Even"
    else -> "Odd"
}

println(isEven(10))
println(isEven(9))

val numbers = arrayOf(12,23,32,43,54)
for (num in numbers) {
    println(num)
}

for (index in numbers.indices) {
    println("$index -> ${numbers[index]}")
}

for (i in 1..3) {
    println(i)
}

for (i in 1..3 step 2) {
    println(i)
}

for (i in 10 downTo 3 step 2) {
    println(i)
}

for (i in -5 until 0) {
    println(i)
}

repeat(2) {
    println("isRepeat")
}

// continue, break 사용가능
// @label 사용가능 , continue@label, break@label

numbers
    .map {
        it * 3
    }
    .filter {
        isEven(it) == "Even"
    }
    .forEach {
        println(it)
    }

// 함수 반환타입에서 Void는 Unit 이라고 표현
// 함수 간단 표현식 눈에 익혀둘 것

fun defaultParam(value: Int = 10) = "$value"
defaultParam()
defaultParam(value = 23)

// infix -> variable.kts에 있음, 단 Single Value Parameter Function 에서만 가능하다.
// operator -> variable.kts에 있음

val n = 5
val first: Int = 0
val second: Int = 1

fun Int.isZero() = (this == 0)

fun fibonacci(n: Int, a: Int, b: Int): Int {
    return if (n.isZero()) a else fibonacci(n-1, b,a+b)
}

//fibonacci(n: n, a: first, b: second)

tailrec fun fibonacciTrailRec(n: Int, a: Int, b: Int): Int {
    return if (n.isZero()) a else fibonacciTrailRec(n-1,b,a+b)
}

//fibonacciTrailRec(n: n, a: first, b: second)

//val add: (Int, Int) -> Int = { x: Int, y: Int -> x + y}
val add: (Int, Int) -> Int = { x: Int, y: Int -> x + y}
val addSimple = { x: Int, y: Int -> x + y}
val addSimple2: (Int, Int) -> Int = { x, y ->
    println(x+y)
    x + y //return 안 붙임
}
addSimple2(1,3)
println({ x: Int, y: Int -> x + y}(34,12))

lateinit var functionType: (Int) -> Unit
functionType = {
    println(it)
}
functionType(48)
// trail Closure 처럼 인자라벨 생략과 {} 표현식 가능