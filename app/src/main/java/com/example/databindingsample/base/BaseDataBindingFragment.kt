package com.example.databindingsample.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.databindingsample.dashboard.DashboardViewModelFactory

abstract class BaseDataBindingFragment<T : ViewDataBinding> : Fragment() {

    val viewModelFactory by lazy { DashboardViewModelFactory() }

    protected abstract fun getContentResource(): Int

    lateinit var dataBinding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(
            inflater, getContentResource(), container, false
        )
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
    }

    @CallSuper
    protected open fun initViews() {
    }

}
