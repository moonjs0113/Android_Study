println("Hello Kotlin")

val stringValue: String = "문종식"
val bigIntValue = 201_611_891
val floatValue = 12.34f
val doubleValue = 123.456
val charValue = "c"

println(stringValue)
println(bigIntValue)
println(floatValue)
println(doubleValue)
println(charValue)

println(floatValue.toInt())
println(bigIntValue.toByte())
println(bigIntValue.toShort())
println(bigIntValue.toLong())
println(bigIntValue.toFloat())
println(bigIntValue.toDouble())
println(bigIntValue.toChar())

println((bigIntValue + doubleValue).javaClass.kotlin)

fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9')
        throw IllegalArgumentException("Out of range")
//    return c.toInt() - '0'.toInt() -> Deprecated
    return c.code - '0'.code
}

val data = '7'
println(data.code)
println('0'.code)
val num = decimalDigitValue(data)
println(num)
println(num*2)
