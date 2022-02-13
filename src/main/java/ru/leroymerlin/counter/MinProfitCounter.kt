package ru.leroymerlin.counter

import ru.leroymerlin.data.Item
import ru.leroymerlin.data.Service


class MinProfitCounter {
    private var itemName: String
    private var sum: Double
    private var quantity: Int
    private var commission: Double

    constructor(item: Item) {
        quantity = item.quantity
        itemName = item.itemName
        sum = item.sum
        commission = item.commission
    }

    constructor(service: Service) {
        itemName = service.itemName
        sum = service.sum
        quantity = 1
        commission = service.commission
    }

    /**
     * Считает минимальную выручку.
     */
    private fun minProfit(): Double {
        return (sum * quantity / 100 * commission)
    }

    /**
     * Выводит строку в консоль с результатами подсчетов.
     */
    fun showData() {
        println(
            "Минимальная выручка " + minProfit() + " по товару/услуге \"" + itemName +
                    "\", с комиссией " + commission.toInt() + "%."
        )
    }

}