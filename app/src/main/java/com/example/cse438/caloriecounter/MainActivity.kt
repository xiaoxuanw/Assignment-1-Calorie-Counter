package com.example.cse438.caloriecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.view.LayoutInflater
import android.app.AlertDialog
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.enter_total_calories.*
import kotlinx.android.synthetic.main.enter_total_calories.view.*



class MainActivity : AppCompatActivity() {

    //List of food items the user enters
    private var listOfFood = ArrayList<String>()
    private var listOfCalorie = ArrayList<String>()


    // Text and List views
    private var listView: ListView? = null
    private var calorieTotal = 0
    private var calorieRemaining = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set up functions
        getInitial()
        dialogView()
    }
        /**
         * Assigns the list and text view to their respective views
         */
        private fun getInitial() {
            //xml view
            listView= Items

            // Setting up the adapter using our custom built adapter
            val adapter = TaskListAdapter(this, listOfFood,listOfCalorie)
            listView?.adapter = adapter

            adapter.notifyDataSetChanged()


        }
    /**
     * Displays the dialog box asking the user for total calories
     */
    private fun dialogView() {
        // Opens the dialog view asking the user for
        val dialogView = LayoutInflater.from(this).inflate(R.layout.enter_total_calories, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle("Enter total calories")
        val mAlertDialog = mBuilder.show()

        // Sets an onclick listener on the dialog box button
        mAlertDialog.submitCalories.setOnClickListener {
            val totalStartCal = dialogView.totalCalories.text.toString()
            // If the string is empty, we do not want to accept that as an input
            if(totalStartCal != ""){
                caloriesRemainingNum.text = totalStartCal
                calorieRemaining = Integer.parseInt(totalStartCal)

                mAlertDialog.dismiss()
            }
        }
    }
    /**
     * Handler for adding a new item
     */
    fun addFood(view: View?){
        val foodToAdd = newFood.text.toString()
        val calorieToAdd= newCalorie.text.toString()
        val exerciseToAdd = newExercise.text.toString()
        val calorieToSubtract = newCalorie.text.toString()

        //Error message if both food and exercise are empty or calories is empty
        if((foodToAdd == "" && exerciseToAdd == "")||(calorieToAdd=="")){
            val myToast = Toast.makeText(this, "Please enter valid values", Toast.LENGTH_SHORT)
            myToast.show()
        }
        //Error message if both food and exercise fields are filled in, we only want one item
        if(foodToAdd != "" && exerciseToAdd!=""){
            val secondToast = Toast.makeText(this,"Please Only Enter One Item", Toast.LENGTH_SHORT)
            secondToast.show()
        }
        else{
            // Add food item, add new food calories to total calories consumed, subtract new food calories from calories remaining.
            if(foodToAdd != "" && calorieToAdd != ""){
            listOfFood.add(foodToAdd)
            listOfCalorie.add(calorieToAdd)


            calorieTotal += Integer.parseInt(calorieToAdd)
            caloriesTotalNum.text = calorieTotal.toString()
            calorieRemaining -= Integer.parseInt(calorieToAdd)
            caloriesRemainingNum.text = calorieRemaining.toString()


            (listView?.adapter as? TaskListAdapter)?.notifyDataSetChanged()

        }
            //Add exercise item, subtract calories burned from exercise from total calories consumed,
            // add calories burned from exercise to calories remaining
            if(exerciseToAdd!="" && calorieToAdd!="") {
                listOfFood.add(exerciseToAdd)
                listOfCalorie.add(calorieToSubtract)


                calorieTotal -= Integer.parseInt(calorieToSubtract)
                caloriesTotalNum.text = calorieTotal.toString()
                calorieRemaining += Integer.parseInt(calorieToSubtract)
                caloriesRemainingNum.text = calorieRemaining.toString()

            }
            (listView?.adapter as? TaskListAdapter)?.notifyDataSetChanged()


        }
        // set text of number of calorie remaining to red if calorie remaining is negative
        if(calorieRemaining<0){
            caloriesRemainingNum.setTextColor(-0x10000)
        }

    }

}


