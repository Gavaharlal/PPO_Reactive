package currency

import model.Currency

class ConverterProvider {
    fun get(): Converter {
        val courses = mapOf(
            Currency.EUR to 90.0,
            Currency.USD to 80.0,
            Currency.RUB to 1.0
        )
        val rates = HashMap<Pair<Currency, Currency>, Double>()
        for (from in Currency.values()) {
            for (to in Currency.values()) {
                if (from == to) {
                    rates[Pair(from, to)] = 1.0
                } else {
                    rates[Pair(from, to)] =
                        courses[to]!! / courses[from]!!
                }
            }
        }
        return Converter(rates)
    }
}
