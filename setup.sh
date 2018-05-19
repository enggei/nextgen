#!/usr/bin/env bash
#set -e

checkPrerequisites() {
  name=$1[@]
  prerequisites=("${!name}")
  for c in "${prerequisites[@]}"; do
    hash ${c} 2>/dev/null || { echo >&2 "'$c' is not installed.
Aborting.
"; exit 1; }
  done
}

build() {
  echo "### BUILDING $1"
  docker-compose build $1
  return $?
}

buildAndStart() {
  name=$1[@]
  containers=("${!name}")
  for c in "${containers[@]}"; do
    build ${c} && start ${c}
  done
}

start() {
  echo "### STARTING $1"
  docker-compose up -d $1
  return $?
}

buildComponent () {
  mvn install -T 2C -pl components/$1 -am -DskipTests -B
  if [[ "${2}" != "install" ]] ; then
    docker-compose build $1
    docker-compose up -d $1
#    docker-compose restart nginx
  fi
}

updateFrontend() {
  cd docker/frontend

  if [ ! -d "src/nextgen-frontend" ]; then
    git clone ssh://git@github.com:sogern/nextgen-frontend.git src/nextgen-frontend
    ./build.sh
  fi

  cd src/nextgen-frontend
  git fetch

  if  git status | grep -q "Your branch is up-to-date with 'origin/" && ! $1; then
    cd ../..
  else
    git pull
    cd ../..

    ./build.sh
  fi

  cd ../..
}

sha1check() {
  if [ "$#" -ne 2 ]; then
    echo "sha1check(): wrong number of arguments, expecting 2"
    return 1
  fi

  echo "### CHECKING $2 in $1"
  current_dir=$(pwd)
  cd $1
#  echo "$current_dir"
#  pwd
  sha1sum --quiet -c $2
  retval=$?

  if [ "$retval" -eq 0 ]; then
    echo "    OK"
  fi

  cd ${current_dir}
  return ${retval}
}

wgetURL() {
  if [ "$#" -lt 1 ] || [ "$#" -gt 2 ]; then
    echo "wgetURL(): wrong number of arguments, expecting 1 or 2"
    return 1
  elif [ "$#" -eq 2 ]; then
    echo "### DOWNLOADING $2 to $1"
    wget -P $1 $2
    return $?
  fi

  echo "### DOWNLOADING $1"
  wget $1
  return $?
}

gitClone() {
  if [ "$#" -lt 2 ] || [ "$#" -gt 3 ]; then
    echo "gitClone(): wrong number of arguments, expecting 2 or 3"
    return 1
  fi

  echo "### CLONING $1 in $2"
  git -C $2 clone $1

  if [ "$#" -eq 3 ]; then
    echo "    SWITCHING TO BRANCH $3"
    git -C $2 checkout $3
  fi

  if [ "$?" -ne 0 ]; then
    echo "    ERROR: $?"
  fi

  return $?
}

gitPull() {
  if [ "$#" -lt 1 ] || [ "$#" -gt 2 ]; then
    echo "gitPull(): wrong number of arguments, expecting 1 or 2"
    return 1
  fi

  echo "### FETCHING $1"
  git -C $1 fetch
  if [ "$?" -ne 0 ]; then
    echo "    ERROR: $?"
    return $?
  fi

  if [ "$#" -eq 2 ]; then
    echo "    SWITCHING TO BRANCH $2"
    git -C $1 checkout $2

    if [ "$?" -ne 0 ]; then
      echo "    ERROR: $?"
      return $?
    fi
  fi

  echo "### PULLING $1"
  git -C $1 pull

  if [ "$?" -ne 0 ]; then
    echo "    ERROR: $?"
  fi

  return $?
}

# TODO: Change to a loop e.g. find *.sha1 files and process
prepareElasticSearch() {
  sha1check "$1/lib" "analysis-icu-6.4.0.sha1"
  if [ "$?" -ne 0 ]; then
    wgetURL "$1/lib" "https://artifacts.elastic.co/downloads/elasticsearch-plugins/analysis-icu/analysis-icu-6.4.0.zip"
    sha1check "$1/lib" "analysis-icu-6.4.0.sha1" || exit 1
  fi
  sha1check "$1/lib" "ingest-attachment-6.4.0.sha1"
  if [ "$?" -ne 0 ]; then
    wgetURL "$1/lib" "https://artifacts.elastic.co/downloads/elasticsearch-plugins/ingest-attachment/ingest-attachment-6.4.0.zip"
    sha1check "$1/lib" "ingest-attachment-6.4.0.sha1" || exit 1
  fi
}

prepareHazelcast() {
  sha1check "$1/lib" "jackson-annotations-2.9.5.sha1"
  if [ "$?" -ne 0 ]; then
    wgetURL "$1/lib" "http://search.maven.org/remotecontent?filepath=com/fasterxml/jackson/core/jackson-annotations/2.9.5/jackson-annotations-2.9.5.jar"
    sha1check "$1/lib" "jackson-annotations-2.9.5.sha1" || exit 1
  fi
  sha1check "$1/lib" "jackson-core-2.9.5.sha1"
  if [ "$?" -ne 0 ]; then
    wgetURL "$1/lib" "http://search.maven.org/remotecontent?filepath=com/fasterxml/jackson/core/jackson-core/2.9.5/jackson-core-2.9.5.jar"
    sha1check "$1/lib" "jackson-core-2.9.5.sha1" || exit 1
  fi
  sha1check "$1/lib" "jackson-databind-2.9.5.sha1"
  if [ "$?" -ne 0 ]; then
    wgetURL "$1/lib" "http://search.maven.org/remotecontent?filepath=com/fasterxml/jackson/core/jackson-databind/2.9.5/jackson-databind-2.9.5.jar"
    sha1check "$1/lib" "jackson-databind-2.9.5.sha1" || exit 1
  fi
  sha1check "$1/lib" "jul-to-slf4j-1.7.25.sha1"
  if [ "$?" -ne 0 ]; then
    wgetURL "$1/lib" "http://search.maven.org/remotecontent?filepath=org/slf4j/jul-to-slf4j/1.7.25/jul-to-slf4j-1.7.25.jar"
    sha1check "$1/lib" "jul-to-slf4j-1.7.25.sha1" || exit 1
  fi
  sha1check "$1/lib" "logback-classic-1.2.3.sha1"
  if [ "$?" -ne 0 ]; then
    wgetURL "$1/lib" "http://search.maven.org/remotecontent?filepath=ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar"
    sha1check "$1/lib" "logback-classic-1.2.3.sha1" || exit 1
  fi
  sha1check "$1/lib" "logback-core-1.2.3.sha1"
  if [ "$?" -ne 0 ]; then
    wgetURL "$1/lib" "http://search.maven.org/remotecontent?filepath=ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar"
    sha1check "$1/lib" "logback-core-1.2.3.sha1" || exit 1
  fi
  sha1check "$1/lib" "logstash-logback-encoder-4.11.sha1"
  if [ "$?" -ne 0 ]; then
    wgetURL "$1/lib" "http://search.maven.org/remotecontent?filepath=net/logstash/logback/logstash-logback-encoder/4.11/logstash-logback-encoder-4.11.jar"
    sha1check "$1/lib" "logstash-logback-encoder-4.11.sha1" || exit 1
  fi
  sha1check "$1/lib" "slf4j-api-1.7.25.sha1"
  if [ "$?" -ne 0 ]; then
    wgetURL "$1/lib" "http://search.maven.org/remotecontent?filepath=org/slf4j/slf4j-api/1.7.25/slf4j-api-1.7.25.jar"
    sha1check "$1/lib" "slf4j-api-1.7.25.sha1" || exit 1
  fi
}

waitForDocker() {
  # Initial sleep to make sure docker has started
  sleep 5

  while : ; do
    # Get cpu % from docker stats, remove '%' and then sum all the values into one number
    CPU=`docker stats --no-stream --format "{{.CPUPerc}}" | awk '{gsub ( "[%]","" ) ; print $0 }' | awk '{s+=$1} END {print s}'`
    echo "CPU: $CPU%"

    # Do floating point comparison, if $CPU is bigger than 15, WAIT will be 1
    WAIT=`echo $CPU'>'15 | bc -l`
    echo "WAIT (0/1): $WAIT"

    # Break from loop if WAIT is 0, which is when the sum of the cpu usage is smaller than 15%
    [[ "$WAIT" -eq 0 ]] && break

    # Else sleep and loop
    echo "Waiting for docker"
    sleep 5
    free -m
  done
}

# Check prerequisites
declare -a prerequisites=("bc")
checkPrerequisites prerequisites

# ASCII art generated with http://patorjk.com/software/taag/
# "Elite" font
echo "
 ▐ ▄ ▄▄▄ .▐▄• ▄ ▄▄▄▄▄ ▄▄ • ▄▄▄ . ▐ ▄
•█▌▐█▀▄.▀· █▌█▌▪•██  ▐█ ▀ ▪▀▄.▀·•█▌▐█
▐█▐▐▌▐▀▀▪▄ ·██·  ▐█.▪▄█ ▀█▄▐▀▀▪▄▐█▐▐▌
██▐█▌▐█▄▄▌▪▐█·█▌ ▐█▌·▐█▄▪▐█▐█▄▄▌██▐█▌
▀▀ █▪ ▀▀▀ •▀▀ ▀▀ ▀▀▀ ·▀▀▀▀  ▀▀▀ ▀▀ █▪
"

case $1 in
  all | all-nogui)
#    declare -a containers=("stardog" "elasticsearch" "elasticsearchlogs" "kibana" "fluentd" "web" "gitserver" "hazelcast")
#    prepareElasticSearch docker/elasticsearch

    prepareHazelcast docker/hazelcast

    if [[ "${1}" != "all" ]] ; then
      # TODO: Find better way
      export COMPOSE_FILE=docker-compose.yml:docker-compose.override.yml:docker-compose.nogui.yml
    else
        updateFrontend false
    fi

    # EFK
    docker-compose build
    docker-compose up -d elasticsearchlogs
    sleep 5
    docker-compose up -d fluentd
    sleep 5
    docker-compose up -d hazelcast

    # Components
    buildComponent api
    buildComponent vertx-fatjar-test

    docker-compose up -d

    # Wait for everything to calm down
    waitForDocker
    docker-compose restart nginx
    ;;

  stardog | elasticsearchlogs | kibana | fluentd | nginx | gitserver)
    build $1 && start $1
    ;;

  hazelcast)
    prepareHazelcast docker/hazelcast

    build $1 && start $1
    ;;

  api)
    buildComponent $1
    ;;

  elasticsearch)
    prepareElasticSearch docker/elasticsearch

    build $1 && start $1
    ;;

  efk)
    declare -a containers=("elasticsearchlogs" "kibana" "fluentd")
    buildAndStart containers
    ;;

  frontend)
    updateFrontend true
    docker-compose build frontend
    docker-compose up -d frontend
    sleep 2
    docker-compose restart nginx
    ;;

  scale)
    docker-compose scale $2
    ;;

  list)
    echo -e "Build options:\n
  - all
  - all-nogui
  - api
  - efk
  - elasticsearch
  - elasticsearchlogs
  - fluentd
  - frontend
  - gitserver
  - hazelcast
  - kibana
  - nginx
  - stardog
"
    ;;
  *)
    echo -e "Usage:\n'$0 list' to display available options
'$0 all'  to build everything
'$0 scale <container>' to scale up/down instances"
    ;;
esac

# Cleanup dangling images
docker image prune -f
