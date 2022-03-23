package com.study.tastingnote.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.study.tastingnote.R
import com.study.tastingnote.data.model.TrackResult
import com.study.tastingnote.data.room.Liquor
import com.study.tastingnote.data.room.LiquorDao
import com.study.tastingnote.databinding.ItemLiquorListBinding

class TrackAdapter : RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {
    val trackList = ArrayList<TrackResult>()
    val trackWriteList = ArrayList<Liquor>()
    private var touchEndScrollListener: OnTouchEndScrollListener? = null
    private var touchItemListener: OnItemClickListener? = null

    interface OnTouchEndScrollListener {
        fun onTouchEndScroll()
    }

    interface OnItemClickListener{
        fun onItemClick(track:TrackResult,position: Int)
    }

    fun setTouchItem(Listener: OnItemClickListener) {
        touchItemListener = Listener
    }

    fun setTouchEndScroll(listener: OnTouchEndScrollListener) {
        touchEndScrollListener = listener
    }

    fun setTrackList(list: ArrayList<TrackResult>) {
        trackList.clear()
        trackList.addAll(list)
        notifyDataSetChanged()
        //notifyDataSetChanged말고 다른 notify 함수들 잘 쓰는게 좋다
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val binding: ItemLiquorListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_liquor_list, parent, false
        )
        return TrackViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.onBind(trackList[position])

        if (trackList.size - position == 1) {
            touchEndScrollListener?.onTouchEndScroll()
        }
    }

    override fun getItemCount(): Int {
        return trackList.size
    }

    fun addLast(track: TrackResult) {
        trackList.add(track)
    }

    fun addWriteList(track:Liquor) {
        trackWriteList.add(track)
    }

    fun removeAll() {
        trackList.clear()
        notifyDataSetChanged()
    }

    inner class TrackViewHolder(private val binding: ItemLiquorListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(track: TrackResult) {
            itemView.setOnClickListener {
                val pos = adapterPosition
                if(pos!= RecyclerView.NO_POSITION) {
                    touchItemListener?.onItemClick(track,pos)
                }
            }
            binding.trackItem = track
            if (track.isWriteTrack) {
                binding.trackListButton.setImageResource(R.drawable.ic_action_format_list_bulleted)
                binding.executePendingBindings()
            }
        }
    }
}