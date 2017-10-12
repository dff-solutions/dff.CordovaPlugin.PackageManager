#!/bin/bash

xmlpre='<source-file src='
xmlpost=' />'
platform="main/java"

for file in $(find src/main/java -name '*.java'); do
    file=${file/.\/}
    dir=$(dirname $file)
    dir=${dir/$platform\/}
    echo $xmlpre\"$file\" target-dir=\"$dir\"$xmlpost
done