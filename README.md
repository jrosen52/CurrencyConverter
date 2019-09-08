# CurrencyConverter
First CS441 Project

For our first project, we were assigned to create a units converter app. I decided that currency would be an interesting 
unit to convert, so I created an app that would perform an exchange between two different countries' currency. One of the
benefits of using currency as a unit is that there are numerous currencies around the world that can be added to the app, 
while other units like the metric system are more limited. However, a downside of choosing currency is that the value of 
countries' currency can change, so without updates the app only reflects the values at the time the exchange rate is saved 
in the file.

The way the app works is fairly simple. An edit text view takes in a double value. One spinner is used to choose the 
currency of the inputed value, and another spinner is the currency that the value is converted to. One the button is clicked, 
a calculation runs on the input and the output is placed in the bottom of the screen. How the calculation works is that every
currency is given an exchange value, all of which is relative to the American Dollar. So the dollar value is 1.00, the Euro is
.91, the Peso is 19.79, and so on. When the button is clicked, the inputed value is divided by the first currency value, and 
then multipled by the second currency value. The resulting value will be the correct exchange amount for the input.

Here is documentation for each git commit, and any relative citations:

August 28: Created the project and repository

August 30: Added code that creates a custom spinner object (based on demonuts https://demonuts.com/android-spinner/)

September 3: Spinner was not working as intended, so fixes were attempted

September 4: Added a new file that fixed the spinner issue, again based of the implementation from demonuts

September 5: Added code for edit text view and button. Text watcher was implemented with help from stackexchange (https://stackoverflow.com/questions/8543449/how-to-use-the-textwatcher-class-in-android)

September 6: Changed the colors of the views and added function for calculation

September 7: Connected the calculation function to button to get a result

September 8: Final touches on design and added more currencies
