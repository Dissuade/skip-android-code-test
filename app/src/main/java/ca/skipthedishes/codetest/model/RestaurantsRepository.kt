package ca.skipthedishes.codetest.model

import ca.skipthedishes.codetest.R

interface RestaurantsRepository {
    fun restaurants(): List<Restaurant>
}

class DummyRestaurantsRepository :
    RestaurantsRepository {
    override fun restaurants(): List<Restaurant> {
        return listOf(
            roger(),
            justin(),
            victor(),
            eduardo(),
            nico()
        )
    }

    private fun nico() =
        Restaurant(
            name = "Nico's Nuggets",
            estimate = TimeEstimate(
                min = 10,
                max = 45
            ),
            image = R.drawable.cake,
            score = 6.7
        )

    private fun justin() =
        Restaurant(
            name = "Justin's Gluten Free Cakes",
            estimate = TimeEstimate(
                min = 60,
                max = 90
            ),
            image = R.drawable.cake,
            score = 3.2
        )

    private fun victor() =
        Restaurant(
            name = "Victor's Café",
            estimate = TimeEstimate(
                min = 5,
                max = 15
            ),
            image = R.drawable.coffee,
            score = 8.3
        )

    private fun roger() =
        Restaurant(
            name = "Roger's Sandwiches",
            estimate = TimeEstimate(
                min = 20,
                max = 25
            ),
            image = R.drawable.sandwich,
            score = 8.3
        )


    private fun eduardo() =
        Restaurant(
            name = "Eduardo's Hotdogs",
            estimate = TimeEstimate(
                min = 7,
                max = 12
            ),
            image = R.drawable.hotdog,
            score = 10.0
        )
}