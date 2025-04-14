#!/usr/bin/env bash

# Java 17 をインストールしてJAVA_HOMEを設定
echo "Installing Java 17..."
sudo apt-get update
sudo apt-get install -y openjdk-17-jdk

export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH

# Gradleビルド
./gradlew clean build

