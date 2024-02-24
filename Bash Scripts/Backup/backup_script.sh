#!/bin/bash

db_owner=CASESTUDY
pass=123
db=XE
direct="E:\ITI\Data Management Track\Case Study\Bash Scripts\Backup"
d=$(date +"%Y%m%d_%H%M%S")
file_name="backup_${d}.dmp"

expdp ${db_owner}/${pass}@${db} DUMPFILE=${file_name}  DIRECTORY=BACKUP_CASESTUDY;

if [ $? -eq 0 ]; then
	echo " Make Backup Successfully " >> "${direct}/backupLogs.log"
else 
	echo " ERROR : Make Backup Failed " >> "${direct}/backupLogs.log"
fi

