import java.time.LocalDate

lateinit var lateStringValue: String
lateStringValue = "문종식 201611891"
println(lateStringValue)

val lazyStringValue: String by lazy {
    print("Init Lazy")
    "Hello Kotlin"
}
println(lazyStringValue)
println(lazyStringValue)

var nullName: String? = null
nullName = "null String"
var normalName: String = "Normal String"
println(nullName?.javaClass?.kotlin)
println(nullName!!.javaClass.kotlin)
println(normalName.javaClass.kotlin)

var nullString: String? = null
println(nullString)
println(nullString?:"Null String")
//println(nullString?.toUpperCase()?:"Null String") -> toUpperCase() is Deprecated
println(nullString?.uppercase()?:"Null String")

val anyArray: Array<Any> = arrayOf("문종식", 201611891)
println(anyArray)
println(anyArray.javaClass.kotlin)
val stringArray: Array<Any> = arrayOf("문종식", "201611891")
println(stringArray)
println(stringArray.javaClass.kotlin)

val array: Array<String> = Array<String>(5) {
    i -> (i*i).toString()
}
for (item in array) {
    println(item)
}

val intArray: IntArray = intArrayOf(1,2,3,4,5)
val intSquareArray: IntArray = IntArray(5) {
    j -> (j*j)
}
for (i in intArray) {
    println(i)
}
for (i in intSquareArray) {
    println(i)
}
// Kotlin 연산은 내부적으로 연산자 오버로딩한 함수를 사용해서 연산을 처리한다.


infix fun String.addStudentIdentifier(num: Int): String {
    val identifier: String = num.toString()
    return "$this $identifier"
}
println("문종식" addStudentIdentifier 201611891)


//infix fun String.addStudentIdentifier2(num: Int, num2: Int): String {
//    val identifier: String = num.toString()
//    return "$this $identifier $num2"
//}
//println("문종식" addStudentIdentifier 201611891)

val startDate = LocalDate.now()
val endDate = startDate..startDate.plusDays(14)
println(startDate.plusWeeks(1) in endDate)
println(endDate)

val matrix: Array<Array<Int>> = arrayOf(
    arrayOf(1, 2, 3, 4, 5),
    arrayOf(6, 7, 8, 9, 10),
    arrayOf(11, 12, 13, 14, 15)
)
operator fun Array<Array<Int>>.get(f: Int, s: Int): Int {
    return this[f][s]
}
println(matrix[1][2])
println(matrix[1, 2])

class InvokeOperator(val makeMessage1: String) {
    operator fun invoke(makeMessage2: String) {
        println("$makeMessage1 $makeMessage2")
    }
}
val invokeInstance = InvokeOperator("문종식")
invokeInstance("201611891")
InvokeOperator("문종식")("201611891")

if (invokeInstance is InvokeOperator) {
    println("InvokeOperator!")
}

