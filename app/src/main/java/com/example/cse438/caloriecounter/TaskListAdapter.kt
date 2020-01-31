package com.example.cse438.caloriecounter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class TaskListAdapter(private var activity: Activity, private var items1: ArrayList<String>, private var items2: ArrayList<String>): BaseAdapter() {

    /**
     * Need to override the ViewHolder method
     */
    private class ViewHolder(row: View?) {
        var foodName: TextView? = null
        var calorieNumber: TextView? = null

        init {
            this.foodName = row?.findViewById(R.id.foodName)
            this.calorieNumber = row?.findViewById(R.id.calorieNumber)
        }
    }

    /**
     * Displays the information in the row format we want
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater =
                activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.task_list_row, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }


        val food = items1[position]
        val calorie = items2[position]
        viewHolder.foodName?.text = food
        viewHolder.calorieNumber?.text = calorie

        return view as View
    }

    override fun getItem(position: Int): Any {
        return items1[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items1.size
    }
}

