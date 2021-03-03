#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i ~/.ssh/sweater-vstu.pem \
    target/sweater.jar \
    ec2-user@ec2-13-51-85-221.eu-north-1.compute.amazonaws.com:/home/ec2-user/

echo 'Restart server...'

ssh -i ~/.ssh/sweater-vstu.pem ec2-user@ec2-13-51-85-221.eu-north-1.compute.amazonaws.com << EOF

pgrep java | xargs kill -9
nohup java -jar sweater.jar > log.txt &

EOF

echo 'Bye!'
