package com.foysal.practice.hrmfinal.entry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.foysal.practice.hrmfinal.R
import com.foysal.practice.hrmfinal.database.UserDatabase
import com.foysal.practice.hrmfinal.databinding.FragmentEntryBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class EntryFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding : FragmentEntryBinding = DataBindingUtil.inflate(inflater,
        R.layout.fragment_entry,container,false)

        val viewModelJob = Job()
        val scope = CoroutineScope(Dispatchers.Main + viewModelJob)
        val application = requireNotNull(this.activity).application
        val database = UserDatabase.getInstance(application, scope)
        val arguments = EntryFragmentArgs.fromBundle(requireArguments())

        val viewModelFactory = EntryViewModelFactory(arguments.id, database, application)
        val entryViewModel = ViewModelProvider(this, viewModelFactory).get(EntryViewModel::class.java)


        return binding.root
    }
}