#!/bin/bash
mvn clean install -DskipTests=true
docker build . -t hrd-registry.hrd.cloudzcp.net/clouddance-test/my-page-service:0.1.0
docker push hrd-registry.hrd.cloudzcp.net/clouddance-test/my-page-service:0.1.0
