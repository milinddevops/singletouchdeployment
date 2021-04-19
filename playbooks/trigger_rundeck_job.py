#!/usr/bin/env python2

from rundeck.client import Rundeck
# API TOKEN VDt13OzdgWu1qQt6o8DPsj8jRflT1Jxx
rd = Rundeck('rundeck.server.com', api_token='VDt13OzdgWu1qQt6o8DPsj8jRflT1Jxx')

rd.run_job('221626d6-b4d4-48ed-bc92-9b5e0985febb', argString={'build_id':'pet-clinic_178'})
