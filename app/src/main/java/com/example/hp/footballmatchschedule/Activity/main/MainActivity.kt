package com.example.hp.footballmatchschedule.Activity.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.method.TextKeyListener.clear
import com.example.hp.footballmatchschedule.Adapter.TeamsAdapter
import com.example.hp.footballmatchschedule.Api.TheSportDBApi
import com.example.hp.footballmatchschedule.Api.TheSportDBRest
import com.example.hp.footballmatchschedule.Model.MatchEvent
import com.example.hp.footballmatchschedule.Model.MatchEventPresenter
import com.example.hp.footballmatchschedule.R
import com.example.hp.footballmatchschedule.R.id.lastMatch
import com.example.hp.footballmatchschedule.R.id.nextMatch
import com.example.hp.footballmatchschedule.Utils.invisible
import com.example.hp.footballmatchschedule.Utils.visible
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import java.util.Collections.addAll

class MainActivity : AppCompatActivity(), AnkoLogger, MainView.View {

    lateinit var mPresenter: MainPresenter

    private var matchLists : MutableList<MatchEvent> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service = TheSportDBApi.getClient().create(TheSportDBRest::class.java)
        val request = MatchEventPresenter(service)
        mPresenter = MainPresenter(this, request)
        mPresenter.getFootballMatchData()

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                lastMatch -> {
                    mPresenter.getFootballMatchData()
                }
                nextMatch -> {

                    mPresenter.getFootballUpcomingData()
                }

            }
            true

        }
        bottom_navigation.selectedItemId = lastMatch
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
        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rvFootball.layoutManager = layoutManager
        rvFootball.adapter = TeamsAdapter(matchList,applicationContext)
    }
}
