# TrendingRepoFinder
A project that scrapes top trending projects and watches these projects with release only mode
There are two functions with this project: 
1. Find top n trending repos and save their details in a local CSV file.
2. Get top trending repos watched by user's accout with release-only mode.


## Project.java
The class of a project, it has attributes such as organization, name, starGazer, forks and mainContributors.

## Scrapper.java
This class has three methods. 
* *getTrendingProjects()* saves top trending projects in a static arraylist **projects**.
* *writeToCSVFile()* writes projects in **projects** into a CSV file.
* *getProjects()* takes in four parameters: spokenlanguage is the linguistic language of project, language is the programming language mainly used in project, dateRange is the time period that the user wish to search for, and number is the number of projects user wants to see.
This class mainly implents JSOUP library to parse HTML of github page and obtain the project attributes.

## WatchRepos.java
This class is used to set the trending repos under 'watch', with releases-only mode.
WatchRepos.java implements WebDriver by Selenium.

# Author
Built by Anbang on 17th November.
