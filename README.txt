In this file you should include:

Any information you think we should know about your submission
* Is there anything that doesn't work? Why?
No, everything works.
* Is there anything that you did that you feel might be unclear? Explain it here.
The getView function in task list adapter. I spent quite a time to figure out how convert view and inflator work.

A description of the creative portion of the assignment
* Describe your feature
I added a feature that allows user to enter exercises into the diary. When an exercise is added, Calories Consumed is subtracted by the calories burned by exercise, meaning that the calories you ate is burned by the exercise you did. Calories burned by exercise is added to Calories Remaining since it basically means that you can consume more after exercising. 
* Why did you choose this feature?
I think it is important to notice that total calories you can consume don't only depend on the food you eat, but also on the exercise you do. If you do a lot of exercise that day, then you need to consume more calories in order to maintain health.
* How did you implement it?
I added a line that asks user to enter Exercise on top of "Enter Food" in the activity_main xml. In "addItem" function in mainActivity.kt, I promted an error message if user enters both food and exercise. I used a if statement to implement, if exercise and calories are entered, then add item to the list and subtract calories from Calories Consumed and add calories to Calories Remaining.
