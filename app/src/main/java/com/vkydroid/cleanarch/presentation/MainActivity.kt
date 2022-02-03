package com.vkydroid.cleanarch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.vkydroid.cleanarch.R
import com.vkydroid.cleanarch.databinding.ActivityMainBinding
import com.vkydroid.cleanarch.domain.People
import com.vkydroid.cleanarch.presentation.adapter.PeopleAdapter
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class MainActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModel: MainViewModel
    private var dataSet = ArrayList<People>()
    private lateinit var peopleAdapter: PeopleAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var rvPeople: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initViews()
        setListeners()
        setAdapter()
        setUpObservers()
        viewModel.getRemotePeopleList()
    }

    private fun setListeners() {
        binding.btnClick.setOnClickListener {
            viewModel.getRemotePeopleList()
        }
    }

    private fun initViews() {
        progressBar = binding.pbProgress
        rvPeople = binding.rvPeople
    }

    private fun setAdapter() {
        rvPeople.layoutManager = LinearLayoutManager(this)
        peopleAdapter = PeopleAdapter(dataSet)
        rvPeople.adapter = peopleAdapter
    }

    private fun setUpObservers() {
        viewModel.dataLoading.observe(this, {
            if (it)
                progressBar.visibility = View.VISIBLE
            else
                progressBar.visibility = View.GONE
        })

        viewModel.error.observe(this, {
            if (it.isNullOrEmpty().not()) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.peopleList.observe(this, {
            if (it.isNullOrEmpty().not()) {
                dataSet.clear()
                dataSet.addAll(it)
                peopleAdapter.notifyDataSetChanged()
            }
        })
    }
}