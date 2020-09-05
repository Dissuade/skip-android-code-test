package ca.skipthedishes.codetest.ui.restaurants

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import ca.skipthedishes.codetest.databinding.RestaurantFragmentBinding
import ca.skipthedishes.codetest.databinding.RestaurantSortFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class RestaurantsFragment : Fragment() {

    private val viewModel by viewModels<RestaurantsViewModel>()
    private lateinit var binding: RestaurantFragmentBinding
    private val adapter by lazy { RestaurantsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RestaurantFragmentBinding.inflate(inflater, container, false)

        setupRecyclerView()

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.restaurants.observe(viewLifecycleOwner,
            Observer { restaurants -> adapter.submitList(restaurants) }
        )
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(context)
        val dividerItemDecoration = DividerItemDecoration(context, layoutManager.orientation)

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
        binding.recyclerView.adapter = adapter
    }

    companion object {
        fun newInstance() = RestaurantsFragment()
    }
}
