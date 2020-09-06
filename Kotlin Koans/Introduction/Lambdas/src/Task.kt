fun containsEven(collection: Collection<Int>): Boolean =
        collection.any { e -> e % 2 == 0 }

fun containsEvenNicer(collection: Collection<Int>): Boolean =
        collection.any { it % 2 == 0 }
