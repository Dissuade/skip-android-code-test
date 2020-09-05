package ca.skipthedishes.codetest.ui.restaurants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ca.skipthedishes.codetest.databinding.ViewRestaurantItemBinding
import ca.skipthedishes.codetest.model.Restaurant
import ca.skipthedishes.codetest.ui.restaurants.RestaurantsAdapter.RestaurantViewHolder

class RestaurantsAdapter : ListAdapter<Restaurant, RestaurantViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            ViewRestaurantItemBinding.inflate(
                layoutInflater,
                parent,
                false
            )
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    data class RestaurantViewHolder(
        val binding: ViewRestaurantItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurant: Restaurant) {
            binding.restaurant = restaurant
            binding.executePendingBindings()
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Restaurant>() {
            override fun areItemsTheSame(old: Restaurant, new: Restaurant) = old == new

            override fun areContentsTheSame(old: Restaurant, new: Restaurant) = old == new
        }
    }
}