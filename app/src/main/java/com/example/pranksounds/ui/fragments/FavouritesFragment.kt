package com.example.pranksounds.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.pranksounds.R
import com.example.pranksounds.data.source.local.SoundItem
import com.example.pranksounds.databinding.FragmentFavouritesBinding
import com.example.pranksounds.ui.activities.PlaySoundActivity
import com.example.pranksounds.ui.adapters.FavSoundClickListener
import com.example.pranksounds.ui.adapters.FavSoundsListAdapter
import com.example.pranksounds.utils.Constants
import com.example.pranksounds.ui.viewModels.FavouritesViewModel
import com.example.pranksounds.ui.viewModels.HeaderViewModel

class FavouritesFragment : Fragment() {

    private var _binding: FragmentFavouritesBinding? = null
    private val favouritesViewModel: FavouritesViewModel by activityViewModels()
    private val headerViewModel: HeaderViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*(requireActivity() as MainActivity).binding.tvHeader.text = getString(R.string.favourites)*/
        setupAdapterOnSoundsList()
    }

    override fun onResume() {
        super.onResume()
        headerViewModel.updateText(getString(R.string.favourites))
    }

    private fun setupAdapterOnSoundsList() {
        val soundsListAdapter = FavSoundsListAdapter(FavSoundClickListener {
            val intent = Intent(requireActivity(), PlaySoundActivity::class.java)
            intent.putExtra(Constants.SELECTED_SOUND, it)
            startActivity(intent)

            Constants.USER_INTERACTIONS_COUNT++
        })

        binding.rvSoundsList.adapter = soundsListAdapter

        favouritesViewModel.getFavSoundsList(requireActivity()).observe(viewLifecycleOwner) { soundList ->

            val soundItemList = soundList.map { sound ->
                // Convert each Sound object to SoundItem
                SoundItem(
                    sound.soundId,
                    sound.title,
                    sound.colorCode,
                    sound.fileName,
                    sound.bgImage
                )
            }

            soundsListAdapter.setData(soundItemList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}