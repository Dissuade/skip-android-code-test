package ca.skipthedishes.codetest.ui.restaurants

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import ca.skipthedishes.codetest.model.Restaurant
import ca.skipthedishes.codetest.model.RestaurantsRepository
import ca.skipthedishes.codetest.model.TimeEstimate
import ca.skipthedishes.codetest.ui.restaurants.sorting.SortType
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import kotlin.random.Random


class RestaurantsViewModelTest {
    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun testSortByScore() {
        val restaurants = (1..100).map { it / 10.0 }
            .shuffled()
            .map { restaurant(score = it) }

        val viewModel = RestaurantsViewModel(
            repository = restaurantRepository(restaurants = restaurants)
        )

        viewModel.sort(SortType.ByScore)

        assertEquals(
            restaurants.map { it.score }.sorted().reversed(),
            viewModel.restaurants.value?.map { it.score }
        )
    }

    @Test
    fun testSortByEstimate() {
        val restaurants = (1..100).shuffled()
            .map { restaurant(estimate = timeEstimate(Random.nextInt(it), it)) }

        val viewModel = RestaurantsViewModel(
            repository = restaurantRepository(restaurants = restaurants)
        )

        viewModel.sort(SortType.ByTime)

        assertEquals(
            restaurants.map { it.estimate.max }.sorted(),
            viewModel.restaurants.value?.map { it.estimate.max }
        )
    }
}

fun restaurantRepository(restaurants: List<Restaurant>): RestaurantsRepository {
    return object : RestaurantsRepository {
        override fun restaurants() = restaurants
    }
}

fun restaurant(
    name: String = "",
    estimate: TimeEstimate = timeEstimate(),
    image: Int = 0,
    score: Double = 0.0
): Restaurant {
    return Restaurant(
        name = name,
        estimate = estimate,
        image = image,
        score = score
    )
}

fun timeEstimate(min: Int = 0, max: Int = 0): TimeEstimate {
    return TimeEstimate(min, max)
}