#!/usr/bin/bash
set -e

dtk k6 run -v ./src/main/resources/k6.script/rateLimit.js
