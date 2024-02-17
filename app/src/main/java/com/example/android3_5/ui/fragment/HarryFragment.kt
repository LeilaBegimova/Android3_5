package com.example.android3_5.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.android3_5.databinding.FragmentHarryBinding
import com.example.android3_5.ui.adapter.HarryAdapter
import com.example.android3_5.ui.viewModels.HarryViewModel


class HarryFragment : Fragment() {
    private var _binding: FragmentHarryBinding? = null
    private val binding: FragmentHarryBinding get() = _binding!!
    private val viewModel by viewModels<HarryViewModel>()
    private val harryAdapter = HarryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHarryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        subscribeToHarryPotter()
        searcch()
    }

    private fun initialize() {
        binding.rvHarry.adapter = harryAdapter

    }

    private fun searcch() {
        binding.edit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.let {
                    viewModel.searchHarry(it.toString())
                }
            }


            override fun afterTextChanged(s: Editable?) {
            }

        })
    }

    private fun subscribeToHarryPotter() {
        viewModel.characterLiveData.observe(viewLifecycleOwner) { uiState ->
            Log.e("error", "subscribeToHarryPotter:")
            uiState?.let {
                if (it.success != null) {
                    harryAdapter.setHarryCharacter(it.success)

                } else {
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}