# Canadian Wildfires and Their Effect on Air Quality in US Cities

## Description
In this project, we aim to analyze the effect that the Canadian Wildfires had on the Air Quality in US Cities.

## Table of Contents
1. [Acquisition](#acquisition)
2. [Data Wrangling](#data-wrangling)
3. [Data Visualization](#data-visualization)
4. [Challenges Experienced](#challenges-experienced)
5. [Potential Challenges](#potential-challenges)
6. [Future Use](#future-use)

### Acquisition
In this section, we collect the necessary data for our analysis. We scrape Wikipedia to obtain a list of the most populous US cities, acquire latitude and longitude data through the open-meteo API, and create a DataFrame that links cities and states with their respective IDs and coordinates. We also define functions to fetch all required data from the open-meteo API.

### Data Wrangling
Here, we clean and prepare the data for analysis. We create two dictionaries, one for daily data and one for monthly data. The DataFrames were made while looping through the data that was pulled from the API, and then each DataFrame was stored under one cityID key. We conduct checks to ensure data completeness and correctness.

## Data Visualization
In this section, we present visualizations to gain insights into the effect of Canadian wildfires on air quality in US cities:

1. This visualization shows distribution shapes of weather data and air quality for New York City.
2. A comparison of mean temperatures and humidity levels in New York City (NYC) and Philadelphia.
3. A segmented color map illustrating PM2.5 levels in New York City (NYC).
4. Chart stacks depicting air quality changes over the year for NYC.
5. Chart stacks depicting air quality changes over the year for Philadelphia.
6. Chart stacks depicting air quality changes over the year for LA.
7. Monthly PM2.5 Air Quality Index (AQI) for March through November in Philadelphia.

## Challenges Experienced
During the development of this project, we encountered some challenges:
- The original data source (open-weather) had more robust and well-formatted data, but it had a rate-limited API, which would have restricted the project's scope.
- The way open-meteo separates its air quality data makes analysis more challenging.

## Potential Challenges
As this project is focused on the most populous US cities, there are potential challenges to consider for future expansion:
- To include more cities in the analysis, one would need to find exact coordinates for the additional cities of interest.
- Finding a different source for city data might be necessary if expanding beyond the most populous cities.

## Future Use
This project is designed to be a starting point for further analysis and development. Feel free to use the code and documentation to expand or modify the project as needed. By using this project, you agree to follow the access rights and terms of service laid out by Wikipedia and Open-Meteo. We encourage you to review their official documentation and guidelines for comprehensive details on data usage and licensing.