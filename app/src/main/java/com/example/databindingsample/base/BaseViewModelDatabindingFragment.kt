package com.example.databindingsample.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding

abstract class BaseViewModelDatabindingFragment<T : BaseViewModel, X : ViewDataBinding> : BaseDataBindingFragment<X>() {

    protected val viewModel by lazy { buildViewModel() }

    protected abstract fun buildViewModel(): T

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    @CallSuper
    protected open fun initLiveDataObservers() {
    }

}
