package ca.skipthedishes.codetest.ui.restaurants.sorting

sealed class SortType {
    /**
     * Sorts Restaurants according to their worst estimated order time.
     * - Returns: Restaurants sorted ascending, by their maximum estimated order times
     */
    object ByTime : SortType()

    /**
     * Optimistically sorts Restaurants according to their score.
     * - Returns: Restaurants scores descending, by their score.
     */
    object ByScore : SortType()
}