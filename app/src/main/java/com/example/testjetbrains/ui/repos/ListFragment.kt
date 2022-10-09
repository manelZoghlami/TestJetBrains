package com.example.testjetbrains.ui.repos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testjetbrains.databinding.FragmentGetListBinding
import com.example.testjetbrains.di.injector
import javax.inject.Inject

class ListFragment : Fragment() {
    private lateinit var binding: FragmentGetListBinding

    @Inject
    lateinit var listViewModel: ListViewModel
    private var mListener: OnListFragmentListener? = null
    private var mView: ListView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector?.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGetListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mView = ListView(
            binding = binding,
            owner = viewLifecycleOwner,
            goToDetailFragment = { fullName, description ->
                mListener?.goToDetail(
                    fullName,
                    description
                )
            },
            viewModel = listViewModel
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }

    interface OnListFragmentListener {
        fun goToDetail(fullName: String, description: String)

    }
}