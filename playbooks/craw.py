#!/usr/bin/env python2

import pysnow 
from rundeck.client import Rundeck

# Create a function to trigger the Rundeck deploy job
def trigger_rundeck_job():
    # API TOKEN VDt13OzdgWu1qQt6o8DPsj8jRflT1Jxx
    rd = Rundeck('10.125.214.180', api_token='VDt13OzdgWu1qQt6o8DPsj8jRflT1Jxx')

    rd.run_job('221626d6-b4d4-48ed-bc92-9b5e0985febb')

# Create client object
c = pysnow.Client(instance='dev88678', user='admin', password='GQu1rjWXcUj4')

# Define a resource, here we'll use the incident table API
incident = c.resource(api_path='/table/change_request')

# Query for incidents with state 1
response = incident.get(query={'short_description': "This is a test opened by Ansible"}, stream=True)

# Iterate over the result and print out `sys_id` of the matching records.
for record in response.all():
        
    print(record['state'])
    if (record['state'] == "-5") :
        chg_status = 'New'

    elif (record['state'] == "-4") :
        chg_status = 'Assess'

    elif (record['state'] == "-3") :
        chg_status = 'Authorize'

    elif (record['state'] == "-2") :
        chg_status = 'Scheduled'

    elif (record['state'] == "-1") :
        chg_status = 'Implement'
        trigger_rundeck_job()

    elif (record['state'] == "0") :
        chg_status = 'Review'

    elif (record['state'] == "1") :
        chg_status = 'Open'

    elif (record['state'] == "2") :
        chg_status = 'Work in Progress'

    elif (record['state'] == "3") :
        chg_status = 'Closed'

    elif (record['state'] == "4") :
        chg_status = 'Canceled'
    else:
        chg_status = 'No Status found.'

    print(chg_status)

    