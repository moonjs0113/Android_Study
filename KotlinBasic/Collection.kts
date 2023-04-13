// List
// 읽기 전용
var foods: List<String> = listOf("라면", "갈비", "밥")
// var foods = listOf("라면", "갈비", "밥")
// foods.add("국물")

// val mutableFoods = mutableListOf<String>
val mutableFoods: MutableList<String> = mutableListOf("라면", "계란", "밥")
mutableFoods.add("초밥")
mutableFoods[1] = "국물"
mutableFoods.set(2, "밥과 반찬")
println(mutableFoods)
// java -> ArrayList<T>()

// Map -> Dictionary 랑 비슷하다.
val map = mapOf("A" to 1, "b" to 2)
map.getValue("A")
for ((k,v) in map) {
    println("$k -> $v")
}
val citiesMap = mutableMapOf("한국" to "서울", "일본" to "동경", "중국" to "북경")
citiesMap["한국"] = "서울특별시"
println(citiesMap)
citiesMap["미국"] = "워싱턴"
println(citiesMap)
citiesMap.put("미국", "워싱턴DC") // 기존 값을 반환해준다.
println(citiesMap)
// java -> HashMap<T,F>()

// Set
val citySet = setOf(1,3,5,7)
citySet.size
val mutableSet = mutableSetOf(1,2,3,4,5,6)
mutableSet.add(3) // 이미 있다면 false 반환
mutableSet
mutableSet.add(8)
mutableSet
mutableSet.add(11)
mutableSet
mutableSet.intersect(citySet)




















