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

 1. (5/5 Points) User can enter total calorie amount on start up 
2. (5/5 Points) User can add new food item by name 
3. (5/5 Points) User can add new food item by calorie 
4. (5/5 Points) Calories remaining is updated with each new food item 
5. (5/5 Points) Calorie consumed is updated with each new food item
 6. (5/5 Points) The list of food items displays foods and their respective calories amounts 
7. (3/3 Points) Color change when calorie count becomes negative 
8. (5/5 Points) All inputs are filtered and error messages are displayed accordingly 
9. (4/4 points) The design and implementation of the User Interface is clean 
10. (6/8 Points) Creative portion - design your own feature(s)! 

The basic functionality of the app worked well and looked good.

I have some issues with how your creative portion is implemented. I think that having two items (food and exercise) tied to one submit button is confusing. It took me multiple tries to understand how I could enter the two different things. It feels very strange to leave a box empty when you submit something.

Also, in the list there is no way to distinguish between the two things. I cannot tell how the math is being computed because it is not clear to me which numbers are from calories and which are from exercise.

This feature is a good one, I just think it could have used a little more time to make it well integrated with the rest of the app.

Overall, great job!

Total: 48 / 50