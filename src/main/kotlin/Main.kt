fun main() {
    // Задача №1 - «Только что»
    val time = 16000
    println(agoToText(time))
}

fun agoToText(time: Int): String {
    return when (time) {
        in 0..60 -> "был(а) только что"
        in 61..3600 -> "был(а) ${time / 60} ${minuteAgo(time)}"
        in 3601..86400 ->
            "был(а) ${time / 3600} ${hourAgo(time)} и ${(time - time / 3600 * 3600) / 60}  ${
                minuteAgo((time - time / 3600 * 3600) / 60)
            }"
        in 86_401..172_800 -> "был(а) сегодня"
        in 172_801..259_200 -> "был(а) вчера"
        else -> "был(а) давно"
    }
}

fun hourAgo(time: Int): String {
    return when (time / 3600) {
        1, 21 -> "час"
        2, 3, 4, 22, 23, 24 -> "часа"
        else -> "часов"
    }
}

fun minuteAgo(time: Int): String {
    return when (time / 60) {
        2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> " минуты назад"
        21, 31, 41, 51 -> "минуту назад"
        else -> "минут назад"
    }
}