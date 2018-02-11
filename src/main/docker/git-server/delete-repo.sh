#!/bin/sh

if [ "$#" -ne 1 ]; then
    echo "Expecting repo name"
    exit 1
fi

REPO=$1

cd /git-server/repos

rm -Rf ${REPO}.git
