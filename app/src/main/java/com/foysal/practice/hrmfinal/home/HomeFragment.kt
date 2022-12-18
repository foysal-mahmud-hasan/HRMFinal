package com.foysal.practice.hrmfinal.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.foysal.practice.hrmfinal.R
import com.foysal.practice.hrmfinal.database.UserDatabase
import com.foysal.practice.hrmfinal.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {




        val binding : FragmentHomeBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_home,container, false)

        val application = requireNotNull(this.activity).application

        val arguments = HomeFragmentArgs.fromBundle(requireArguments())

        Log.i("USER", "{${arguments.id}}")

        val viewModelJob = Job()

        val scope = CoroutineScope(Dispatchers.Main + viewModelJob)
        val database = UserDatabase.getInstance(application, scope)

        val viewModelFactory = HomeViewModelFactory(arguments.id,arguments.role, database)
        val homeViewModel = ViewModelProvider(
            this, viewModelFactory)[HomeViewModel::class.java]

        binding.homeViewModel = homeViewModel

        return binding.root
    }

}