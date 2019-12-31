package com.example.hp.footballmatchschedule.activity.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hp.footballmatchschedule.R
import com.example.hp.footballmatchschedule.data.repository.MatchEventRepositoryPresenter
import com.example.hp.footballmatchschedule.model.MatchEvent
import com.example.hp.footballmatchschedule.model.Teams
import com.example.hp.footballmatchschedule.data.remote.ApiClient
import com.example.hp.footballmatchschedule.utils.loadImage
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailView{

    lateinit var mPresenter : DetailPresenter

    var mApiClient: ApiClient? =
        ApiClient()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initPresenter()
        onAttach()
    }

    private fun initPresenter(){
        mPresenter = DetailPresenter(MatchEventRepositoryPresenter
            (mApiClient?.providerService())
        )
    }

    private fun initData(matchEvent : MatchEvent) {

        txtDateSchedule.text = matchEvent.dateEvent

        txtHomeDetail.text = matchEvent.strHomeTeam
        txtAwayDetail.text = matchEvent.strAwayTeam

        txtHomeScore.text = matchEvent.intHomeScore
        txtAwayScore.text = matchEvent.intAwayScore

        txtHomeShoot.text = matchEvent.intHomeShots
        txtAwayShoot.text = matchEvent.intAwayShots

        txtHomeGoal.text = matchEvent.strHomeGoalDetails
        txtAwayGoal.text = matchEvent.strAwayGoalDetails

        txtHomeGoalKeeper.text = matchEvent.strHomeLineupGoalkeeper
        txtAwayGoalKeeper.text = matchEvent.strAwayLineupGoalkeeper

        txtHomeDefense.text = matchEvent.strHomeLineupDefense
        txtAwayDefense.text = matchEvent.strAwayLineupDefense

        txtHomeMidField.text = matchEvent.strHomeLineupMidfield
        txtAwayMidField.text = matchEvent.strAwayLineupMidfield

        txtHomeFoward.text = matchEvent.strHomeLineupForward
        txtAwayFoward.text = matchEvent.strAwayLineupForward
    }

    override fun displayTeamBadgeHome(team: Teams) {
        img_home.loadImage(team.strTeamBadge)
    }

    override fun displayTeamBadgeAway(team: Teams) {
        img_away.loadImage(team.strTeamBadge)
    }

    override fun onAttach() {
        mPresenter.onAttach(this)

        val mEvent : MatchEvent= intent.getParcelableExtra(com.example.hp.footballmatchschedule.utils.TAG)
        initData(mEvent)
        supportActionBar?.title = mEvent.strEvent

        mPresenter.getTeamsBadgeHome(mEvent.idHomeTeam)
        mPresenter.getTeamsBadgeAway(mEvent.idAwayTeam)
    }

    override fun onDettach() {
        mPresenter.onDettach()
    }
}