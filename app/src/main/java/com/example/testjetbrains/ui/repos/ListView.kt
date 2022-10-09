package com.example.testjetbrains.ui.repos

import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.testjetbrains.databinding.FragmentGetListBinding

class ListView(
    private val binding: FragmentGetListBinding,
    owner: LifecycleOwner,
    private val goToDetailFragment: (String, String) -> Unit,
    viewModel: ListViewModel
) : ListAdapter.OnItemListClickedListener {

    init {
        viewModel.state.observe(owner, Observer { list ->
            binding.emptyList.isVisible = list.isEmpty()
            binding.recyclerView.isVisible = list.isNotEmpty()
            initializeRecyclerView(list)

        })

        viewModel.getAllList()

        binding.pullRefresh.setOnRefreshListener {
            binding.pullRefresh.isRefreshing = false
            viewModel.getAllList()
        }
    }

    private fun initializeRecyclerView(list: List<JetBrainsUi>) {
        val adapter = ListAdapter()
        adapter.jetBrainsList = ArrayList(list)
        binding.recyclerView.adapter = adapter
        adapter.updateListener(this)
    }

    override fun onItemClicked(fullName: String, description: String) {
        goToDetailFragment.invoke(fullName, description)
    }
}