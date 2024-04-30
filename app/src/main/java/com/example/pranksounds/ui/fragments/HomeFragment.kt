package com.example.pranksounds.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.pranksounds.R
import com.example.pranksounds.databinding.ActivityMainBinding
import com.example.pranksounds.ui.activities.SoundsListActivity
import com.example.pranksounds.databinding.FragmentHomeBinding
import com.example.pranksounds.ui.activities.MainActivity
import com.example.pranksounds.viewModels.HomeViewModel
import com.example.pranksounds.ui.adapters.SoundCategoryClickListener
import com.example.pranksounds.ui.adapters.SoundsCategoriesListAdapter
import com.example.pranksounds.utils.Constants
import com.example.pranksounds.viewModels.HeaderViewModel
import kotlinx.coroutines.launch
import java.util.Locale

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var soundsCategoriesListAdapter: SoundsCategoriesListAdapter
    private lateinit var homeViewModel: HomeViewModel
    private val headerViewModel: HeaderViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapterOnSoundsList()
    }

    override fun onResume() {
        super.onResume()
        headerViewModel.updateText(getString(R.string.funny_sounds))
    }

    private fun setupAdapterOnSoundsList() {
        soundsCategoriesListAdapter = SoundsCategoriesListAdapter(homeViewModel.getAllSoundCategories(requireActivity()), SoundCategoryClickListener {

            val intent = Intent(requireActivity(), SoundsListActivity::class.java)
            intent.putExtra(Constants.SELECTED_CATEGORY, it)
            startActivity(intent)

            Constants.USER_INTERACTIONS_COUNT++
        })

        binding.rvSoundsList.adapter = soundsCategoriesListAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}