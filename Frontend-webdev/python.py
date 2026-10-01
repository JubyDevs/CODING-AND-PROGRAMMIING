# Electricity Bill Calculator

# units = float(input("Please enter the unit consumed: "))
# total = 0

# if units <= 100:
#     total = units * 20
# elif units <= 200: 
#     total = units * 30
# else:
#     total = units * 50

# print(f"Your total bill is ${total}")

Moderate
# Largest of three numbers

# a = float(input("Enter the first number: "))
# b = float(input("Enter the second number: "))
# c = float(input("Enter the third number: "))

# if a > b and a > c: 
#     print(f"{a} is the largest number")
# elif b > a and b > c: 
#     print(f"{b} is the largest number")
# else:
#     print(f"{c} is the largest number")


# Temperature converter

# temp = float(input("Enter the temperature in Celsius: "))
# F = (temp * 9/5) + 32
# print(f"The temperature in Fahrenheit is {F}F")


# ATM Withdrawal System

# balance = 100000
# withdrawal = float(input("Enter withdrawal amount: "))

# if withdrawal > balance:
#     print("Insufficient Funds")

# if withdrawal <= balance:
#     balance = balance - withdrawal
#     print(f"Your new balance is {balance}")

# if withdrawal <= 0:
#     print("Invalid Amount")

# Multiplication Table Generator

# num = int(input("Enter your number (1 - 12)"))
# for i in range(1, 13):
#     print(f"{num} X {i} = {num * i}")

# Password Strength Checker

# password = input("Enter your password: ")
# pass_length = len(password)

# if pass_length < 6:
#     print("Weak Password")
# elif pass_length > 6 and pass_length < 9:
#     print("Moderate Password")
# else: 
#     print("Strong Password")

# Area of a Circle

# radius = float(input("Enter the radius: "))

# area = 3.142 * (radius ** 2)
# print (f"Area of a circle: {round(area, 2)}")

# Number Checker

# num = int(input("Enter a number: "))

# if num < 0:
#     print("This is a negative number")
# elif num > 0:
#     print("This is a positive number")
# else: 
#     print("This number is Zero")

# Blood Donation

# age = int(input("Enter your age: "))
# weight = float(input("Enter your weight: "))

# if age < 18 or age > 65:
#     print("Not Eligible to donate blood. Age must be between 18 and 65")
# elif weight < 50:
#     print("Not Eligible to donate blood. Weight must be more than 50kg")
# else: 
#     print("Eligible to donate blood")

# Temperaturer Category

# temp = float(input("Enter your temperate in Celcuis: "))

# if temp < -50 or temp > 60:
#     print("Invalid Temperature")
# elif temp > 35:
#     print("Hot")
# elif temp >= 25 and temp <= 35:
#     print("Warm")
# elif temp >= 15 and temp <= 24:
#     print("Mild")
# elif temp >= 5 and temp <= 14:
#     print("Cold")
# else:
#     print("Freezing")

# Discount Calculator

# purchase = float(input("Enter your purchase amount: "))
# discount = 0

# if purchase >= 10000:
#     discount = 0.20 * purchase
# elif purchase >= 5000:
#     discount = 0.15 * purchase
# elif purchase >= 2000:
#     discount = 0.1 * purchase
# else:
#     discount = 0.05 * purchase

# print(f"Original Purchase Amount: {purchase}")
# print(f"Your discount is: {discount}")
# print(f"Your final Purchase Amount is: {purchase - discount}")

# Body Mass Index Calculator

weight = float(input("Enter your weight: "))
height = float(input("Enter your height in meters: "))
bmi = weight / (height * height)
bmi = round(bmi, 2)

if bmi < 18.5:
    print(f"Your BMI is: {bmi} \n Category: Underweight")
elif bmi >= 18.5 and bmi <= 24.9:
    print(f"Your BMI is: {bmi} \n Category: Normal")
elif bmi >= 25 and bmi <= 29.9:
    print(f"Your BMI is: {bmi} \n Category: Overweight")
else:
    print(f"Your BMI is: {bmi} \n Category: Obese")

