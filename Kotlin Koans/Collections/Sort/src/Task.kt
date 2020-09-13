// Return a list of customers, sorted in the descending by number of orders they have made
fun Shop.getCustomersSortedByOrders(): List<Customer> =
        customers.sortedByDescending { e -> e.orders.size }

fun Shop.getCustomersSortedByOrdersNicer(): List<Customer> =
        customers.sortedByDescending { it.orders.size }
