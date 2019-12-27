package com.example.hp.footballmatchschedule.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hp.footballmatchschedule.R
import com.example.hp.footballmatchschedule.activity.detail.DetailActivity
import com.example.hp.footballmatchschedule.model.MatchEvent
import com.example.hp.footballmatchschedule.utils.TAG
import com.example.hp.footballmatchschedule.utils.loadImage
import com.example.hp.footballmatchschedule.utils.logD
import kotlinx.android.synthetic.main.layout_match_item.view.*

class TeamsAdapter(val context: Context?, val eventList:List<MatchEvent>) : RecyclerView.Adapter<TeamsAdapter.ClubViewHolder>() {


    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int): ClubViewHolder{
        return ClubViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_match_item, parent, false))
    }

    override fun getItemCount() : Int = eventList.size


    override fun onBindViewHolder(holder: ClubViewHolder, position: Int){
        holder.bind(eventList[position])
    }

    inner class ClubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        @SuppressLint("SetTextI18n")
        fun bind(event: MatchEvent) {
            itemView.txtDateSchedule.text = event.dateEvent
            itemView.txtHome.text = event.strHomeTeam
            itemView.txtAway.text = event.strAwayTeam
            itemView.txtScore.text = event.intHomeScore + "  vs " + event.intAwayScore

            itemView.img_home.loadImage(event.strHomeTeam)
            itemView.img_away.loadImage(event.strAwayTeam)

            itemView.setOnClickListener{
                val position = adapterPosition
                val events: MatchEvent = eventList[position]
                logD("RecyclerView", events.toString())
                val intent: Intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(TAG, events)
                context?.startActivity(intent)
            }
        }

    }

}