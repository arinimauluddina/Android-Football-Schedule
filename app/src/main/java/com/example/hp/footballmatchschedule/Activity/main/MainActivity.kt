package com.example.hp.footballmatchschedule.activity.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hp.footballmatchschedule.model.MatchEvent
import com.example.hp.footballmatchschedule.R
import com.example.hp.footballmatchschedule.adapter.TeamsAdapter
import com.example.hp.footballmatchschedule.data.repository.MatchEventRepositoryPresenter
import com.example.hp.footballmatchschedule.network.ApiClient
import com.example.hp.footballmatchschedule.utils.invisible
import com.example.hp.footballmatchschedule.utils.visible
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView, BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var mPresenter: MainPresenter
    lateinit var mAdapter: TeamsAdapter

    var mApiClient: ApiClient? = ApiClient()
    private var matchLists : MutableList<MatchEvent> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()
        setView()
        onAttach()

        menuBottom.setOnNavigationItemSelectedListener(this)


    }

    private fun initPresenter() {
        mPresenter = MainPresenter(MatchEventRepositoryPresenter
            (mApiClient?.providerService())
        )
    }

    private fun setView() {
        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        mAdapter = TeamsAdapter(this, matchLists)
        rvFootBall.setHasFixedSize(true)
        rvFootBall.layoutManager = layoutManager
        rvFootBall.adapter = mAdapter
    }

    override fun hideLoading() {
        mainProgBar.invisible()
    }

    override fun showLoading() {
        mainProgBar.visible()
    }

    override fun displayFootballMatch(matchList: List<MatchEvent>) {
        matchLists.clear()
        matchLists.addAll(matchList)
        mAdapter.notifyDataSetChanged()
    }

    override fun onAttach() {
        mPresenter.onAttach(this)
        mPresenter.getFootballMatchData()
    }

    override fun onDettach() {
        mPresenter.onDettach()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.lastMatch -> {
                mPresenter.getFootballMatchData()
            }
            R.id.nextMatch -> {
                mPresenter.getFootballUpcomingData()
            }
        }

        return true
    }

}
