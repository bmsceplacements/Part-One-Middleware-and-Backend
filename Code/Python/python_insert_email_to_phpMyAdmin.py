#!/usr/bin/env python
# coding: utf-8

# In[1]:


# Import all the necessary modules
import csv
import pandas as pd
import numpy as np


# In[2]:


# pymysql is the middleware to connect a database with python programming
import pymysql


# In[3]:


#NOTE: If importing a module gives an error message like this: No module named 'pymysql' 
#then use this snippet in your jupyter notebook
#import sys
#!{sys.executable} -m pip install pymysql


# In[4]:


#Get the working directory for your code if necessary
import os
print(os.getcwd())


# In[5]:


#ress.csv is the name of the stylesheet
file1=pd.read_csv("ress.csv")


# In[6]:


file1.head()


# In[7]:


#Create a dataframe
df=pd.DataFrame(file1)


# In[8]:


#Get the name and email of the registered students
df[["Email Address","Full Name"]]


# In[9]:


#Retrieve the email address of all students and append it into a list
email=df["Email Address"].values.tolist()


# In[10]:


print(email)


# In[12]:


#Same for the name
names=df["Full Name"].values.tolist()


# In[13]:


print(names)


# In[14]:


#Before we connect the database to the phpmyadmin where want to store our database, we need to write the INSERT sql query for
# the same
print("INSERT INTO student(Name, Email) VALUES('"+names[0]+"','"+email[0]+"');")


# In[15]:


connection = pymysql.connect(host="localhost", user="root", passwd="", database="bmsceplacements")
cursor = connection.cursor()
for i in range(len(email)):
    insert1 = "INSERT INTO student(Name, Email) VALUES('"+names[i]+"','"+email[i]+"');"
    cursor.execute(insert1)
connection.commit()
connection.close()
print("Email id and names sent to the database successfully")

