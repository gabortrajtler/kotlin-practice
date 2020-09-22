import kotlin.collections.HashMap

fun buildMap(build: HashMap<Int, String>.() -> Unit): HashMap<Int, String> {
    val map = HashMap<Int, String>()
    map.build()
    return map
}

fun <K, V> buildMapNicer(build: HashMap<K, V>.() -> Unit): Map<K, V> {
    val map = HashMap<K, V>()
    map.build()
    return map
}

fun usage(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
