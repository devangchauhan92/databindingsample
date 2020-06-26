package com.example.databindingsample.dashboard

import androidx.lifecycle.ViewModelProviders
import com.example.databindingsample.R
import com.example.databindingsample.base.BaseViewModelDatabindingFragment
import com.example.databindingsample.databinding.FragmentDashboardBinding
import com.example.databindingsample.util.UserModel
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : BaseViewModelDatabindingFragment<DashboardViewModel, FragmentDashboardBinding>() {

    private val userAdapter by lazy { UserAdapter() }

    override fun getContentResource() = R.layout.fragment_dashboard

    override fun buildViewModel(): DashboardViewModel {
        return ViewModelProviders.of(this, viewModelFactory)[DashboardViewModel::class.java]
    }

    override fun initViews() {
        super.initViews()
        dataBinding.viewModel = viewModel
        rvUsers.adapter = userAdapter

        var list = mutableListOf<UserModel>()
        var user = UserModel()
        user.userId = "1"
        user.firstName = "Shah rukh"
        user.lastName = "Khan"
        list.add(user)

        var user1 = UserModel()
        user1.userId = "2"
        user1.firstName = "Salman"
        user1.lastName = "Khan"
        list.add(user1)

        var user2 = UserModel()
        user2.userId = "3"
        user2.firstName = "Amir"
        user2.lastName = "Khan"
        list.add(user2)

        userAdapter.setData(list)

    }

}