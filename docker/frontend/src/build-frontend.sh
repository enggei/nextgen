#!/usr/bin/env sh

#chmod 600 /root/.ssh/id_rsa

npm set prefix=/tmp

echo "INSTALLING"
npm install --loglevel=warn

echo "BUILDING"
#npm run build:production
npm run build
