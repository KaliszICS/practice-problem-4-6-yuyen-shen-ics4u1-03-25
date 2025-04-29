[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=19369398)
# Instructions  


Create the a Person class with the following:

Instance Variables:

String firstname</br>
String lastname</br>
int birthDay</br>
int birthMonth</br>
int birthYear</br>
String ssn</br>
int numberOfSiblings</br>
Person[] siblings</br>

All variables above should be private.</br>
Default value of numberOfSiblings is 0.</br>
Default value of Siblings is an empty Person array.</br>

Constructor

The main constructor should take in all values, except the numberOfSiblings and Siblings, and assign them to their respective private class variables

Methods

Create getters and setters for firstname and lastname:</br>
Create a getter method called getBirthday, which will return a String composed of their birthday in day/month/year format. For example, if birthday=22, birthmonth=3, birthyear=2000, it should return the String "22/3/2000"</br>
Create a public method called addSibling that takes a Person as a parameter, adding them as a sibling to the Siblings array.</br>
To do this you will need to make a larger array. You will need to copy the array to do this. Search up methods to do this or use the one you already know. You must also increase the number of siblings by one.  You can import the Arrays class to help you do this.</br>
Create a getter method called getSiblings that returns an array of Persons that are siblings.

  
