// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> {
    return customers.filter { customer ->
        val (isDelivered, isNotDelivered) = customer.orders.partition{ it.isDelivered }
        isNotDelivered.size > isDelivered.size
    }.toSet()
}
