package com.visionular.auroralive.demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.visionular.auroralive.demo.R
import com.visionular.auroralive.demo.databinding.EntryLiveFragBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class EntryLiveFragment : Fragment() {

    private var _binding: EntryLiveFragBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = EntryLiveFragBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.entryLiveButton.setOnClickListener {
            val playbackId = binding.playbackIdEditView.text.toString()

            if (playbackId.isEmpty()) {
                Toast.makeText(context, "playback id is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val token = binding.tokenEditView.text.toString()
            val action = EntryLiveFragmentDirections.actionEntryLiveFragmentToLiveFragment(playbackId, token)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}