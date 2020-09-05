package ca.skipthedishes.codetest.ui.restaurants

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.skipthedishes.codetest.model.DummyRestaurantsRepository
import ca.skipthedishes.codetest.model.Restaurant
import ca.skipthedishes.codetest.model.RestaurantsRepository
import ca.skipthedishes.codetest.ui.restaurants.sorting.SortType

class RestaurantsViewModel(
    repository: RestaurantsRepository = DummyRestaurantsRepository()
) : ViewModel() {
    val restaurants = MutableLiveData<List<Restaurant>>(repository.restaurants())

    fun sort(type: SortType) {
        TODO("Not implemented yet")
    }
}

