#!/usr/bin/env sh

cd nextgen-frontend

npm set prefix=/tmp

echo "INSTALLING"
npm install --loglevel=warn

echo "BUILDING"
#npm run build:production
npm run build
