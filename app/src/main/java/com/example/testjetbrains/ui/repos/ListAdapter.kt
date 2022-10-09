package com.example.testjetbrains.ui.repos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testjetbrains.databinding.ItemListBinding

internal class ListAdapter : RecyclerView.Adapter<ListAdapter.JetBrainsViewHolder>() {

    var jetBrainsList: ArrayList<JetBrainsUi> = arrayListOf()
    private var listener: OnItemListClickedListener? = null

    lateinit var binding: ItemListBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JetBrainsViewHolder {
        binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JetBrainsViewHolder(binding.root)
    }

    override fun getItemCount(): Int = jetBrainsList.size

    override fun onBindViewHolder(holder: JetBrainsViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        val item = jetBrainsList[position]
        binding.fullName.text = item.fullName
        binding.forks.text = item.forks
        binding.openIssues.text = item.openIssues
        binding.watchers.text = item.watchers
    }

    fun updateListener(listener: OnItemListClickedListener) {
        this.listener = listener
    }

    class JetBrainsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface OnItemListClickedListener {
    }
}