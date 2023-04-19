package model

import java.util.*

enum class Currency {
    RUB, USD, EUR;

    companion object {
        fun fromString(s: String): Currency {
            val normalizedName = s.uppercase(Locale.getDefault());
            val availableValues = values().map { it.name }
            if (availableValues.contains(normalizedName)) {
                return valueOf(normalizedName)
            } else {
                throw IllegalArgumentException("Unknown currency: $s")
            }
        }
    }
}