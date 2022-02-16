package ru.leroymerlin.counter

import ru.leroymerlin.data.Item
import ru.leroymerlin.data.Service
import ru.leroymerlin.protocol.ReportType

class RevenueCounter(items: List<Item>, services: List<Service>, revenue: Map<ReportType, Double>) {
    private var itemSumProfit: Double = 0.0
    private var serviceSumProfit: Double = 0.0
    private var itemSumFromFile: Double = 0.0
    private var serviceSumFromFile: Double = 0.0

    init {
        this.itemSumFromFile = revenue.getValue(ReportType.ITEM)
        this.serviceSumFromFile = revenue.getValue(ReportType.SERVICE)
        for (i in items) {
            this.itemSumProfit += (i.sum * i.quantity / 100 * i.commission)
        }
        for (i in services) {
            this.serviceSumProfit += (i.sum / 100 * i.commission)
        }
    }

    /**
     * Проверяет равенство данных по товарам.
     */
    fun isItemRevenueIsEqual(): Boolean {
        return (itemSumProfit == itemSumFromFile)
    }

    /**
     * Проверяет равенство данных по услугам.
     */
    fun isServiceRevenueIsEqual(): Boolean {
        return (serviceSumProfit == serviceSumFromFile)
    }

    /**
     * Показывает полученные данные.
     */
    fun showData() {
        println("Данные по товарам из текущих отчетов:          $itemSumProfit")
        println("Данные по товарам из отчета отдела финансов:   $itemSumFromFile")
        println("Данные по услугам из текущих отчетов:          $serviceSumProfit")
        println("Данные по услугам из отчета отдела финансов:   $serviceSumFromFile")
    }

}
