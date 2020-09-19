// Return all products the given customer has ordered
fun Customer.getOrderedProducts(): List<Product> =
        orders.flatMap { it.products }

// Return all products that were ordered by at least one customer
fun Shop.getOrderedProducts(): Set<Product> =
        customers.flatMap(Customer::orders)
                .flatMap(Order::products)
                .toSet()

fun Shop.getOrderedProductsNicer(): Set<Product> =
        customers.flatMap(Customer::getOrderedProducts).toSet()
