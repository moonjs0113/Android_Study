class Person constructor(val name: String) {

}

class PersonSimple(val name: String) {

}

var p0 = Person("person")
var p1 = PersonSimple("personSimple")

class PersonSecondary {
    var name: String = ""
    constructor(param1: String) {
        this.name = param1
    }

    fun printName(): Unit {
        println(this.name)
    }
}
val p2 = PersonSecondary("2nd")
p2.printName()

class PersonPrimary(val name: String) {
    var addr: String? = null
    var tel: String? = null

    constructor(name: String, addr: String): this(name) {
        this.addr = addr
    }

    constructor(name: String, addr: String, tel:String): this(name, addr) {
        this.tel = tel
        this.addr?.drop(2)
    }

    fun printName(): Unit {
        println(this.name)
    }
    fun printAddr(): Unit {
        println(this.addr)
    }
}

var p3 = PersonPrimary("hel", "dkd", "dalskdjf")
p3.addr

// public
// private
    // 현재 클래스 or 인터페이스에서만 사용 가능
// protected 파일 내부
    // private과 동일하지만, subclass에서 사용 가능
// Internal
    // 같은 모듈 내에서만 사용 가능

// 상속 -> open 키워드가 있어야 가능함 ㄹㅈㄷ
open class Animal {}
class Dog: Animal() {}

open class Animal2(val name: String) {

}

class Dog2(name3: String): Animal2(name3) {

}

class Dog3: Animal2 {
    constructor(name3: String): super(name3)
}

// 추상 클래스
// 인스턴스화 할 수 없다.
// 상속을 위한 class
abstract class AbstractClass {
    abstract fun printFunc()
    open fun addFunc(a: Int) {
        println(a + 3)
    }
}

class AbstractBClass: AbstractClass() {
    override fun printFunc() {
        println("abstract Class Function")
    }

    override fun addFunc(a: Int) {
        //super 호출은 선택
//        super.addFunc(a)
        println(a + 15)
    }
}
var abstractB = AbstractBClass()
abstractB.addFunc(10)

// like Protocol
interface Runnable {
    var type: Int
    fun run()
    fun fastRun() = println("빨리 달린다.")
}

interface Runnable2 {
    var type2: Int
    fun run2()
    fun fastRun() = println("빨리 달린다.")
}
// open 없어도 override 할 수 있다.
// interface 말고는 전부 open 해야 가능하다.
// super 가능
// 변수명 또는 함수가 겹치는 반드시 override를 해야한다.
class RunnableClass: Runnable, Runnable2 {
    override var type: Int = 0
    override fun run() {
        print("Run!!!!")
        super<Runnable2>.fastRun()
    }

    override var type2: Int = 0
    override fun run2() {
        print("Run!!!!")
        super<Runnable>.fastRun()
    }

    override fun fastRun() {
        println("asdfadf")
    }
}

// 중첩 클래스, 내부 클래스
class OuterClass {
    var num1 = 10
    class NestedClass {
        var num2 = 20
        fun something1() {
            println(num2)
        }
        fun something2() = 20
    }

    inner class InnerClass {
        fun something1() {
            num1 -= 123
            println(num1)
        }
        fun something2() = 20
        fun getOuterReferences(): OuterClass = this@OuterClass
    }
}
var nestedClass = OuterClass.NestedClass()
nestedClass.something1()
var innerClass = OuterClass().InnerClass()
innerClass.something1()
var outerClass = innerClass.getOuterReferences()
outerClass.num1

// Companion Object
class CompanionClass {
    companion object {
        fun callMe() {
            println("sdf")
            println("Companion object $this")
        }
    }
}
CompanionClass.callMe()

// object class -> 싱글톤 객체로 만들어줌
// 익명 함수마냥 익명 객체 생성가능
// = object: 상위클래스() {
// ...
// {
// 이런게 가능
object Singleton {
    private var a: Int = 0
    var b: Int = 1
    fun makeMe12(): Int {
        a += 12
        b += 2
        return a+b
    }
}

// ㄹㅈㄷ
open class ObjectClass(name: String, age: Int = 20) {
    init {

    }
    fun eat() = println("do something")
    open fun pray() = println("open function")
}

val singletonClass = Singleton.makeMe12()
println("${Singleton.makeMe12()}")
println("$singletonClass 3")

val newObjectClass = object: ObjectClass("Hello") {
    override fun pray() {
        println("Override Function")
    }
}
newObjectClass.pray()

// Data Class
data class DataClass(var name: String, val age: Int, var defa: String = "Default Value")

var dc = DataClass("abc", 123)
var dc2 = dc.copy()
var dcRef = dc
dc.name = "new Name"
dc2.name
dc.component1()
dc.component2()
dcRef.name

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255,0,0),
    YELLOW(255,255,0),
    GREEN(0,255,0),
    BLUE(0,0,255);
}

fun getWarn(color: Color) = when(color) {
    Color.RED, Color.YELLOW -> "warm"
    Color.BLUE -> "asdf"
    Color.GREEN -> "asdf24"
}
Color.RED.r
Color.RED.ordinal

// 추상 클래스 인스턴스 생성 안됨
// 같은 파일에서 선언되어야함.(fileprivate)
sealed class SealedClass
class Const(val value: Double): SealedClass()
class Sum(val left: SealedClass, val right: SealedClass): SealedClass()
object NotANumber: SealedClass()

fun eval(e: SealedClass): Double = when(e) {
    is Const -> e.value
    is Sum -> eval(e.right) + eval(e.left)
    NotANumber -> 0.0
}
