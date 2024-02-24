#!/bin/bash

# Set threshold for disk space in percentage
THRESHOLD=10

# Set log file path
LOG_FILE="E:\ITI\Data Management Track\Case Study\Bash Scripts\Disk Space\logfile.log"

# Check disk space usage (assuming C: drive, change if necessary)
DISK_SPACE=$(wmic logicaldisk where "DeviceID='C:'" get FreeSpace | awk 'NR==2' | sed 's/[^0-9]*//g')
TOTAL_SPACE=$(wmic logicaldisk where "DeviceID='C:'" get Size | awk 'NR==2' | sed 's/[^0-9]*//g')
USED_SPACE=$((100 - DISK_SPACE * 100 / TOTAL_SPACE))

# Check if disk space is above threshold
if [ "$USED_SPACE" -ge "$THRESHOLD" ]; then
    # Write alert message to log file
    MESSAGE="Disk space on server is running low. Current usage is $USED_SPACE%."
    echo "$(date '+%Y-%m-%d %H:%M:%S') - $MESSAGE" >> "$LOG_FILE"
fi
