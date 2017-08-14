#!/bin/bash

echo ">>> RUN THIS ONLY ONCE BEFORE RUNNING INTEGRATION TESTS <<<"

echo ">>> CREATING SELENOID FOLDER <<<"
mkdir /etc/selenoid
cp browsers.json /etc/selenoid

echo ">>> PULLING BROWSERS DOCKER IMAGES <<<"
docker pull selenoid/vnc:opera_47.0
docker pull selenoid/vnc:chrome_60.0
docker pull selenoid/vnc:firefox_54.0
