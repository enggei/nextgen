#!/bin/sh

if [ "$#" -ne 1 ]; then
    echo "Expecting repo name"
    exit 1
fi

NEW_REPO=$1

cd /git-server/repos

mkdir ${NEW_REPO}.git
cd ${NEW_REPO}.git
#git init --shared=true
git init --bare

cd ..
chown -R git:git ${NEW_REPO}.git
