package com.example.testjetbrains.ui.repos.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testjetbrains.databinding.FragmentDetailBinding

private const val ARG_PARAM1 = "fullName"
private const val ARG_PARAM2 = "description"

class DetailFragment : Fragment() {
    private var fullName: String? = null
    private var description: String? = null
    private lateinit var binding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            fullName = it.getString(ARG_PARAM1)
            description = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fullName.text= fullName
        binding.description.text= description
    }

    companion object {

        @JvmStatic
        fun newInstance(fullName: String, description: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, fullName)
                    putString(ARG_PARAM2, description)
                }
            }
    }
}