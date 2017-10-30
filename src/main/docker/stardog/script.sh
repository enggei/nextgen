#!/usr/bin/env bash
function_to_fork() {

  response=$(curl --write-out %{http_code} --silent --output /dev/null http://localhost:5820)
  until [ $response -eq 401 ]; do
    printf '.'
    sleep 5
    response=$(curl --write-out %{http_code} --silent --output /dev/null http://localhost:5820)
  done

  cd ${STARDOG_LOCATION}/bin/

  echo 'Creating test database'
  ./stardog-admin db create -n test \
    -o security.named.graphs=true \
    icv.enabled=true \
    icv.reasoning.enabled=true \
    preserve.bnode.ids=true \
    query.all.graphs=true \
    reasoning.type=SL \
    --

}

function_to_fork &

rm -f ${STARDOG_HOME}system.lock
rm -r -f ${STARDOG_HOME}.spilling

if [ -f /production-license/stardog-license-key.bin ]; then
    cp /production-license/stardog-license-key.bin {$STARDOG_HOME}
  else
    cp /${LICENSE} ${STARDOG_HOME}
fi

/home/stardog/app/stardog-5.0.4/bin/stardog-admin server start --foreground $1
