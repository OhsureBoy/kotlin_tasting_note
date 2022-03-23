package com.study.tastingnote.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.study.tastingnote.R
import com.study.tastingnote.data.room.Liquor
import com.study.tastingnote.databinding.ItemWriteLiquorListBinding

class WriteTrackAdapter : RecyclerView.Adapter<WriteTrackAdapter.WriteTrackViewHolder>() {
    var writeTrack  = ArrayList<Liquor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WriteTrackViewHolder {
        val binding: ItemWriteLiquorListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_write_liquor_list, parent, false
        )
        return WriteTrackViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WriteTrackViewHolder, position: Int) {
        holder.onBind(writeTrack[position])
    }

    override fun getItemCount(): Int {
        return writeTrack.size
    }

    fun addWriteTrack(track: Liquor) {
        writeTrack.add(track)
    }

    inner class WriteTrackViewHolder(private val binding: ItemWriteLiquorListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(track: Liquor) {
            itemView.setOnClickListener {
                val pos = adapterPosition
                if(pos!= RecyclerView.NO_POSITION) {

                }
            }
            binding.trackItem = track
        }
    }
}